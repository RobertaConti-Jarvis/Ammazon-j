import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

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

  constructor() { }

  notificaNumeroDue(i: number) {
    this.reduxNumeroDue.next(i);
    console.log("Numero gruppo 2", this.reduxNumeroDue);
  }

  leggiNumeroTre(testo: string) {
    this.numeroConfirmedSourceTre.next(testo);
  }
}
