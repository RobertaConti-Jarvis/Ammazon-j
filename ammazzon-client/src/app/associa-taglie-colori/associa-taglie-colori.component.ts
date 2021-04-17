import { Component, OnInit } from '@angular/core';
import { Prodotto } from '../entità/prodotto';
import { ProdottoColore } from '../entità/prodotto-colore';
import { ColoreTaglia } from '../entità/colore-taglia';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-associa-taglie-colori',
  templateUrl: './associa-taglie-colori.component.html',
  styleUrls: ['./associa-taglie-colori.component.css']
})
export class AssociaTaglieColoriComponent implements OnInit {
  
  criterio: string = "";
  listaProdotti: Prodotto[] = [];
  listaProdottiColori: ProdottoColore[] = [];
  listaColoreTagliaAss: ColoreTaglia[] = [];
  listaColoreTagliaDis: ColoreTaglia[] = [];

  constructor() { }

  ngOnInit(): void {
  }

  cerca(){

  }

  selezionaProdotto(p){

  }

  selezionaColore(c){

  }

  rimuovi(t){

  }

  rimuoviAll(){

  }

  associa(t){

  }

  associaAll(){
    
  }

}
