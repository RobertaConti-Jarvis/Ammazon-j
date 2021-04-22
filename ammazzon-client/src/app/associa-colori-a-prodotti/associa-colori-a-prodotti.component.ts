import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CriterioRicercaDto } from '../dto/criterio-ricerca-dto';
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { ListeColoriProdottoDto } from '../dto/liste-colori-prodotto-dto';
import { ProdottoColoreDto } from '../dto/prodotto-colore-dto';
import { ProdottoDto } from '../dto/prodotto-dto';
import { Prodotto } from '../entità/prodotto';
import { ProdottoColore } from '../entità/prodotto-colore';
import { VarianteColore } from '../entità/variante-colore';

@Component({
  selector: 'app-associa-colori-a-prodotti',
  templateUrl: './associa-colori-a-prodotti.component.html',
  styleUrls: ['../theme.css']
})
export class AssociaColoriAProdottiComponent implements OnInit {

  prodotto: Prodotto = new Prodotto();
  criterio: string;
  listaProdotti: Prodotto[] = [];
  coloriAssociati: VarianteColore[] = [];
  coloriNonAssociati: VarianteColore[] = [];
  varianteColore: VarianteColore = new VarianteColore();
  prodottoColore: ProdottoColore = new ProdottoColore();

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }


  cercaProdotto() {
    let dto: CriterioRicercaDto = new CriterioRicercaDto();
    dto.criterio = this.criterio;
    let oss: Observable<ListaProdottiDto> = this.http.post<ListaProdottiDto>(
      "http://localhost:8080/cerca-prodotti", dto);
    oss.subscribe(c => this.listaProdotti = c.listaProdotti);
  }





  seleziona(p: Prodotto) {
    this.prodotto = p;
    let dto: ProdottoDto = new ProdottoDto();
    dto.prodotto = this.prodotto;
    let oss: Observable<ListeColoriProdottoDto> = this.http.post<ListeColoriProdottoDto>(
      "http://localhost:8080/seleziona-prodotto-colore", dto);
    oss.subscribe(r => {
      this.coloriAssociati = r.coloriAssociati;
      this.coloriNonAssociati = r.coloriNonAssociati;
    });
  }
  spostaInDisponibili(ca: VarianteColore) {
    this.varianteColore = ca;
    this.prodottoColore.prodotto = this.prodotto;
    this.prodottoColore.varianteColore = this.varianteColore;
    let dto: ProdottoColoreDto = new ProdottoColoreDto();
    dto.prodottoColore = this.prodottoColore;
    let oss: Observable<ListeColoriProdottoDto> = this.http.post<ListeColoriProdottoDto>(
      "http://localhost:8080/sposta-in-disponibili", dto);
    oss.subscribe(r => {
      this.coloriAssociati = r.coloriAssociati;
      this.coloriNonAssociati = r.coloriNonAssociati;
    });
  }

  associaTuttiColori() {
    let dto: ProdottoDto = new ProdottoDto();
    dto.prodotto = this.prodotto;
    let oss: Observable<ListeColoriProdottoDto> = this.http.post<ListeColoriProdottoDto>("http://localhost:8080/associa-tutti", dto);
    oss.subscribe(g => {
      this.coloriAssociati = g.coloriAssociati;
      this.coloriNonAssociati = g.coloriNonAssociati;
    });
  }

  disassociaTuttiColori() {
    let dto: ProdottoDto = new ProdottoDto();
    dto.prodotto = this.prodotto;
    let oss: Observable<ListeColoriProdottoDto> = this.http.post<ListeColoriProdottoDto>("http://localhost:8080/disassocia-tutti", dto);
    oss.subscribe(d => {
      this.coloriAssociati = d.coloriAssociati;
      this.coloriNonAssociati = d.coloriNonAssociati;
    });
  }

  spostaInAssociati(na: VarianteColore) {
    this.varianteColore = na;
    this.prodottoColore.prodotto = this.prodotto;
    this.prodottoColore.varianteColore = this.varianteColore;
    let dto: ProdottoColoreDto = new ProdottoColoreDto();
    dto.prodottoColore = this.prodottoColore;
    let oss: Observable<ListeColoriProdottoDto> = this.http.post<ListeColoriProdottoDto>(
      "http://localhost:8080/sposta-in-associati", dto);
    oss.subscribe(r => {
      this.coloriAssociati = r.coloriAssociati;
      this.coloriNonAssociati = r.coloriNonAssociati;
    });
  }

  /* //metodi paginazione
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
   }*/

}
