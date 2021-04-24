import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-crud/automa';
import { AutomabileCrud, State } from '../automa-crud/state';
import { HttpClient } from '@angular/common/http';
import { VarianteTaglia } from '../entità/variante-taglia';
import { VarianteTagliaDto } from '../dto/variante-taglia-dto';
import { Observable, Subscription } from 'rxjs';
import { ListaVarianteTagliaDto } from '../dto/lista-variante-taglia-dto';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { CriterioRicercaDto } from '../dto/criterio-ricerca-dto';
import { ReduxService } from '../redux.service';

@Component({
  selector: 'app-gestisci-taglie',
  templateUrl: './gestisci-taglie.component.html',
  styleUrls: ['../theme.css']
})
export class GestisciTaglieComponent implements OnInit, AutomabileCrud {

  taglia: VarianteTaglia = new VarianteTaglia();
  taglie: VarianteTaglia[] = [];
  criterio: string = "";
  automa: Automa;
  stato: State;

  buttonNuovaVisible: boolean = false;
  formDivVisible: boolean = false;
  campiNonEditabili: boolean = false;
  confAnnVisible: boolean = false;
  searchVisible: boolean = false;

  constructor(private http: HttpClient, private reduxService: ReduxService) {

    reduxService.numeroConfirmedTre$.subscribe(
      n => {console.log("Stringa da redux service: " + this.criterio)}
    )
   }

  ngOnInit(): void {
    this.aggiorna();
    this.automa = new Automa(this);
  }

  reduxTest(){
    this.reduxService.leggiNumeroTre(this.criterio);
  }
 
 
  aggiungiAction() {
    if (this.taglia.codice != null) {
      let dto: VarianteTagliaDto = new VarianteTagliaDto();
      dto.taglia = this.taglia;
      let oss: Observable<ListaVarianteTagliaDto> = this.http.post<ListaVarianteTagliaDto>(
        'http://localhost:8080/aggiungi-taglie', dto);
      oss.subscribe(r => this.taglie = r.listaVarianteTaglie);
    }
  }

  modificaAction() {
    if (this.taglia.codice != null) {
      let dto: VarianteTagliaDto = new VarianteTagliaDto();
      dto.taglia = this.taglia;
      let oss: Observable<ListaVarianteTagliaDto> = this.http.post<ListaVarianteTagliaDto>(
        'http://localhost:8080/modifica-taglie', dto);
      oss.subscribe(r => this.taglie = r.listaVarianteTaglie);
    }
  }

  rimuoviAction() {
    if (this.taglia.codice != null) {
      let dto: VarianteTagliaDto = new VarianteTagliaDto();
      dto.taglia = this.taglia;
      let oss: Observable<ListaVarianteTagliaDto> = this.http.post<ListaVarianteTagliaDto>(
        'http://localhost:8080/rimuovi-taglie', dto);
      oss.subscribe(r => this.taglie = r.listaVarianteTaglie);
    }
    console.log("Siamo in rimuoviAction");
  }

  nuova() {
    this.taglia.codice = "";
    this.stato = this.automa.next(new AddEvent());
  }

  modifica() {
    if (this.taglia.codice != null) {
      this.stato = this.automa.next(new ModificaEvent());
    }
  }

  conferma() {
    this.automa.next(new ConfermaEvent());
    this.taglia = new VarianteTaglia();
  }

  annulla() {
    this.automa.next(new AnnullaEvent());
  }

  rimuovi() {
    if (this.taglia.codice != null) {
      this.stato = this.automa.next(new RimuoviEvent());
    }
  }

  cerca() {
    let dto: CriterioRicercaDto = new CriterioRicercaDto();
    dto.criterio = this.criterio;
    let oss: Observable<ListaVarianteTagliaDto> = this.http.post<ListaVarianteTagliaDto>('http://localhost:8080/ricerca-taglie', dto);
    oss.subscribe(r => this.taglie = r.listaVarianteTaglie);
    this.automa.next(new RicercaEvent());
    this.reduxTest();
  }

  seleziona(t: VarianteTaglia) {
    this.automa.next(new SelezionaEvent());
    this.taglia.id = t.id;
    this.taglia.codice = t.codice;
  }

  aggiorna() {
    let oss: Observable<ListaVarianteTagliaDto> = this.http.get<ListaVarianteTagliaDto>('http://localhost:8080/aggiorna-taglie');
    oss.subscribe(r => this.taglie = r.listaVarianteTaglie);
  }

  goToAggiungi() {
    this.buttonNuovaVisible = false;
    this.formDivVisible = true;
    this.campiNonEditabili = false;
    this.confAnnVisible = true;
    this.searchVisible = false;
  }

  goToModifica() {
    this.buttonNuovaVisible = false;
    this.formDivVisible = true;
    this.campiNonEditabili = false;
    this.confAnnVisible = true;
    this.searchVisible = false;
  }

  goToRicerca() {
    this.buttonNuovaVisible = true;
    this.formDivVisible = false;
    this.searchVisible = true;
  }

  goToRimuovi() {
    this.buttonNuovaVisible = false;
    this.formDivVisible = true;
    this.campiNonEditabili = true;
    this.confAnnVisible = true;
    this.searchVisible = false;
  }

  goToVisualizza() {
    this.buttonNuovaVisible = true;
    this.formDivVisible = true;
    this.campiNonEditabili = true;
    this.confAnnVisible = false;
    this.searchVisible = true;
  }


}
