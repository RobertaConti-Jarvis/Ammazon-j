import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-crud/automa';
import { AutomabileCrud, State } from '../automa-crud/state';
import { Colore } from '../entità/colore';

@Component({
  selector: 'app-gestisci-colori',
  templateUrl: './gestisci-colori.component.html',
  styleUrls: ['./gestisci-colori.component.css']
})
export class GestisciColoriComponent implements OnInit, AutomabileCrud {
  colore: Colore = new Colore();
  listaColori: Colore[] = [];
  automa: Automa;
  stato: State;
  searchCriterion: string;
  formDivVisible: boolean;

  buttonNuovaVisible: boolean = true;
  campiNonEditabili: boolean;
  nuovaVis: boolean = true;
  modRim: boolean;
  confAnnVisible: boolean;
  searchVisible: boolean = true;
  tabellaColoriVis: boolean = true;





  constructor() { }


  ngOnInit(): void {
    this.automa = new Automa(this);
  }

  goToRicerca() {
    this.confAnnVisible = false;
    this.buttonNuovaVisible = true;
    this.formDivVisible = false;
    this.searchVisible = true;

  }

  goToAggiungi() {
    this.buttonNuovaVisible = false;
    this.formDivVisible = true;
    this.campiNonEditabili = false;
    this.confAnnVisible = true;
    this.modRim = false;
    this.searchVisible = false;
    this.tabellaColoriVis = true;

  }

  goToVisualizza() {


  }

  goToModifica() {
    this.buttonNuovaVisible = false;
    this.formDivVisible = true;
    this.campiNonEditabili = false;
    this.confAnnVisible = true;
    this.modRim = false;
    this.searchVisible = false;
  }

  goToRimuovi() {
    this.tabellaColoriVis = true;
    this.campiNonEditabili = false;
    this.buttonNuovaVisible = true;
    this.formDivVisible = true;
    this.campiNonEditabili = true;
    this.modRim = false;
    this.confAnnVisible = true;
    this.searchVisible = false;
  }
  rimuoviAction() { }

  aggiungiAction() { }
  
  modificaAction() { }

  nuova() { }

  modifica() { }

  rimuovi() { }

  conferma() { }

  annulla() { }

  cercaPerCodice() { }

}

