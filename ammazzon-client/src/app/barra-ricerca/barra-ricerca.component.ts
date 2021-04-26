import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CriterioRicercaService } from '../criterio-ricerca.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-barra-ricerca',
  templateUrl: './barra-ricerca.component.html',
  styleUrls: ['../theme.css']
})
export class BarraRicercaComponent implements OnInit {
  @Input() criterioRicerca = "";
  @Output() search: EventEmitter<string> = new EventEmitter<string>();
  constructor() { }

  ngOnInit(): void {
  }

  cercaCatalogo(): void {
    this.search.emit(this.criterioRicerca);
  }
}
