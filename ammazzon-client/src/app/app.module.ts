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
import { BarraRicercaComponent } from './barra-ricerca/barra-ricerca.component';
import { RicercaCatalogoComponent } from './ricerca-catalogo/ricerca-catalogo.component';
import { GestioneCarrelloComponent } from './gestione-carrello/gestione-carrello.component';
import { GruppoDueReduxComponent } from './gruppo-due-redux/gruppo-due-redux.component';
import { SchedaProdottoComponent } from './scheda-prodotto/scheda-prodotto.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { GestioneAccountComponent } from './gestione-account/gestione-account.component';

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
    BarraRicercaComponent,
    RicercaCatalogoComponent,
    GestioneCarrelloComponent,
    GruppoDueReduxComponent,
    SchedaProdottoComponent,
    CheckoutComponent,
    GestioneAccountComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
