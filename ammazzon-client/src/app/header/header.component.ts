import { Component, OnInit } from '@angular/core';
import {CriterioRicercaService} from '../criterio-ricerca.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['../theme.css'],
})
export class HeaderComponent implements OnInit {
  constructor(private criterioRicercaService: CriterioRicercaService, private router: Router) {}

  ngOnInit(): void {}

  goToResultPage(criterio: string): void {
    this.criterioRicercaService.criterioRicerca = criterio;
    this.router.navigateByUrl('/ricerca-catalogo');
  }
}
