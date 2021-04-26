import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ColoreTagliaDto } from '../dto/colore-taglia-dto';
import { ListaColoreTaglieDto } from '../dto/lista-colore-taglie-dto';
import { ListaProdottiColoreDto } from '../dto/lista-prodotti-colore-dto';
import { OrdineDto } from '../dto/ordine-dto';
import { ProdottoColoreDto } from '../dto/prodotto-colore-dto';
import { ProdottoDto } from '../dto/prodotto-dto';
import { ColoreTaglia } from '../entità/colore-taglia';
import { Ordine } from '../entità/ordine';
import { Prodotto } from '../entità/prodotto';
import { ProdottoColore } from '../entità/prodotto-colore';
import { ReduxService } from '../redux.service';
import { TokenService } from '../token.service';

@Component({
  selector: 'app-scheda-prodotto',
  templateUrl: './scheda-prodotto.component.html',
  styleUrls: ['../theme.css'],
})
export class SchedaProdottoComponent implements OnInit {
  prodotto: Prodotto = this.reduxService.prodotto;
  colori: ProdottoColore[] = [];
  taglie: ColoreTaglia[] = [];
  prodottoColore: ProdottoColore;
  ordine: Ordine;
  tagliaSelezionata: ColoreTaglia;
  coloreSelezionato: ProdottoColore;
  risposta: string;

  constructor(private http: HttpClient, private reduxService: ReduxService, private tokenService: TokenService) {
    //this.selezionaProdotto(this.prodotto)
    reduxService.elementiCarrello$.subscribe(
      n => { reduxService.numElementi = n + 1; }
    );

    this.mostraColoriDisponibili();
  }

  ngOnInit(): void {
  }

  mostraColoriDisponibili() {
    //da prodotto selezionato dal catalogo mostro i colori disponibili
    let dto: ProdottoDto = new ProdottoDto();
    dto.prodotto = this.reduxService.prodotto;
    let oss: Observable<ListaProdottiColoreDto> = this.http.post<ListaProdottiColoreDto>('http://localhost:8080/mostra-prodotto-colori', dto);
    oss.subscribe(r => this.colori = r.listaProdottiColore);
  }

  selezionaColore() {
    console.log("la descrizione è " + this.coloreSelezionato.id);
    let dto: ProdottoColoreDto = new ProdottoColoreDto();
    dto.prodottoColore = this.coloreSelezionato;
    this.prodottoColore = this.coloreSelezionato;
    let oss: Observable<ListaColoreTaglieDto> = this.http.post<ListaColoreTaglieDto>('http://localhost:8080/mostra-coloretaglie-associate', dto);
    oss.subscribe(r => this.taglie = r.listaColoreTaglie);
  }

  aggiungi() {
    //richiamo i metodi del redux per incrementare il numero di elementi carrello
    this.reduxService.aggiungiElementoCarrello(this.reduxService.numElementi++);
    console.log("la taglia è " + this.tagliaSelezionata.id);
    //aggiungo prodotto selezionato al carrello: ColoreTaglia + token
    let dto: ColoreTagliaDto = new ColoreTagliaDto();
    dto.coloreTaglia = this.tagliaSelezionata;
    dto.sessionToken = this.tokenService.token;
    let oss: Observable<OrdineDto> = this.http.post<OrdineDto>('http://localhost:8080/aggiungi-carrello', dto);
    oss.subscribe(t => {
      this.ordine = t.ordine;
      this.reduxService.numElementi = t.numElem;
      this.reduxService.leggiElementiCarrello(this.reduxService.numElementi);
      this.tokenService.token = t.sessionToken;
    });
    this.risposta = "Prodotto aggiunto al carrello";
  }

}
