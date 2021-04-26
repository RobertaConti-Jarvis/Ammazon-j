import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { EsitoDto } from '../dto/esito-dto';
import { EsitoUtenteDto } from '../dto/esito-utente-dto';
import { UsernameDto } from '../dto/username-dto';
import { UtenteRegistratoDto } from '../dto/utente-registrato-dto';
import { UtenteRegistrato } from '../entità/utente-registrato';
import { TokenService } from '../token.service';

@Component({
  selector: 'app-registrazione-page',
  templateUrl: './registrazione-page.component.html',
  styleUrls: ['../theme.css']
})
export class RegistrazionePageComponent implements OnInit {

  utenteReg = new UtenteRegistrato();
  errorMsg : string = "";
  errorUsername : string = "";
  errorPassword : string = "";
  errorEmail : string = "";
  //variabili bottone registrazione
  usernameOk : boolean = false;
  passwordOk : boolean = false;
  emailOk : boolean = false;

  constructor(private http: HttpClient, private router: Router , public tokenService: TokenService) { }

  ngOnInit(): void {
  }

  checkUsername(){ 
    
    let dto : UsernameDto = new UsernameDto();
    dto.username = this.utenteReg.username;
    console.log(this.utenteReg.username);
    let oss: Observable<EsitoDto> = this.http.post<EsitoDto>( 
      "http://localhost:8080/check-username",dto
    );
    oss.subscribe( c =>{
      if (c.esito){
        this.usernameOk = true;
        this.errorUsername = "";
      }
      else{
        this.usernameOk = false;
        this.errorUsername = "Username già utilizzato!";
      }
    });
    /*if (this.utenteReg.username){   //test funzionamenti senza utilizzare il server
      this.usernameOk = true;
    }
    else{
      this.usernameOk = false;
    }*/
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

  checkEmail(){
    if (!this.utenteReg.email){
      this.utenteReg.email = "";
    }
    var searchFind : boolean;
    var regExpEmail = new RegExp("^\\w+@\\w+\\.\\w{2}$");
    searchFind = regExpEmail.test(this.utenteReg.email);
    console.log("searcFind Email: " , searchFind);
    console.log("email: ", this.utenteReg.email);
    if(searchFind){
      this.emailOk = true;
      this.errorEmail = "";
    }
    else{
      this.emailOk = false;
      this.errorEmail = "Email non valida!"
    }
  }


  signIn(){
    let dto: UtenteRegistratoDto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utenteReg;
    dto.sessionToken = this.tokenService.token;
    let oss: Observable<EsitoUtenteDto> = this.http.post<EsitoUtenteDto>( 
      "http://localhost:8080/registrazione",dto
    );
    oss.subscribe(r => {
      this.utenteReg = r.utenteReg;
      console.log("valore esito: ", r.esito);
      if (r.esito){
        this.tokenService.token = r.sessionToken;
        this.errorEmail = "";
        this.tokenService.token = r.sessionToken;
        this.router.navigateByUrl("/login");
      }
      else{
        this.errorEmail = "Email utilizzata o Utente loggato!";
      }
    });
  }
}
