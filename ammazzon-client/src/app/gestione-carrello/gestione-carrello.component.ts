import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseRequestDto } from '../dto/base-request-dto';
import { DatiOrdinePageDto } from '../dto/dati-ordine-page-dto';
import { ListaQtaOrdineVarianteDto } from '../dto/lista-qta-ordine-variante-dto';
import { OrdineDto } from '../dto/ordine-dto';
import { PageDto } from '../dto/page-dto';
import { QtaOrdineVarianteDto } from '../dto/qta-ordine-variante-dto';
import { ColoreTaglia } from '../entità/colore-taglia';
import { Ordine } from '../entità/ordine';
import { Prodotto } from '../entità/prodotto';
import { QtaOrdineVariante } from '../entità/qta-ordine-variante';
import { ReduxService } from '../redux.service';
import { TokenService } from '../token.service';

@Component({
  selector: 'app-gestione-carrello',
  templateUrl: './gestione-carrello.component.html',
  styleUrls: ['../theme.css']
})
export class GestioneCarrelloComponent implements OnInit {

  listaProdotti: Prodotto[] = [];
  ordine: Ordine = new Ordine(); // FIXME: mettere nel costruttore l'associazione della sessione
  listaQuantitaOrdineVariante: QtaOrdineVariante[] = [];
  quantitaOrdineVariante: QtaOrdineVariante = new QtaOrdineVariante();
  coloreTaglia: ColoreTaglia;





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

  constructor(private http: HttpClient, public tokenService: TokenService,
    private reduxService: ReduxService) {
      reduxService.elementiCarrello$.subscribe(
        n => { reduxService.numElementi = n -1; }
      );
      this.mostraCarrello() }

  ngOnInit(): void {
  }

  eliminaProdotto(qov: QtaOrdineVariante) {
    this.quantitaOrdineVariante = qov;
    this.ordine = qov.ordine;
    this.coloreTaglia = qov.coloreTaglia

    //richiamo i metodi del redux per reimpostare il numero di elementi carrello
    this.reduxService.aggiungiElementoCarrello(this.reduxService.numElementi--);

    let dto: QtaOrdineVarianteDto = new QtaOrdineVarianteDto();
    dto.qtaOrdineVariante = this.quantitaOrdineVariante;
    console.log("Siamo in elimina prodotto");
    let ox: Observable<ListaQtaOrdineVarianteDto> = this.http.post<ListaQtaOrdineVarianteDto>(
      "http://localhost:8080/rimuovi-prodotto-ordine", dto);
    ox.subscribe(q => {
      this.listaQuantitaOrdineVariante = q.listaQtaOrdineVariante;
      this.reduxService.leggiElementiCarrello(this.reduxService.numElementi);

    });

  }
  mostraCarrello() {
    const dto: BaseRequestDto = new BaseRequestDto();
    dto.sessionToken = this.tokenService.token;
    console.log("mostraCarrello token", this.tokenService.token);
    const os: Observable<ListaQtaOrdineVarianteDto> = this.http
      .post<ListaQtaOrdineVarianteDto>("http://localhost:8080/mostra-carrello", dto);
    os.subscribe(l => {
      this.listaQuantitaOrdineVariante = l.listaQtaOrdineVariante
    });
  }

  //metodi paginazione
  caricaOrdineProdottiPaginati(numPaginaV: number) { // <--- personalizzare 
    this.numPaginaV = numPaginaV;
    if (this.numPaginaV > 0) {
      let dto: DatiOrdinePageDto = new DatiOrdinePageDto();
      dto.numPag = this.numPaginaV - 1;
      dto.elemPag = this.elemPag;
      let oss: Observable<PageDto> = this.http.post<PageDto>
        ("http://localhost:8080/mostra-carrello-page", dto); // <--- personalizzare 
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
          this.caricaOrdineProdottiPaginati(this.numPaginaV); // <--- personalizzare 
        }
      });
    }
    else {
      this.numPag = 0;
      this.numPaginaV = this.numPag + 1;
      this.caricaOrdineProdottiPaginati(this.numPaginaV); // <--- personalizzare 
    }
  }

  goToNext(numPaginaV: number) {
    console.log("sono in next del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag += 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaOrdineProdottiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToPrevious(numPaginaV: number) {
    console.log("sono in prev del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag -= 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaOrdineProdottiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToFirst(numPaginaV: number) {
    console.log("sono in first del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPaginaV = numPaginaV;
    this.numPag = numPaginaV - 1;
    this.caricaOrdineProdottiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  goToLast(numPaginaV: number) {
    console.log("sono in last del padre");
    console.log("val numPaginaV: ", numPaginaV);
    this.numPag = this.totalPages - 1;
    this.numPaginaV = this.numPag + 1;
    this.caricaOrdineProdottiPaginati(this.numPaginaV); // <--- personalizzare 
  }

  setElemPag(elemPag: number) {
    console.log("sono in setElemPage del padre")
    this.elemPag = elemPag;
    console.log("elemPag: ", elemPag);
    this.numPag = 0;
    this.numPaginaV = this.numPag + 1;
    this.caricaOrdineProdottiPaginati(this.numPaginaV); // <--- personalizzare
  }
}
