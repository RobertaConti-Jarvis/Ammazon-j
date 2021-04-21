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
  disableButtonL : boolean;
  errorPassword : string;
  errorUsername : string;

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  checkUsername(){
    if(!this.utenteReg.username){
      this.errorUsername = "inserisci un Username";
    }
    else{
      this.errorUsername = "";
    }
  }

  checkPassword(){
    var searchFind : boolean;
    var regExpPsw = new RegExp("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])([A-Za-z0-9]{8,})$");
    searchFind = regExpPsw.test(this.utenteReg.password);
    console.log("searcFind Password: " , searchFind);
    console.log("password: ", this.utenteReg.password);
    if (searchFind){
      this.disableButtonL = false;
      this.errorPassword = "";
    }
    else{
      this.disableButtonL = true;
      this.errorPassword = "Password non valida!"
    }
  }

  checkLogin(){
    let dto: UtenteRegistratoDto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utenteReg;
    let oss: Observable<EsitoLoginDto> = this.http.post<EsitoLoginDto>( 
      "http://localhost:8080/check-login",dto
    );
    oss.subscribe(v => {
      if (v.esitoLogin){
        this.utenteReg = v.utenteReg;
        this.router.navigateByUrl("/home-page");
        this.errorMsg = "";
      }
      else {
        this.errorMsg = "Corrispondenza credenziali non trovata";
      }
    });
  }
}
