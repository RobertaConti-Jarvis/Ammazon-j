import { Component, OnInit } from '@angular/core';
import { CriterioRicercaService } from '../criterio-ricerca.service';
import { Router } from '@angular/router';
import { ReduxService } from '../redux.service';
import { TokenService } from '../token.service';
import { BaseRequestDto } from '../dto/base-request-dto';
import { EsitoUtenteDto } from '../dto/esito-utente-dto';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UtenteRegistrato } from '../entità/utente-registrato';
import { EsitoDto } from '../dto/esito-dto';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['../theme.css'],
})
export class HeaderComponent implements OnInit {
  elementiCarrello: number = this.reduxService.numElementi;

  isTokenReg : boolean = false;
  utenteLoggato : UtenteRegistrato;

  constructor(private criterioRicercaService: CriterioRicercaService,
    private router: Router,
    private reduxService: ReduxService,
    private http: HttpClient,
    public tokenService: TokenService) {

    reduxService.leggiCarrello$.subscribe(
      n => { this.elementiCarrello = n }
    );

    if (tokenService.token != null) {
      this.checkTokenReg();
    }
  }

  ngOnInit(): void { }

  goToResultPage(criterio: string): void {
    console.log("siamo nel result page", criterio);
    this.router.navigateByUrl('/ricerca-catalogo');
    this.criterioRicercaService.notifyCriterion(criterio);
    console.log("siamo in result page", this.router.url);
  }

  checkTokenReg() {
    console.log("sono in checkToken");
    let dto: BaseRequestDto = new BaseRequestDto();
    dto.sessionToken = this.tokenService.token;
    console.log("valore token: ",this.tokenService.token);
    let oss: Observable<EsitoUtenteDto> = this.http.post<EsitoUtenteDto>(
      "http://localhost:8080/check-token-reg", dto
    );
    oss.subscribe(t => {
      if (t.esito) {
        // è un token registrato: nasconde login e registrati e rende visibile logout
        console.log("trovato token registrato");
        this.isTokenReg = true;
        this.utenteLoggato = t.utenteReg;
      }
      else {
        // è un token anonimo: rende visibile login e registrati e nasconde logout 
        console.log("trovato token anonimo");
        this.isTokenReg = false;
      }
      this.tokenService.token = t.sessionToken;  //chiedere se serve farlo
    });
  }

  logout() {
    console.log("sono in logout");
    let dto: BaseRequestDto = new BaseRequestDto();
    dto.sessionToken = this.tokenService.token;
    console.log("valore token: ",this.tokenService.token);
    let oss: Observable<EsitoDto> = this.http.post<EsitoDto>(
      "http://localhost:8080/logout", dto
    );
    oss.subscribe(t => {
      if(t.esito){
        this.tokenService.token = t.sessionToken;
        this.isTokenReg = false;
        this.router.navigateByUrl("/home-page");
      }
      else{
        console.log("errore inatteso!");
      }
    });
  }
}
