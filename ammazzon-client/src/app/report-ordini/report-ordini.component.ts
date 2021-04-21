import {Component, OnInit} from '@angular/core';
import {FiltriOrdiniDto} from '../dto/filtri-ordini-dto';
import {Observable} from 'rxjs';
import {ListaOrdiniDto} from '../dto/lista-ordini-dto';
import {HttpClient} from '@angular/common/http';
import {Ordine} from '../entità/ordine';

@Component({
  selector: 'app-report-ordini',
  templateUrl: './report-ordini.component.html',
  styleUrls: ['./report-ordini.component.css']
})
export class ReportOrdiniComponent implements OnInit {
  stato: string;
  ordine: string;
  tipo: string;
  listaOrdini: Ordine[] = [];

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

}
