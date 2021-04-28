import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { EsitoDto } from '../dto/esito-dto';
import { EsitoUtenteDto } from '../dto/esito-utente-dto';
import { UtenteRegistratoDto } from '../dto/utente-registrato-dto';
import { UtenteRegistrato } from '../entità/utente-registrato';
import { TokenService } from '../token.service';

@Component({
  selector: 'app-gestione-account',
  templateUrl: './gestione-account.component.html',
  styleUrls: ['../theme.css']
})
export class GestioneAccountComponent implements OnInit {

  utenteLoggato: UtenteRegistrato = new UtenteRegistrato();
  notifica : string;

  constructor(private http: HttpClient , private router: Router, public tokenService: TokenService) { 
  }

  ngOnInit(): void {
  }

  receiveUR(uR : UtenteRegistrato){
    console.log("sono in receiveUR()");
    this.utenteLoggato = uR;
    console.log(uR.nome);
    console.log(uR.cognome);
    console.log(uR.codiceFiscale);
  }

  save(){
    console.log("sono in save()");
    let dto: UtenteRegistratoDto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utenteLoggato;
    dto.sessionToken = this.tokenService.token;
    let oss: Observable<EsitoUtenteDto> = this.http.post<EsitoUtenteDto>( 
      "http://localhost:8080/aggiorna-dati",dto
    );
    oss.subscribe(s => {
      this.utenteLoggato = s.utenteReg;
      this.tokenService.token = s.sessionToken;
      if(s.esito){
        console.log("Account Aggiornato!");
        this.notifica="Account Aggiornato!";
      }
      else{
        console.log("Errore Aggiornamento!");
        this.notifica="Errore Aggiornamento!";
      }
    });
  }

  eliminaAccount(){
    console.log("sono in eliminaAccount()");
    let dto: UtenteRegistratoDto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utenteLoggato;
    dto.sessionToken = this.tokenService.token;
    let oss: Observable<EsitoUtenteDto> = this.http.post<EsitoUtenteDto>( 
      "http://localhost:8080/elimina-account",dto
    );
    oss.subscribe(d => {
      this.tokenService.token = d.sessionToken;
      if(d.esito){
        this.utenteLoggato = d.utenteReg;
        this.router.navigateByUrl("/home-page");
      }
      else{
        this.notifica = "Errore Eliminazione Account!";
      }
    });
  }

}
