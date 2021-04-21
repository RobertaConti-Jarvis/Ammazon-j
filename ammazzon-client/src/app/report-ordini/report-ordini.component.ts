import { Component, OnInit } from '@angular/core';
import { FiltriOrdiniDto } from '../dto/filtri-ordini-dto';
import { Observable } from 'rxjs';
import { ListaOrdiniDto } from '../dto/lista-ordini-dto';
import { HttpClient } from '@angular/common/http';
import { Ordine } from '../entità/ordine';
import { DatiPageDto } from '../dto/dati-page-dto';
import { PageOrdineDto } from '../dto/page-ordine-dto';

@Component({
  selector: 'app-report-ordini',
  templateUrl: './report-ordini.component.html',
  styleUrls: ['../theme.css']
})
export class ReportOrdiniComponent implements OnInit {
  stato: string;
  ordine: string;
  tipo: string;
  listaOrdini: Ordine[] = [];

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
  }

  ngOnInit(): void {
  }

  cerca(): void {
    const dto: FiltriOrdiniDto = new FiltriOrdiniDto();
    dto.ordine = this.ordine;
    dto.stato = this.stato;
    dto.tipo = this.tipo;
    const oss: Observable<ListaOrdiniDto> = this.http
      .post<ListaOrdiniDto>('http://Localhost:8080/filtra-ordini', dto);
    oss.subscribe(l => this.listaOrdini = l.listaOrdini);
  }

    //metodi paginazione
    caricaOrdiniPaginati(numPaginaV: number) {
      this.numPaginaV = numPaginaV;
      if (this.numPaginaV > 0) {
        let dto: DatiPageDto = new DatiPageDto();
        dto.numPag = this.numPaginaV - 1;
        dto.elemPag = this.elemPag;
        let oss: Observable<PageOrdineDto> = this.http.post<PageOrdineDto>
          ("http://localhost:8080/carica-ordini-paginati", dto); 
        oss.subscribe(v => {
          this.listaOrdini = v.listaElemPag.content; // <--- Personalizzare
          console.log("lista: " + this.listaOrdini);
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
            this.caricaOrdiniPaginati(this.numPaginaV); // <--- personalizzare 
          }
        });
      }
      else {
        this.numPag = 0;
        this.numPaginaV = this.numPag + 1;
        this.caricaOrdiniPaginati(this.numPaginaV); // <--- personalizzare 
      }
    }
  
    goToNext(numPaginaV: number) {
      console.log("sono in next del padre");
      console.log("val numPaginaV: ", numPaginaV);
      this.numPaginaV = numPaginaV;
      this.numPag += 1;
      this.numPaginaV = this.numPag + 1;
      this.caricaOrdiniPaginati(this.numPaginaV); // <--- personalizzare 
    }
  
    goToPrevious(numPaginaV: number) {
      console.log("sono in prev del padre");
      console.log("val numPaginaV: ", numPaginaV);
      this.numPaginaV = numPaginaV;
      this.numPag -= 1;
      this.numPaginaV = this.numPag + 1;
      this.caricaOrdiniPaginati(this.numPaginaV); // <--- personalizzare 
    }
  
    goToFirst(numPaginaV: number) {
      console.log("sono in first del padre");
      console.log("val numPaginaV: ", numPaginaV);
      this.numPaginaV = numPaginaV;
      this.numPag = numPaginaV - 1;
      this.caricaOrdiniPaginati(this.numPaginaV); // <--- personalizzare 
    }
  
    goToLast(numPaginaV: number) {
      console.log("sono in last del padre");
      console.log("val numPaginaV: ", numPaginaV);
      this.numPag = this.totalPages - 1;
      this.numPaginaV = this.numPag + 1;
      this.caricaOrdiniPaginati(this.numPaginaV); // <--- personalizzare 
    }
  
    setElemPag(elemPag: number) {
      console.log("sono in setElemPage del padre")
      this.elemPag = elemPag;
      console.log("elemPag: ", elemPag);
      this.numPag = 0;
      this.numPaginaV = this.numPag + 1;
      this.caricaOrdiniPaginati(this.numPaginaV); // <--- personalizzare
    }

}
