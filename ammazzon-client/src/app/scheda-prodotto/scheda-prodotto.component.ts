import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ListaColoreTaglieDto } from '../dto/lista-colore-taglie-dto';
import { ListaProdottiColoreDto } from '../dto/lista-prodotti-colore-dto';
import { ProdottoColoreDto } from '../dto/prodotto-colore-dto';
import { ProdottoDto } from '../dto/prodotto-dto';
import { ColoreTaglia } from '../entità/colore-taglia';
import { Prodotto } from '../entità/prodotto';
import { ProdottoColore } from '../entità/prodotto-colore';
import { ReduxService } from '../redux.service';

@Component({
  selector: 'app-scheda-prodotto',
  templateUrl: './scheda-prodotto.component.html',
  styleUrls: ['../theme.css'],
})
export class SchedaProdottoComponent implements OnInit {
  prodotto: Prodotto = this.reduxService.prodotto;
  colori: ProdottoColore[] = [];
  taglie: ColoreTaglia [] = [];
  prodottoColore: ProdottoColore;

  constructor(private http: HttpClient, private reduxService: ReduxService) { 
    //this.selezionaProdotto(this.prodotto)
    reduxService.elementiCarrello$.subscribe(
      n => {reduxService.numElementi = n + 1;}
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

  selezionaColore(c: ProdottoColore){
    let dto: ProdottoColoreDto = new ProdottoColoreDto();
    dto.prodottoColore = c;
    this.prodottoColore = c;
    let oss: Observable<ListaColoreTaglieDto> = this.http.post<ListaColoreTaglieDto>('http://localhost:8080/mostra-coloretaglie-associate', dto);
    oss.subscribe(r => this.taglie = r.listaColoreTaglie);
  }

  aggiungi(t: ColoreTaglia){
    //richiamo i metodi del redux per incrementare il numero di elementi carrello
    this.reduxService.aggiungiElementoCarrello(this.reduxService.numElementi++);
    this.reduxService.leggiElementiCarrello(this.reduxService.numElementi);

    //aggiungo prodotto selezionato al carrello: ColoreTaglia + token
  }

}
