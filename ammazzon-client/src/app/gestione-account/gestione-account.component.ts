import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UtenteRegistrato } from '../entità/utente-registrato';
import { TokenService } from '../token.service';

@Component({
  selector: 'app-gestione-account',
  templateUrl: './gestione-account.component.html',
  styleUrls: ['../theme.css']
})
export class GestioneAccountComponent implements OnInit {

  utenteLoggato: UtenteRegistrato = new UtenteRegistrato();

  constructor(private http: HttpClient , private router: Router, public tokenService: TokenService) { }

  ngOnInit(): void {
  }

  save(){

  }

}
