import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Prodotto } from './entità/prodotto';

@Injectable({
  providedIn: 'root'
})
export class ReduxService {
  // creo la variabile
  reduxNumeroDue = new Subject<number>();
  //lo trasformo in ossarvabile
  reduxNumeroDue$ = this.reduxNumeroDue.asObservable();

  //GRUPPO TRE
  //Observable number source
  private numeroConfirmedSourceTre = new Subject<string>();
  //Observable number streams
  numeroConfirmedTre$ = this.numeroConfirmedSourceTre.asObservable();
  
  // Osservabile per numero elementi carrello
  numElementi: number = 0;
  private elementiCarrello = new Subject<number>();
  elementiCarrello$ = this.elementiCarrello.asObservable();
  private leggiCarrello = new Subject<number>();
  leggiCarrello$ = this.leggiCarrello.asObservable();
  //variabile globale Prodotto
  prodotto: Prodotto = new Prodotto();
  
  constructor() { }

  notificaNumeroDue(i: number) {
    this.reduxNumeroDue.next(i);
    console.log("Numero gruppo 2", this.reduxNumeroDue);
  }

  leggiNumeroTre(testo: string) {
    this.numeroConfirmedSourceTre.next(testo);
  }

  aggiungiElementoCarrello(i: number){
    this.numElementi = i;
    this.elementiCarrello.next(this.numElementi);
  }

  leggiElementiCarrello(i: number){
    i = this.numElementi;
    this.leggiCarrello.next(i);
  }
}
