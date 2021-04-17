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

@Component({
  selector: 'app-associa-taglie-colori',
  templateUrl: './associa-taglie-colori.component.html',
  styleUrls: ['./associa-taglie-colori.component.css']
})
export class AssociaTaglieColoriComponent implements OnInit {
  
  criterio: string = "";
  prodotto: Prodotto;
  listaProdotti: Prodotto[] = [];
  prodottoColore: ProdottoColore;
  listaProdottiColori: ProdottoColore[] = [];
  listaColoreTagliaAss: ColoreTaglia[] = [];
  listaColoreTagliaDis: ColoreTaglia[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca(){
    let dto: CriterioRicercaDto = new CriterioRicercaDto();
    dto.criterio = this.criterio;
    let oss: Observable<ListaProdottiDto> = this.http.post<ListaProdottiDto>('http://localhost:8080/cerca-prodotti-criterio', dto);
    oss.subscribe(r => this.listaProdotti = r.listaProdotti);
  }

  selezionaProdotto(p: Prodotto){
    this.prodotto.id = p.id;
    this.prodotto.codice = p.codice;
    this.prodotto.descrizione = p.descrizione;
    this.prodotto.prezzo = p.prezzo;
    let dto: ProdottoDto = new ProdottoDto();
    dto.prodotto = this.prodotto;
    let oss: Observable<ListaProdottiColoreDto> = this.http.post<ListaProdottiColoreDto>('http://localhost:8080/mostra-prodotto-colori', dto);
    oss.subscribe(r => this.listaProdottiColori = r.listaProdottiColore);
  }

  selezionaColore(c: ProdottoColore){
    this.prodottoColore.id = c.id;
    let dto: ProdottoColoreDto = new ProdottoColoreDto();
    dto.prodottoColore = this.prodottoColore;
    let oss: Observable<ListaColoreTaglieDto> = this.http.post<ListaColoreTaglieDto>('http://localhost:8080/mostra-coloretaglie-associate', dto);
    oss.subscribe(r => this.listaColoreTagliaAss = r.listaColoreTaglie);
  }

  selezionaColoreDis(c: ProdottoColore){
    this.prodottoColore.id = c.id;
    let dto: ProdottoColoreDto = new ProdottoColoreDto();
    dto.prodottoColore = this.prodottoColore;
    let oss: Observable<ListaColoreTaglieDto> = this.http.post<ListaColoreTaglieDto>('http://localhost:8080/mostra-coloretaglie-disponibili', dto);
    oss.subscribe(r => this.listaColoreTagliaDis = r.listaColoreTaglie);
  }

  rimuovi(t){
    
  }

  rimuoviAll(){

  }

  associa(t){

  }

  associaAll(){
    
  }

}
