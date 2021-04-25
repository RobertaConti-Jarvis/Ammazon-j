import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Automa } from '../automa-crud/automa';
import { AutomabileCrud, State } from '../automa-crud/state';
import { VarianteColore } from '../entità/variante-colore';
import { HttpClient } from '@angular/common/http';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { Observable } from 'rxjs';
import { ListaVarianteColoreDto } from '../dto/lista-variante-colore-dto';
import { VarianteColoreDto } from '../dto/variante-colore-dto';
import { CriterioRicercaDto } from '../dto/criterio-ricerca-dto';
import { DatiPageDto } from '../dto/dati-page-dto';
import { PageDto } from '../dto/page-dto';
import { PageColoriDto } from '../dto/page-colori-dto';

@Component({
  selector: 'app-gestisci-colori',
  templateUrl: './gestisci-colori.component.html',
  styleUrls:  ['../theme.css']
})
export class GestisciColoriComponent implements OnInit, AutomabileCrud {
  varianteColore: VarianteColore = new VarianteColore();
  codice: string;
  descrizione: string;
  listaColori: VarianteColore[] = [];
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
  cercaVisible: boolean = true;


//variabili paginazione--------
numPag: number = 0;
numPaginaV: number = 1;
elemPag: number = 25;
totalPages: number;
totalElements: number;
first: boolean;
last: boolean;
numberOfElements: number;
//-----------------------------


  constructor(private http: HttpClient, private router: Router) { 
    this.caricaColoriPaginati(this.numPaginaV);
  }


  ngOnInit(): void {
   // this.aggiorna();
    this.automa = new Automa(this);
  }

  goToRicerca() {
    this.confAnnVisible = false;
    this.buttonNuovaVisible = true;
    this.formDivVisible = false;
    this.searchVisible = false;
    this.nuovaVis = true;
    console.log('sei nello stato ricerca');

  }

  goToAggiungi() {
    this.buttonNuovaVisible = true;
    this.formDivVisible = true;
    this.campiNonEditabili = false;
    this.confAnnVisible = true;
    this.modRim = false;
    this.searchVisible = true;
    this.tabellaColoriVis = true;
    this.nuovaVis = false;
    this.codice="";
    this.descrizione="";
    console.log('sei nello stato aggiungi');

  }

  goToVisualizza() {
    this.buttonNuovaVisible = false;
    this.formDivVisible = true;
    this.campiNonEditabili = false;
    this.confAnnVisible = false;
    this.modRim = true;
    this.searchVisible = false;
    this.tabellaColoriVis = true;
    this.nuovaVis = true;
    console.log('sei nello stato visualizza');
  }

  goToModifica() {
    this.buttonNuovaVisible = false;
    this.formDivVisible = true;
    this.campiNonEditabili = true;
    this.confAnnVisible = true;
    this.modRim = false;
    this.searchVisible = false;
    this.cercaVisible= false;
    console.log('sei nello stato modifica');
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
    console.log('sei nello stato rimuovi');
  }






  rimuoviAction() {
    let dto: VarianteColoreDto = new VarianteColoreDto();
    this.varianteColore.codice = this.codice;
    this.varianteColore.descrizione = this.descrizione;
    dto.varianteColore = this.varianteColore;
    let oss: Observable<ListaVarianteColoreDto> = this.http.post<ListaVarianteColoreDto>
      ("http://localhost:8080/rimuovi-variante-colore", dto);
    oss.subscribe(r => this.listaColori = r.listaVarianteColore);
  }

  aggiungiAction() {
    let dto: VarianteColoreDto = new VarianteColoreDto();
    this.varianteColore.codice = this.codice;
    this.varianteColore.descrizione = this.descrizione;
    dto.varianteColore = this.varianteColore
    let ox: Observable<ListaVarianteColoreDto> = this.http.post<ListaVarianteColoreDto>(
      "http://localhost:8080/aggiungi-variante-colore", dto);
    ox.subscribe(c => this.listaColori = c.listaVarianteColore);

  }

  modificaAction() {
    let dto: VarianteColoreDto = new VarianteColoreDto();
    this.varianteColore.codice = this.codice;
    this.varianteColore.descrizione = this.descrizione;
    dto.varianteColore = this.varianteColore
    let ox: Observable<ListaVarianteColoreDto> = this.http.post<ListaVarianteColoreDto>(
      "http://localhost:8080/modifica-variante-colore", dto);
    ox.subscribe(c => this.listaColori = c.listaVarianteColore);

  }

