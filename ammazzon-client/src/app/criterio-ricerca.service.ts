import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CriterioRicercaService {
  criterioRicerca = new Subject<string>();
  criterioRicerca$ = this.criterioRicerca.asObservable();
  constructor() {
  }

}
