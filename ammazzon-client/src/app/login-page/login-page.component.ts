import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { EsitoUtenteDto } from '../dto/esito-utente-dto';
import { UtenteRegistratoDto } from '../dto/utente-registrato-dto';
import { UtenteRegistrato } from '../entità/utente-registrato';
import { TokenService } from '../token.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['../theme.css']
})
export class LoginPageComponent implements OnInit {

  utenteReg = new UtenteRegistrato();
  errorMsg : string = "";
  disableButtonL : boolean = true;
  errorPassword : string;
  errorUsername : string;
  //variabili bottone login
  usernameOk : boolean = false;
  passwordOk : boolean = false;

  constructor(private http: HttpClient, private router: Router , public tokenService: TokenService) { }

  ngOnInit(): void {
  }

  checkUsername(){
    if(!this.utenteReg.username){
      this.errorUsername = "inserisci un Username";
      this.usernameOk = false;
    }
    else{
      this.errorUsername = "";
      this.usernameOk = true;
    }
  }

  checkPassword(){
    var searchFind : boolean;
    var regExpPsw = new RegExp("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])([A-Za-z0-9]{8,})$");
    searchFind = regExpPsw.test(this.utenteReg.password);
    console.log("searcFind Password: " , searchFind);
    console.log("password: ", this.utenteReg.password);
    if (searchFind){
      this.passwordOk = true;
      this.errorPassword = "";
    }
    else{
      this.passwordOk = false;
      this.errorPassword = "Password non valida!"
    }
  }

  checkLogin(){
    console.log("Sono in checkLogin()");
    let dto: UtenteRegistratoDto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utenteReg;
    dto.sessionToken = this.tokenService.token;
    let oss: Observable<EsitoUtenteDto> = this.http.post<EsitoUtenteDto>( 
      "http://localhost:8080/check-login",dto
    );
    oss.subscribe(v => {
      if (v.esito){
        this.utenteReg = v.utenteReg;
        this.tokenService.token = v.sessionToken;
        console.log ("tokenService: ", this.tokenService.token);
        this.router.navigateByUrl("/home-page");
        this.errorMsg = "";
      }
      else {
        this.errorMsg = "Corrispondenza credenziali non trovata";
      }
    });
  }
}
