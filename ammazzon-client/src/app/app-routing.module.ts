import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AssociaTaglieColoriComponent } from './associa-taglie-colori/associa-taglie-colori.component';
import { GestisciTaglieComponent } from './gestisci-taglie/gestisci-taglie.component';

const routes: Routes = [
  { path: 'gestisci-taglie', component: GestisciTaglieComponent },
  { path: 'associa-taglie-colori', component: AssociaTaglieColoriComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
