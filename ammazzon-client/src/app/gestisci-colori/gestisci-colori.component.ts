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

@Component({
  selector: 'app-gestisci-colori',
  templateUrl: './gestisci-colori.component.html',
  styleUrls: ['./gestisci-colori.component.css']
})
export class GestisciColoriComponent implements OnInit, AutomabileCrud {
  varianteColore: VarianteColore = new VarianteColore();
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





  constructor(private http: HttpClient, private router: Router) { }


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
    dto.varianteColore = this.varianteColore;
    let oss: Observable<ListaVarianteColoreDto> = this.http.post<ListaVarianteColoreDto>
      ("http://localhost:8080/rimuovi-variante-colore", dto);
    oss.subscribe(r => this.listaColori = r.listaVarianteColore);
  }

  aggiungiAction() {
    let dto: VarianteColoreDto = new VarianteColoreDto();
    dto.varianteColore = this.varianteColore
    let ox: Observable<ListaVarianteColoreDto> = this.http.post<ListaVarianteColoreDto>(
      "http://localhost:8080/aggiungi-variante-colore", dto);
    ox.subscribe(c => this.listaColori = c.listaVarianteColore);

  }

  modificaAction() {
    let dto: VarianteColoreDto = new VarianteColoreDto();
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
    this.varianteColore = c;
    this.stato = this.automa.next(new SelezionaEvent());
    this.searchCriterion = "";

  }
}















