import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Automa } from '../automa-crud/automa';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { AutomabileCrud } from '../automa-crud/state';
import { CriterioRicercaDto } from '../dto/criterio-ricerca-dto';
import { DatiPageDto } from '../dto/dati-page-dto';
import { ListaUtenteregistratoDto } from '../dto/lista-utente-registrato-dto';
import { PageUtenteDto } from '../dto/page-utente-dto';
import { UtenteRegistratoDto } from '../dto/utente-registrato-dto';
import { UtenteRegistrato } from '../entità/utente-registrato';

@Component({
  selector: 'app-gestione-utente-registrato',
  templateUrl: './gestione-utente-registrato.component.html',
  styleUrls: ['../theme.css']
})
export class GestioneUtenteRegistratoComponent implements OnInit, AutomabileCrud {
  automa: Automa;
  criterio: string;
  listaUtentiRegistrati: Array<UtenteRegistrato>;
  utenteRegistrato: UtenteRegistrato;

  // variabili booleane
  cercaVisible = false;
  nuovaVisible = false;
  rimuoviModificaVisible = false;
  confermaAnnullaVisible = false;
  formsVisible = false;
  inputDisabled = false;

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


  constructor(private http: HttpClient) {
    this.automa = new Automa(this);
    this.caricaUtentiPaginati(this.numPaginaV);
  }

  goToRicerca() {
    this.nuovaVisible = true;
    this.cercaVisible = true;
    this.rimuoviModificaVisible = false;
    this.confermaAnnullaVisible = false;
    this.formsVisible = false;
    this.inputDisabled = false;
  }
  goToAggiungi() {
    this.nuovaVisible = false;
    this.cercaVisible = false;
    this.rimuoviModificaVisible = false;
    this.confermaAnnullaVisible = true;
    this.formsVisible = true;
    this.inputDisabled = true;
  }
  goToVisualizza() {
    this.nuovaVisible = true;
    this.cercaVisible = true;
    this.rimuoviModificaVisible = true;
    this.confermaAnnullaVisible = false;
    this.formsVisible = true;
    this.inputDisabled = false;
  }
  goToModifica() {
    this.nuovaVisible = false;
    this.cercaVisible = false;
    this.rimuoviModificaVisible = false;
    this.confermaAnnullaVisible = true;
    this.formsVisible = true;
    this.inputDisabled = true;
  }
  goToRimuovi() {
    this.goToModifica();
  }
  rimuoviAction() {
    const dto: UtenteRegistratoDto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utenteRegistrato;
    const oss: Observable<ListaUtenteregistratoDto> = this.http
      .post<ListaUtenteregistratoDto>("http://localhost:8080/rimuovi-utente", dto);
    oss.subscribe(s => this.listaUtentiRegistrati = s.listaUtenti);
  }

  aggiungiAction() {
    const dto: UtenteRegistratoDto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utenteRegistrato;
    const oss: Observable<ListaUtenteregistratoDto> = this.http
      .post<ListaUtenteregistratoDto>("http://localhost:8080/aggiungi-utente", dto);
    oss.subscribe(s => this.listaUtentiRegistrati = s.listaUtenti);
  }
  modificaAction() {
    const dto: UtenteRegistratoDto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utenteRegistrato;
    const oss: Observable<ListaUtenteregistratoDto> = this.http
      .post<ListaUtenteregistratoDto>("http://localhost:8080/modifica-utente", dto);
    oss.subscribe(s => this.listaUtentiRegistrati = s.listaUtenti);
  }

  cerca(): void {
    const dto: CriterioRicercaDto = new CriterioRicercaDto();
    dto.criterio = this.criterio;
    const oss: Observable<ListaUtenteregistratoDto> = this.http
      .post<ListaUtenteregistratoDto>("http://localhost:8080/ricerca-utente", dto);
    oss.subscribe(h => this.listaUtentiRegistrati = h.listaUtenti);
  }

  seleziona(utente: UtenteRegistrato): void {
    this.utenteRegistrato = utente;
    this.automa.next(new SelezionaEvent);
  }

  modifica(): void {
    this.automa.next(new ModificaEvent);
  }

  conferma(): void {
    this.automa.next(new ConfermaEvent);
  }

  annulla(): void {
    this.automa.next(new AnnullaEvent);
  }

  rimuovi(): void {
    this.automa.next(new RimuoviEvent);
  }

  nuovo(): void {
    this.utenteRegistrato = new UtenteRegistrato();
    this.automa.next(new AddEvent);
  }

  aggiorna(): void {
    const oss: Observable<ListaUtenteregistratoDto> = this.http
      .get<ListaUtenteregistratoDto>("http://localhost:8080/aggiorna-utente");
    oss.subscribe(s => this.listaUtentiRegistrati = s.listaUtenti);
  }

  ngOnInit(): void {
  }
  //metodi paginazione
  caricaUtentiPaginati(numPaginaV: number) { // <--- personalizzare 
    this.numPaginaV = numPaginaV;
    if (this.numPaginaV > 0) {
      let dto: DatiPageDto = new DatiPageDto();
      dto.numPag = this.numPaginaV - 1;
      dto.elemPag = this.elemPag;
      let oss: Observable<PageUtenteDto> = this.http.post<PageUtenteDto>
        ("http://localhost:8080/carica-utenti-paginati", dto); // <--- personalizzare 
      oss.subscribe(v => {
        this.listaUtentiRegistrati = v.listaElemPag.content; // <--- Personalizzare
        console.log("lista: " + this.listaUtentiRegistrati);
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
          this.caricaUtentiPaginati(this.numPaginaV); // <--- personalizzare 
        }
      });
    }
    else {
      this.numPag = 0;
      this.numPaginaV = this.numPag + 1;
      this.caricaUtentiPaginati(this.numPaginaV); // <--- personalizzare 
    }
  }

  goToNext(numPaginaV: number) {
    console.log("sono in next del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag += 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaUtentiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToPrevious(numPaginaV: number) {
    console.log("sono in prev del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag -= 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaUtentiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToFirst(numPaginaV: number) {
    console.log("sono in first del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag = numPaginaV - 1;
    this.caricaUtentiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToLast(numPaginaV: number) {
    console.log("sono in last del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPag = this.totalPages - 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaUtentiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  setElemPag(elemPag: number) {
    console.log("sono in setElemPage del padre")
    this.elemPag = elemPag;
    console.log("elemPag: ", elemPag);
    this.numPag = 0;
    this.numPaginaV = this.numPag + 1;
    this.caricaUtentiPaginati(this.numPaginaV); // <--- personalizzare
  }
}


