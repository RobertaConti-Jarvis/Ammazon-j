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

@Component({
  selector: 'app-scheda-prodotto',
  templateUrl: './scheda-prodotto.component.html',
  styleUrls: ['../theme.css'],
})
export class SchedaProdottoComponent implements OnInit {
  prodotto: Prodotto;
  colori: ProdottoColore[] = [];
  taglie: ColoreTaglia [] = [];
  prodottoColore: ProdottoColore;

  constructor(private http: HttpClient) { 
    //this.selezionaProdotto(this.prodotto)
  }

  ngOnInit(): void {
  }

  aggiungi(){
    
  }

  selezionaColore(c: ProdottoColore){
    let dto: ProdottoColoreDto = new ProdottoColoreDto();
    dto.prodottoColore = c;
    this.prodottoColore = c;
    let oss: Observable<ListaColoreTaglieDto> = this.http.post<ListaColoreTaglieDto>('http://localhost:8080/mostra-coloretaglie-associate', dto);
    oss.subscribe(r => this.taglie = r.listaColoreTaglie);
  }

  selezionaTaglia(t: ColoreTaglia){

  }

  selezionaProdotto(p: Prodotto) {
    let dto: ProdottoDto = new ProdottoDto();
    dto.prodotto = p;
    let oss: Observable<ListaProdottiColoreDto> = this.http.post<ListaProdottiColoreDto>('http://localhost:8080/mostra-prodotto-colori', dto);
    oss.subscribe(r => this.colori = r.listaProdottiColore);
  }

}
