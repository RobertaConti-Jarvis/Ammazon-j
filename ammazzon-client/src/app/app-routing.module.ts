import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnagraficaProdottoComponent } from './anagrafica-prodotto/anagrafica-prodotto.component';
import { AssociaColoriAProdottiComponent } from './associa-colori-a-prodotti/associa-colori-a-prodotti.component';
import { AssociaTaglieColoriComponent } from './associa-taglie-colori/associa-taglie-colori.component';
import { GestioneUtenteRegistratoComponent } from './gestione-utente-registrato/gestione-utente-registrato.component';
import { GestisciColoriComponent } from './gestisci-colori/gestisci-colori.component';
import { GestisciTaglieComponent } from './gestisci-taglie/gestisci-taglie.component';
import { HomePageComponent } from './home-page/home-page.component';

const routes: Routes = [
  { path: 'gestisci-taglie', component: GestisciTaglieComponent },
  { path: 'associa-taglie-colori', component: AssociaTaglieColoriComponent },
  { path: 'anagrafica-prodotto', component: AnagraficaProdottoComponent },
  { path: 'home-page', component: HomePageComponent },
  { path: 'gestisci-colori', component: GestisciColoriComponent },
  { path: 'associa-colori-a-prodotti', component: AssociaColoriAProdottiComponent },
  {path: 'gestione-utente-registrato', component: GestioneUtenteRegistratoComponent},
  { path: '', redirectTo: '/home-page', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
