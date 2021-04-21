import { Component, OnInit } from '@angular/core';
import { UtenteRegistrato } from '../entità/utente-registrato';

@Component({
  selector: 'app-registrazione-page',
  templateUrl: './registrazione-page.component.html',
  styleUrls: ['../theme.css']
})
export class RegistrazionePageComponent implements OnInit {

  utenteReg = new UtenteRegistrato();
  esitoRegistrazione : boolean;
  errorMsg : string = "";

  constructor() { }

  ngOnInit(): void {
  }

  signIn(){

  }
}
