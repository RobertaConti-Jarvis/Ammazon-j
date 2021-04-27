import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { EsitoDto } from '../dto/esito-dto';
import { ReduxService } from '../redux.service';

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

  constructor(private http: HttpClient, private reduxService: ReduxService) { }

  //visualizzare totale carrello
  //mostrare tre tipi di spedizione, con costo diverso
  //calcolare totale con spedizione
  //inserimento carta di credito
  //risposta true o false random

  ngOnInit(): void {
  }

  selezionaStandard(){
    this.secondoTotale = this.primoTotale + 2;
  }
  
  selezionaExpress(){
    this.secondoTotale = this.primoTotale + 5;
  }

  seleziona1Giorno(){
    this.secondoTotale = this.primoTotale + 8;
  }

  pagamento(){
    let dto: EsitoDto = new EsitoDto();
    
  }
}
