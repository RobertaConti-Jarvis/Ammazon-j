import { Component, OnInit } from '@angular/core';
import { Colore } from '../entità/colore';

@Component({
  selector: 'app-gestisci-colori',
  templateUrl: './gestisci-colori.component.html',
  styleUrls: ['./gestisci-colori.component.css']
})
export class GestisciColoriComponent implements OnInit {
  colore: Colore = new Colore();
  listaColori: Colore[] = [];

  constructor() { }

  ngOnInit(): void {
  }
  nuova() { }

  modifica() { }

  rimuovi() { }

  conferma() { }
  
  annulla() { }
}
