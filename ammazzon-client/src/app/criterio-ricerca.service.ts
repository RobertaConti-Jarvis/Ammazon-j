import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CriterioRicercaService {
  criterio = "";
  private criterioRicerca = new Subject<string>();
  criterioRicerca$ = this.criterioRicerca.asObservable();

  notifyCriterion(s: string) {
    console.log("Siamo in notifyCriterion ", s);
    this.criterio = s;
    this.criterioRicerca.next(s);
  }

  constructor() {
  }

}
