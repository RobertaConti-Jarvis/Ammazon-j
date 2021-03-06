import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnagraficaProdottoComponent } from './anagrafica-prodotto/anagrafica-prodotto.component';
import { AssociaColoriAProdottiComponent } from './associa-colori-a-prodotti/associa-colori-a-prodotti.component';
import { AssociaTaglieColoriComponent } from './associa-taglie-colori/associa-taglie-colori.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { GestioneAccountComponent } from './gestione-account/gestione-account.component';
import { GestioneCarrelloComponent } from './gestione-carrello/gestione-carrello.component';
import { GestioneUtenteRegistratoComponent } from './gestione-utente-registrato/gestione-utente-registrato.component';
import { GestisciColoriComponent } from './gestisci-colori/gestisci-colori.component';
import { GestisciTaglieComponent } from './gestisci-taglie/gestisci-taglie.component';
import { GruppoDueReduxComponent } from './gruppo-due-redux/gruppo-due-redux.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegistrazionePageComponent } from './registrazione-page/registrazione-page.component';
import { ReportOrdiniComponent } from './report-ordini/report-ordini.component';
import { RicercaCatalogoComponent } from './ricerca-catalogo/ricerca-catalogo.component';
import { SchedaProdottoComponent } from './scheda-prodotto/scheda-prodotto.component';

const routes: Routes = [
  { path: 'gestisci-taglie', component: GestisciTaglieComponent },
  { path: 'associa-taglie-colori', component: AssociaTaglieColoriComponent },
  { path: 'anagrafica-prodotto', component: AnagraficaProdottoComponent },
  { path: 'home-page', component: HomePageComponent },
  { path: 'gestisci-colori', component: GestisciColoriComponent },
  { path: 'associa-colori-a-prodotti', component: AssociaColoriAProdottiComponent },
  { path: 'gestione-utente-registrato', component: GestioneUtenteRegistratoComponent },
  { path: 'registrazione', component: RegistrazionePageComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'report-ordini', component: ReportOrdiniComponent },
  { path: 'ricerca-catalogo', component: RicercaCatalogoComponent },
  { path: 'gestione-carrello', component: GestioneCarrelloComponent },
  { path: 'redux-due', component: GruppoDueReduxComponent },
  { path: 'scheda-prodotto', component: SchedaProdottoComponent },
  { path: 'checkout', component: CheckoutComponent},
  { path: 'gestione-account', component: GestioneAccountComponent},
  { path: '', redirectTo: '/home-page', pathMatch: 'full' }
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
