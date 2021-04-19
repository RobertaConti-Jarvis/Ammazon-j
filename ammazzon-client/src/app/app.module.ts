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
<<<<<<< Updated upstream
import { AssociaColoriAProdottiComponent } from './associa-colori-a-prodotti/associa-colori-a-prodotti.component';
=======
<<<<<<< HEAD
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
=======
import { AssociaColoriAProdottiComponent } from './associa-colori-a-prodotti/associa-colori-a-prodotti.component';
>>>>>>> c0c58f4d82accfcd3edd81eec9db0489033eca66
>>>>>>> Stashed changes

@NgModule({
  declarations: [		
    AppComponent,
    GestisciTaglieComponent,
    AssociaTaglieColoriComponent,
    AnagraficaProdottoComponent,
    HomePageComponent,
    GestisciColoriComponent,
    PaginationComponent,
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
      HeaderComponent,
      FooterComponent
   ],
=======
>>>>>>> Stashed changes
    AssociaColoriAProdottiComponent,
  ],
>>>>>>> c0c58f4d82accfcd3edd81eec9db0489033eca66
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
