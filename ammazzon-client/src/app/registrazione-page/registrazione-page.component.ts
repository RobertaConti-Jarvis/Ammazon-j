import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { EsitoDto } from '../dto/esito-dto';
import { UsernameDto } from '../dto/username-dto';
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
  errorUsername : string = "";
  errorPassword : string = "";
  errorEmail : string = "";
  disableButtonR : boolean = true; //modificare css per button

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  checkUsername(){ 
    let dto : UsernameDto = new UsernameDto();
    dto.username = this.utenteReg.username;
    let oss: Observable<EsitoDto> = this.http.post<EsitoDto>( 
      "http://localhost:8080/check-username",dto
    );
    oss.subscribe( c =>{
      if (c.esito){
        this.disableButtonR = false;
      }
      else{
        this.disableButtonR = true;
        this.errorUsername = "Username già utilizzato!";
      }
    });
  }

  checkPassword(){
    var searchFind : boolean;
    var regExpPsw = new RegExp("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])([A-Za-z0-9]{8,})$");
    searchFind = regExpPsw.test(this.utenteReg.password);
    console.log("searcFind Password: " , searchFind);
    console.log("password: ", this.utenteReg.password);
    if (searchFind){
      this.disableButtonR = false;
      this.errorPassword = "";
    }
    else{
      this.disableButtonR = true;
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
      this.disableButtonR = false;
      this.errorEmail = "";
    }
    else{
      this.disableButtonR = true;
      this.errorEmail = "Email non valida!"
    }
  }


  signIn(){

  }
}
