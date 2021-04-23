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

  constructor() {}

  notificaNumeroDue(i: number) {
    this.reduxNumeroDue.next(i);
    console.log("Numero gruppo 2", this.reduxNumeroDue);
  }
}
