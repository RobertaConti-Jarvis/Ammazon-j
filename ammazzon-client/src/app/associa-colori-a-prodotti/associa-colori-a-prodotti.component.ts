import { Component, OnInit } from '@angular/core';
import { Prodotto } from '../entità/prodotto';

@Component({
  selector: 'app-associa-colori-a-prodotti',
  templateUrl: './associa-colori-a-prodotti.component.html',
  styleUrls: ['./associa-colori-a-prodotti.component.css']
})
export class AssociaColoriAProdottiComponent implements OnInit {


  searchCriterion:String="";
  prodotto:Prodotto = new Prodotto();
  listaProdotti:Prodotto[]=[];

  constructor() { }

  ngOnInit(): void {
  }


  cercaProdotto() {

  }
}
