import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GestisciTaglieComponent } from './gestisci-taglie/gestisci-taglie.component';
import { AssociaTaglieColoriComponent } from './associa-taglie-colori/associa-taglie-colori.component';

@NgModule({
  declarations: [
    AppComponent,
    GestisciTaglieComponent,
    AssociaTaglieColoriComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
