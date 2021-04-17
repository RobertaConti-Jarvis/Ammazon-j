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

@NgModule({
  declarations: [
    AppComponent,
    GestisciTaglieComponent,
    AssociaTaglieColoriComponent,
    AnagraficaProdottoComponent,
    HomePageComponent,
    GestisciColoriComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
