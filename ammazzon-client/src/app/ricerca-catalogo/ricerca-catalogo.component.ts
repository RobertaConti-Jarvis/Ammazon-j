import {Component, OnInit} from '@angular/core';
import {Prodotto} from '../entità/prodotto';
import {Observable} from 'rxjs';
import {PageDto} from '../dto/page-dto';
import {HttpClient} from '@angular/common/http';
import {CriterioRicercaService} from '../criterio-ricerca.service';
import {CriterioDatiPageDto} from '../dto/criterio-dati-page-dto';

@Component({
  selector: 'app-ricerca-catalogo',
  templateUrl: './ricerca-catalogo.component.html',
  styleUrls: ['../theme.css']
})
export class RicercaCatalogoComponent implements OnInit {
  listaProdotti: Prodotto[] = [];
  criterioRicerca: string;
  // variabili paginazione--------
  numPag = 0;
  numPaginaV = 1;
  elemPag = 25;
  totalPages: number;
  totalElements: number;
  first: boolean;
  last: boolean;
  numberOfElements: number;

  // -----------------------------

  constructor(private http: HttpClient, private criterioRicercaService: CriterioRicercaService) {
    this.criterioRicerca = criterioRicercaService.criterioRicerca;
    this.caricaCatalogoPaginati(this.numPaginaV);
  }

  ngOnInit(): void {
  }

  // metodi paginazione
  caricaCatalogoPaginati(numPaginaV: number): void { // <--- personalizzare
    this.numPaginaV = numPaginaV;
    if (this.numPaginaV > 0) {
      const dto: CriterioDatiPageDto = new CriterioDatiPageDto();
      dto.numPag = this.numPaginaV - 1;
      dto.elemPag = this.elemPag;
      dto.criterio = this.criterioRicerca;
      const oss: Observable<PageDto> = this.http.post<PageDto>
      ('http://localhost:8080/carica-catalogo-paginati', dto); // <--- personalizzare
      oss.subscribe(v => {
        this.listaProdotti = v.listaElemPag.content; // <--- Personalizzare
        console.log('lista: ' + this.listaProdotti);
        this.totalPages = v.listaElemPag.totalPages;
        this.numPag = this.numPaginaV - 1;
        console.log('totalPages: ' + v.listaElemPag.totalPages);
        console.log('totalElements: ' + v.listaElemPag.totalElements);
        console.log('number: ' + v.listaElemPag.number);
        console.log('first: ' + v.listaElemPag.first);
        console.log('last: ' + v.listaElemPag.last);
        console.log('size. ' + v.listaElemPag.size);
        console.log('numberOfElements: ' + v.listaElemPag.numberOfElements);
        if (this.numPaginaV > this.totalPages) {
          this.numPag = this.totalPages - 1;
          this.numPaginaV = this.numPag + 1;
          this.caricaCatalogoPaginati(this.numPaginaV); // <--- personalizzare
        }
      });
    } else {
      this.numPag = 0;
      this.numPaginaV = this.numPag + 1;
      this.caricaCatalogoPaginati(this.numPaginaV); // <--- personalizzare
    }
  }

  goToNext(numPaginaV: number): void {
    console.log('sono in next del padre');
    console.log('val numPaginaV: ', numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag += 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaCatalogoPaginati(this.numPaginaV); // <--- personalizzare
  }

  goToPrevious(numPaginaV: number): void {
    console.log('sono in prev del padre');
    console.log('val numPaginaV: ', numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag -= 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaCatalogoPaginati(this.numPaginaV); // <--- personalizzare
  }

  goToFirst(numPaginaV: number): void {
    console.log('sono in first del padre');
    console.log('val numPaginaV: ', numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag = numPaginaV - 1;
    this.caricaCatalogoPaginati(this.numPaginaV); // <--- personalizzare
  }

  goToLast(numPaginaV: number): void {
    console.log('sono in last del padre');
    console.log('val numPaginaV: ', numPaginaV);
    this.numPag = this.totalPages - 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaCatalogoPaginati(this.numPaginaV); // <--- personalizzare
  }

  setElemPag(elemPag: number): void {
    console.log('sono in setElemPage del padre');
    this.elemPag = elemPag;
    console.log('elemPag: ', elemPag);
    this.numPag = 0;
    this.numPaginaV = this.numPag + 1;
    this.caricaCatalogoPaginati(this.numPaginaV); // <--- personalizzare
  }
}
