import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Automa } from '../automa-crud/automa';
import { AutomabileCrud, State } from '../automa-crud/state';
import { VarianteColore } from '../entità/variante-colore';
import { HttpClient } from '@angular/common/http';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RimuoviEvent } from '../automa-crud/eventi';
import { Observable } from 'rxjs';
import { ListaVarianteColoreDto } from '../dto/lista-variante-colore-dto';
import { VarianteColoreDto } from '../dto/variante-colore-dto';

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
    this.aggiorna();
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

  aggiungiAction() { 
    let dto: VarianteColoreDto = new VarianteColoreDto();
    dto.varianteColore = this.varianteColore
    let ox: Observable<ListaVarianteColoreDto> = this.http.post<ListaVarianteColoreDto>(
      "http://localhost:8080/aggiungi-variante-colore",dto);
      ox.subscribe(c=>this.listaColori = c.listaVarianteColore);
  }

  modificaAction() {
    let dto: VarianteColoreDto = new VarianteColoreDto();
    dto.varianteColore = this.varianteColore
    let ox: Observable<ListaVarianteColoreDto> = this.http.post<ListaVarianteColoreDto>(
      "http://localhost:8080/modifica-variante-colore",dto);
      ox.subscribe(c=>this.listaColori = c.listaVarianteColore);

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
  }

  aggiorna(){
    let ax: Observable<ListaVarianteColoreDto> = this.http.get<ListaVarianteColoreDto>(
      "http://localhost:8080/aggiorna-variante-colore");
      ax.subscribe(a=>this.listaColori = a.listaVarianteColore);
  }

  cercaPerCodice() { }


}

