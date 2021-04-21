import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { EsitoLoginDto } from '../dto/esito-login-dto';
import { UtenteRegistratoDto } from '../dto/utente-registrato-dto';
import { UtenteRegistrato } from '../entità/utente-registrato';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['../theme.css']
})
export class LoginPageComponent implements OnInit {

  utenteReg = new UtenteRegistrato();
  esitoLogin : boolean;
  errorMsg : string = "";

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  checkLogin(){
    let dto: UtenteRegistratoDto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utenteReg;
    let oss: Observable<EsitoLoginDto> = this.http.post<EsitoLoginDto>(
      "http://localhost:8080/check-login",dto
    );
    oss.subscribe(v => (v.esitoLogin) ? 
      this.router.navigateByUrl("/home-page") :
      this.errorMsg = "Corrispondenza credenziali non trovata"
    );
  }
}
