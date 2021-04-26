import { Component, OnInit } from '@angular/core';
import { CriterioRicercaService } from '../criterio-ricerca.service';
import { Router } from '@angular/router';
import { ReduxService } from '../redux.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['../theme.css'],
})
export class HeaderComponent implements OnInit {
  elementiCarrello: number = this.reduxService.numElementi;

  constructor(private criterioRicercaService: CriterioRicercaService,
    private router: Router,
    private reduxService: ReduxService) {

    reduxService.leggiCarrello$.subscribe(
      n => { this.elementiCarrello = n }
    )
  }

  ngOnInit(): void { }

  goToResultPage(criterio: string): void {
    console.log("siamo nel result page", criterio);
    this.router.navigateByUrl('/ricerca-catalogo');
    this.criterioRicercaService.notifyCriterion(criterio);
    console.log("siamo in result page", this.router.url);
  }
}