  aggiorna() {
    let ax: Observable<ListaVarianteColoreDto> = this.http.get<ListaVarianteColoreDto>(
      "http://localhost:8080/aggiorna-variante-colore");
    ax.subscribe(a => this.listaColori = a.listaVarianteColore);
  }

  cercaPerCodice() {
    let dto: CriterioRicercaDto = new CriterioRicercaDto();
    dto.criterio = this.searchCriterion;
    let oss: Observable<ListaVarianteColoreDto> = this.http.post<ListaVarianteColoreDto>(
      "http://localhost:8080/cerca-variante-colore", dto);
    oss.subscribe(f => this.listaColori = f.listaVarianteColore);

  }

  nuova() {
    this.stato = this.automa.next(new AddEvent());

  }

  modifica() {
    this.stato = this.automa.next(new ModificaEvent());

  }

  rimuovi() {
    this.stato = this.automa.next(new RimuoviEvent());

  }

  conferma() {
    this.automa.next(new ConfermaEvent());

  }

  annulla() {

    this.automa.next(new AnnullaEvent());
    this.searchCriterion = "";

  }

  seleziona(c) {
   // this.varianteColore.codice=this.codice;
   // this.varianteColore.descrizione=this.descrizione;
   this.codice=c.codice;
    this.descrizione=c.descrizione;
    this.varianteColore = c;
    this.varianteColore = c;
    this.stato = this.automa.next(new SelezionaEvent());
    this.searchCriterion = "";

  }
  //metodi paginazione
  caricaColoriPaginati(numPaginaV: number) { // <--- personalizzare 
    this.numPaginaV = numPaginaV;
    if (this.numPaginaV > 0) {
      let dto: DatiPageDto = new DatiPageDto();
      dto.numPag = this.numPaginaV - 1;
      dto.elemPag = this.elemPag;
      let oss: Observable<PageColoriDto> = this.http.post<PageColoriDto>
        ("http://localhost:8080/carica-colori-paginati", dto); // <--- personalizzare ok
      oss.subscribe(v => {
        this.listaColori = v.listaElemPag.content; // <--- Personalizzare ok
        console.log("lista: " + this.listaColori);
        this.totalPages = v.listaElemPag.totalPages;
        this.numPag = this.numPaginaV - 1;
        console.log("totalPages: " + v.listaElemPag.totalPages);
        console.log("totalElements: " + v.listaElemPag.totalElements);
        console.log("number: " + v.listaElemPag.number);
        console.log("first: " + v.listaElemPag.first);
        console.log("last: " + v.listaElemPag.last);
        console.log("size. " + v.listaElemPag.size);
        console.log("numberOfElements: " + v.listaElemPag.numberOfElements);
        if (this.numPaginaV > this.totalPages) {
          this.numPag = this.totalPages - 1;
          this.numPaginaV = this.numPag + 1;
          this.caricaColoriPaginati(this.numPaginaV); // <--- personalizzare 
        }
      });
    }
    else {
      this.numPag = 0;
      this.numPaginaV = this.numPag + 1;
      this.caricaColoriPaginati(this.numPaginaV); // <--- personalizzare 
    }
  }

  goToNext(numPaginaV: number) {
    console.log("sono in next del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag += 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaColoriPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToPrevious(numPaginaV: number) {
    console.log("sono in prev del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag -= 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaColoriPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToFirst(numPaginaV: number) {
    console.log("sono in first del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag = numPaginaV - 1;
    this.caricaColoriPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToLast(numPaginaV: number) {
    console.log("sono in last del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPag = this.totalPages - 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaColoriPaginati(this.numPaginaV); // <--- personalizzare 
  }

  setElemPag(elemPag: number) {
    console.log("sono in setElemPage del padre")
    this.elemPag = elemPag;
    console.log("elemPag: ", elemPag);
    this.numPag = 0;
    this.numPaginaV = this.numPag + 1;
    this.caricaColoriPaginati(this.numPaginaV); // <--- personalizzare
  }
}















