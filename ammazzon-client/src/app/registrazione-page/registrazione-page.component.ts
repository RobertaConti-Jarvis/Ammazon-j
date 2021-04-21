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
  ableButtonR : boolean = false;

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
        this.ableButtonR = true;
      }
      else{
        this.ableButtonR = false;
        this.errorUsername = "Username già utilizzato!";
      }
    });
  }

  signIn(){

  }
}
