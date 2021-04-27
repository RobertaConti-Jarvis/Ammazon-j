import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { EsitoDto } from '../dto/esito-dto';
import { OrdineDto } from '../dto/ordine-dto';
import { UtenteRegistratoDto } from '../dto/utente-registrato-dto';
import { ReduxService } from '../redux.service';
import { TokenService } from '../token.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['../theme.css']
})
export class CheckoutComponent implements OnInit {

  prodotti: number = this.reduxService.numElementi;
  primoTotale: number = 0;
  secondoTotale: number = 0;
  esitoPagamento: boolean;
  
  constructor(private http: HttpClient, private reduxService: ReduxService, 
    private tokenService: TokenService, private router: Router) { 
    //Controllo se l'utente è loggato, in caso contrario lo reinderizzo
    //alla pagina registrazione
    this.verificaSeUtenteLoggato();
    //visualizzo il totale del carrello
    this.visualizzaTotaleCarrello();
  }
  
  ngOnInit(): void {
  }

  selezionaSpedizione(tipo: number){
    switch(tipo){
      case 1:
        this.secondoTotale = this.primoTotale + 2;
        break;
      case 2:
        this.secondoTotale = this.primoTotale + 5;
        break;
      case 3:
        this.secondoTotale = this.primoTotale + 8;
        break;
      default:
        this.secondoTotale = this.primoTotale;
    }
    
  }

  verificaSeUtenteLoggato(){
    //devo verificare su server o da sessione se l'utente è loggato
    //se non lo è lo mando alla pagina di login
    //this.router.navigateByUrl('/login');
  }

  visualizzaTotaleCarrello(){
    let dto: UtenteRegistratoDto = new UtenteRegistratoDto();
    //dto.sessionToken = this.tokenService.token;
    dto.sessionToken = "tokenRegsistrato 0";  // --> TEST utente registrato
    let oss: Observable<OrdineDto> = this.http.post<OrdineDto>(
      "http://localhost:8080/totale-ordine", dto);
    oss.subscribe(o => this.primoTotale = o.totale);
  }

  pagamento(){
    let dto: EsitoDto = new EsitoDto();
    
  }
}
