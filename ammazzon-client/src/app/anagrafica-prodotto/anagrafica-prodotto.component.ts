import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Automa } from '../automa-crud/automa';
import { HttpClient } from '@angular/common/http';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { AutomabileCrud, State } from '../automa-crud/state';
import { CriterioRicercaDto } from '../dto/criterio-ricerca-dto';
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { ProdottoDto } from '../dto/prodotto-dto';
import { Prodotto } from '../entità/prodotto';
import { PageDto } from '../dto/page-dto';
import { DatiPageDto } from '../dto/dati-page-dto';

@Component({
  selector: 'app-anagrafica-prodotto',
  templateUrl: './anagrafica-prodotto.component.html',
  styleUrls: ['../theme.css']
})

export class AnagraficaProdottoComponent implements OnInit, AutomabileCrud {

  prodotto: Prodotto = new Prodotto();
  listaProdotti: Prodotto[] = [];
  searchCriterion: string;
  automa: Automa;
  stato: State;

  buttonNuovaVisible: boolean = true;
  formDivVisible: boolean;
  campiNonEditabili: boolean = false;
  confAnnVisible: boolean = false;
  modRimVisible: boolean;
  searchVisible: boolean = true;
  tabellaProdottiVisibile: boolean = true;
  labelNuovoProdotto: boolean;
  labelMessaggioErrore: boolean = false;
  errore: string = "Errore, inserire dati validi";

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
    this.caricaProdottiPaginati(this.numPaginaV);
   }

  ngOnInit(): void {
    //this.aggiorna();
    this.automa = new Automa(this);
  }
  goToRicerca() {
    this.labelNuovoProdotto = false;
    this.confAnnVisible = false;
    this.buttonNuovaVisible = true;
    this.formDivVisible = false;
    this.searchVisible = true;
  }

  goToAggiungi() {
    this.labelNuovoProdotto = true;
    this.buttonNuovaVisible = false;
    this.formDivVisible = true;
    this.campiNonEditabili = false;
    this.confAnnVisible = true;
    this.modRimVisible = false;
    this.searchVisible = false;
    this.tabellaProdottiVisibile = false;
    this.labelMessaggioErrore = false;
  }

  goToVisualizza() {
    this.labelNuovoProdotto = false;
    this.buttonNuovaVisible = true;
    this.formDivVisible = true;
    this.campiNonEditabili = true;
    this.confAnnVisible = false;
    this.modRimVisible = true;
    this.searchVisible = true;
    this.tabellaProdottiVisibile = true;
    this.labelMessaggioErrore = false;
  }

  goToModifica() {
    this.buttonNuovaVisible = false;
    this.formDivVisible = true;
    this.campiNonEditabili = false;
    this.confAnnVisible = true;
    this.modRimVisible = false;
    this.searchVisible = false;
  }

  goToRimuovi() {
    this.tabellaProdottiVisibile = true;
    this.campiNonEditabili = false;
    this.buttonNuovaVisible = true;
    this.formDivVisible = true;
    this.campiNonEditabili = true;
    this.modRimVisible = false;
    this.confAnnVisible = true;
    this.searchVisible = false;
  }

  aggiungiAction() {
    let dto: ProdottoDto = new ProdottoDto();
    dto.prodotto = this.prodotto;
    let oss: Observable<ListaProdottiDto> = this.http.post<ListaProdottiDto>
      ('http://localhost:8080/aggiungi-prodotto', dto);
    oss.subscribe(c => this.listaProdotti = c.listaProdotti);
    this.tabellaProdottiVisibile = true;
    this.prodotto = new Prodotto();
  }

  modificaAction() {
    console.log("Siamo in ModificaAction");
    let dto: ProdottoDto = new ProdottoDto();
    dto.prodotto = this.prodotto;
    console.log("Stiamo per modificare ", + dto)
    let ox: Observable<ListaProdottiDto> = this.http.post<ListaProdottiDto>
      ('http://localhost:8080/modifica-prodotto', dto);
    ox.subscribe(r => this.listaProdotti = r.listaProdotti);
  }

  rimuoviAction() {
    console.log("Siamo in rimuoviAction");
    let dto: ProdottoDto = new ProdottoDto();
    dto.prodotto = this.prodotto;
    console.log("Stiamo per rimuovere ", + dto);
    let oss: Observable<ListaProdottiDto> = this.http.post<ListaProdottiDto>
      ('http://localhost:8080/rimuovi-prodotto', dto);
    oss.subscribe(r => this.listaProdotti = r.listaProdotti);
  }

  nuova() {
    this.stato = this.automa.next(new AddEvent());
  }

  cercaPerDescrizione() {
    let dto: CriterioRicercaDto = new CriterioRicercaDto();
    dto.criterio = this.searchCriterion;
    let oss: Observable<ListaProdottiDto> = this.http.post<ListaProdottiDto>
      ("http://localhost:8080/cerca-prodotto", dto);
    oss.subscribe(c => this.listaProdotti = c.listaProdotti);
    this.automa.next(new RicercaEvent());
  }

  modifica() {
    this.stato = this.automa.next(new ModificaEvent());
  }

  conferma() {
    this.automa.next(new ConfermaEvent());
    this.prodotto = new Prodotto();
  }

  annulla() {
    this.automa.next(new AnnullaEvent());
  }

  rimuovi() {
    let dto: ProdottoDto = new ProdottoDto();
    dto.prodotto = this.prodotto;
    this.stato = this.automa.next(new RimuoviEvent());
  }

  aggiorna() {
    let oss: Observable<ListaProdottiDto> = this.http.get<ListaProdottiDto>(
      "http://localhost:8080/aggiorna-prodotto");
    oss.subscribe(a => this.listaProdotti = a.listaProdotti);
  }

  vaiA(s: string) {
    this.router.navigateByUrl(s);
  }

  seleziona(p: Prodotto) {
    this.buttonNuovaVisible = true;
    this.formDivVisible = true;
    this.campiNonEditabili = true;
    this.modRimVisible = true;
    this.confAnnVisible = true;
    this.searchVisible = true;
    this.tabellaProdottiVisibile = true;
    //Valorizzazione di tutte le proprietà della classe con quelle del oggetto selezionato
    this.prodotto = Object.assign({}, p);
    this.automa.next(new SelezionaEvent());
  }

  //metodi paginazione
  caricaProdottiPaginati(numPaginaV: number) { // <--- personalizzare 
    this.numPaginaV = numPaginaV;
    if (this.numPaginaV > 0) {
      let dto: DatiPageDto = new DatiPageDto();
      dto.numPag = this.numPaginaV - 1;
      dto.elemPag = this.elemPag;
      let oss: Observable<PageDto> = this.http.post<PageDto>
        ("http://localhost:8080/carica-prodotti-paginati", dto); // <--- personalizzare 
      oss.subscribe(v => {
        this.listaProdotti = v.listaElemPag.content; // <--- Personalizzare
        console.log("lista: " + this.listaProdotti);
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
          this.caricaProdottiPaginati(this.numPaginaV); // <--- personalizzare 
        }
      });
    }
    else {
      this.numPag = 0;
      this.numPaginaV = this.numPag + 1;
      this.caricaProdottiPaginati(this.numPaginaV); // <--- personalizzare 
    }
  }

  goToNext(numPaginaV: number) {
    console.log("sono in next del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag += 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaProdottiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToPrevious(numPaginaV: number) {
    console.log("sono in prev del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag -= 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaProdottiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToFirst(numPaginaV: number) {
    console.log("sono in first del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag = numPaginaV - 1;
    this.caricaProdottiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToLast(numPaginaV: number) {
    console.log("sono in last del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPag = this.totalPages - 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaProdottiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  setElemPag(elemPag: number) {
    console.log("sono in setElemPage del padre")
    this.elemPag = elemPag;
    console.log("elemPag: ", elemPag);
    this.numPag = 0;
    this.numPaginaV = this.numPag + 1;
    this.caricaProdottiPaginati(this.numPaginaV); // <--- personalizzare
  }
}