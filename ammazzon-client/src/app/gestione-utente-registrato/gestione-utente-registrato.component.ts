import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Automa } from '../automa-crud/automa';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { AutomabileCrud } from '../automa-crud/state';
import { CriterioRicercaDto } from '../dto/criterio-ricerca-dto';
import { ListaUtenteregistratoDto } from '../dto/lista-utente-registrato-dto';
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


  constructor(private http: HttpClient) {
    this.automa = new Automa(this);
    this.aggiorna();
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

  aggiorna():void{
    const oss: Observable<ListaUtenteregistratoDto> = this.http
    .get<ListaUtenteregistratoDto>("http://localhost:8080/aggiorna-utente");
    oss.subscribe(s => this.listaUtentiRegistrati = s.listaUtenti);
  }

  ngOnInit(): void {
  }

}
