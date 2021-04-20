import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CriterioRicercaDto } from '../dto/criterio-ricerca-dto';
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { ListeColoriProdottoDto } from '../dto/liste-colori-prodotto-dto';
import { ProdottoDto } from '../dto/prodotto-dto';
import { Prodotto } from '../entità/prodotto';
import { ProdottoColore } from '../entità/prodotto-colore';
import { VarianteColore } from '../entità/variante-colore';

@Component({
  selector: 'app-associa-colori-a-prodotti',
  templateUrl: './associa-colori-a-prodotti.component.html',
  styleUrls: ['./associa-colori-a-prodotti.component.css']
})
export class AssociaColoriAProdottiComponent implements OnInit {

  prodotto: Prodotto = new Prodotto();
  criterio: string;
  listaProdotti: Prodotto[] = [];
  coloriAssociati: VarianteColore[] = [];
  coloriNonAssociati: VarianteColore[] = [];

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
    let dto: ProdottoDto = new ProdottoDto();
    dto.prodotto = this.prodotto;
    let oss: Observable<ListeColoriProdottoDto> = this.http.post<ListeColoriProdottoDto>(
      "http://localhost:8080/seleziona-prodotto-colore", dto);
    oss.subscribe(r => {
      this.coloriAssociati = r.coloriAssociati;
      this.coloriNonAssociati = r.coloriNonAssociati;
    });


  }
  spostaInDisponibili(ca) {

  }

  associaTuttiColori() {

  }

  disassociaTuttiColori() {

  }

}
