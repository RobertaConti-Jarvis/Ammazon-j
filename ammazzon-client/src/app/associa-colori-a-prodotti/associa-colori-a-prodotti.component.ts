import { Component, OnInit } from '@angular/core';
import { Prodotto } from '../entità/prodotto';
import { ProdottoColore } from '../entità/prodotto-colore';

@Component({
  selector: 'app-associa-colori-a-prodotti',
  templateUrl: './associa-colori-a-prodotti.component.html',
  styleUrls: ['./associa-colori-a-prodotti.component.css']
})
export class AssociaColoriAProdottiComponent implements OnInit {

  prodotto: Prodotto = new Prodotto();
  criterio: string;
  listaProdotti: Prodotto[] = [];
  coloriAssociati: ProdottoColore[] = [];
  coloriNonAssociati: ProdottoColore[] = [];

  constructor() { }

  ngOnInit(): void {
  }


  cercaProdotto() {

  }


  seleziona(p) {

  }
  spostaInDisponibili(ca) {

  }

  associaTuttiColori() {

  }

  disassociaTuttiColori() {

  }

}
