import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GestisciTaglieComponent } from './gestisci-taglie/gestisci-taglie.component';
import { AssociaTaglieColoriComponent } from './associa-taglie-colori/associa-taglie-colori.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AnagraficaProdottoComponent } from './anagrafica-prodotto/anagrafica-prodotto.component';
import { HomePageComponent } from './home-page/home-page.component';
import { GestisciColoriComponent } from './gestisci-colori/gestisci-colori.component';
import { PaginationComponent } from './pagination/pagination.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AssociaColoriAProdottiComponent } from './associa-colori-a-prodotti/associa-colori-a-prodotti.component';
import { GestioneUtenteRegistratoComponent } from './gestione-utente-registrato/gestione-utente-registrato.component';
import { RegistrazionePageComponent } from './registrazione-page/registrazione-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { ReportOrdiniComponent } from './report-ordini/report-ordini.component';

@NgModule({
  declarations: [
    AppComponent,
    GestisciTaglieComponent,
    AssociaTaglieColoriComponent,
    AnagraficaProdottoComponent,
    HomePageComponent,
    GestisciColoriComponent,
    PaginationComponent,
    AssociaColoriAProdottiComponent,
    HeaderComponent,
    FooterComponent,
    AssociaColoriAProdottiComponent,
    GestioneUtenteRegistratoComponent,
    RegistrazionePageComponent,
    LoginPageComponent,
    ReportOrdiniComponent,
    
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
