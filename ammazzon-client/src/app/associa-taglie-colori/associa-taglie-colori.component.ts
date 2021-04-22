import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Prodotto } from '../entità/prodotto';
import { ProdottoColore } from '../entità/prodotto-colore';
import { ColoreTaglia } from '../entità/colore-taglia';
import { Observable } from 'rxjs';
import { CriterioRicercaDto } from "../dto/criterio-ricerca-dto";
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { ListaProdottiColoreDto } from '../dto/lista-prodotti-colore-dto';
import { ListaColoreTaglieDto } from '../dto/lista-colore-taglie-dto';
import { ProdottoDto } from '../dto/prodotto-dto';
import { ProdottoColoreDto } from '../dto/prodotto-colore-dto';
import { ListaVarianteTagliaDto } from '../dto/lista-variante-taglia-dto';
import { VarianteTaglia } from '../entità/variante-taglia';
import { ColoreTagliaDto } from '../dto/colore-taglia-dto';
import { DatiPageDto } from '../dto/dati-page-dto';
import { PageDto } from '../dto/page-dto';
import { RicercaDatiPageDto } from '../dto/ricerca-dati-page-dto';

@Component({
  selector: 'app-associa-taglie-colori',
  templateUrl: './associa-taglie-colori.component.html',
  styleUrls: ['../theme.css']
})
export class AssociaTaglieColoriComponent implements OnInit {

  criterio: string = "";
  prodotto: Prodotto;
  listaProdotti: Prodotto[] = [];
  prodottoColore: ProdottoColore;
  listaProdottiColori: ProdottoColore[] = [];
  listaColoreTagliaAss: ColoreTaglia[] = [];
  listaVarianteTagliaDis: VarianteTaglia[] = [];
 //paginazione
  numPag: number = 0;
  numPaginaV: number = 1;
  elemPag: number = 25;
  totalPages: number;
  totalElements: number;
  first: boolean;
  last: boolean;
  numberOfElements: number;


  constructor(private http: HttpClient) { 
    this.caricaListaProdottiPaginati(this.numPaginaV);
  }

  ngOnInit(): void {
  }

  cerca() {
    this.caricaListaProdottiPaginati(this.numPaginaV);
  }

  selezionaProdotto(p: Prodotto) {
    let dto: ProdottoDto = new ProdottoDto();
    dto.prodotto = p;
    let oss: Observable<ListaProdottiColoreDto> = this.http.post<ListaProdottiColoreDto>('http://localhost:8080/mostra-prodotto-colori', dto);
    oss.subscribe(r => this.listaProdottiColori = r.listaProdottiColore);
  }

  selezionaColore(c: ProdottoColore) {
    let dto: ProdottoColoreDto = new ProdottoColoreDto();
    dto.prodottoColore = c;
    this.prodottoColore = c;
    let oss: Observable<ListaColoreTaglieDto> = this.http.post<ListaColoreTaglieDto>('http://localhost:8080/mostra-coloretaglie-associate', dto);
    oss.subscribe(r => this.listaColoreTagliaAss = r.listaColoreTaglie);
  }

  selezionaColoreDis(c: ProdottoColore) {
    let dto: ProdottoColoreDto = new ProdottoColoreDto();
    dto.prodottoColore = c;
    let oss: Observable<ListaVarianteTagliaDto> = this.http.post<ListaVarianteTagliaDto>('http://localhost:8080/mostra-coloretaglie-disponibili', dto);
    oss.subscribe(r => this.listaVarianteTagliaDis = r.listaVarianteTaglie);
  }

  rimuovi(t: ColoreTaglia) {
    let dto: ColoreTagliaDto = new ColoreTagliaDto();
    dto.coloreTaglia = t;
    let oss: Observable<ListaColoreTaglieDto> = this.http.post<ListaColoreTaglieDto>('http://localhost:8080/rimuovi-colore-taglia', dto);
    oss.subscribe(r => {
      this.listaColoreTagliaAss = r.listaColoreTaglie;
      this.selezionaColoreDis(t.prodottoColore)
    }
    );
  }

  rimuoviAll() {
    let dto: ProdottoColoreDto = new ProdottoColoreDto();
    dto.prodottoColore = this.prodottoColore;
    let oss: Observable<ListaColoreTaglieDto> = this.http.post<ListaColoreTaglieDto>('http://localhost:8080/disassocia-tutti-colore-taglia', dto);
    oss.subscribe(r => {
      this.listaColoreTagliaAss = r.listaColoreTaglie;
      this.selezionaColoreDis(this.prodottoColore);
    })
  }

  associa(t: VarianteTaglia) {
    let dto: ColoreTagliaDto = new ColoreTagliaDto();
    let coloreTaglia: ColoreTaglia = new ColoreTaglia();
    dto.coloreTaglia = coloreTaglia;
    dto.coloreTaglia.varianteTaglia = t;
    dto.coloreTaglia.prodottoColore = this.prodottoColore;
    let oss: Observable<ListaColoreTaglieDto> = this.http.post<ListaColoreTaglieDto>('http://localhost:8080/associa-colore-taglia', dto);
    oss.subscribe(m => {
      this.listaColoreTagliaAss = m.listaColoreTaglie;
      this.selezionaColoreDis(this.prodottoColore);
    })
  }

  associaAll() {
    let dto: ProdottoColoreDto = new ProdottoColoreDto();
    dto.prodottoColore = this.prodottoColore;
    let oss: Observable<ListaColoreTaglieDto> = this.http.post<ListaColoreTaglieDto>('http://localhost:8080/associa-tutti-colore-taglia', dto);
    oss.subscribe(p => {
      this.listaColoreTagliaAss = p.listaColoreTaglie;
      this.selezionaColoreDis(this.prodottoColore);
    })
  }

  //metodi paginazione
  caricaListaProdottiPaginati(numPaginaV: number) { // <--- personalizzare 
    this.numPaginaV = numPaginaV;
    if (this.numPaginaV > 0) {
      let dto: RicercaDatiPageDto = new RicercaDatiPageDto();
      dto.numPag = this.numPaginaV - 1;
      dto.elemPag = this.elemPag;
      dto.criterio = this.criterio;
      let oss: Observable<PageDto> = this.http.post<PageDto>
        ("http://localhost:8080/cerca-prodotti-criterio", dto); // <--- personalizzare 
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
          this.caricaListaProdottiPaginati(this.numPaginaV); // <--- personalizzare 
        }
      });
    }
    else {
      this.numPag = 0;
      this.numPaginaV = this.numPag + 1;
      this.caricaListaProdottiPaginati(this.numPaginaV); // <--- personalizzare 
    }
  }

  goToNext(numPaginaV: number) {
    console.log("sono in next del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag += 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaListaProdottiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToPrevious(numPaginaV: number) {
    console.log("sono in prev del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag -= 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaListaProdottiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToFirst(numPaginaV: number) {
    console.log("sono in first del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag = numPaginaV - 1;
    this.caricaListaProdottiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToLast(numPaginaV: number) {
    console.log("sono in last del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPag = this.totalPages - 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaListaProdottiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  setElemPag(elemPag: number) {
    console.log("sono in setElemPage del padre")
    this.elemPag = elemPag;
    console.log("elemPag: ", elemPag);
    this.numPag = 0;
    this.numPaginaV = this.numPag + 1;
    this.caricaListaProdottiPaginati(this.numPaginaV); // <--- personalizzare
  }
}
