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


  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {
    let dto: CriterioRicercaDto = new CriterioRicercaDto();
    dto.criterio = this.criterio;
    let oss: Observable<ListaProdottiDto> = this.http.post<ListaProdottiDto>('http://localhost:8080/cerca-prodotti-criterio', dto);
    oss.subscribe(r => this.listaProdotti = r.listaProdotti);
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

  }

}
