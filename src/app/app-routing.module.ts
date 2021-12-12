import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFournisseurComponent } from './fournisseur/add-fournisseur/add-fournisseur.component';
import { ListFournisseurComponent } from './fournisseur/list-fournisseur/list-fournisseur.component';
import { UpdateFournisseurComponent } from './fournisseur/update-fournisseur/update-fournisseur.component';
import { AddFactureComponent } from './GestionFactures/add-facture/add-facture.component';
import { ListFacturesPayerComponent } from './GestionFactures/list-factures-payer/list-factures-payer.component';
import { ListFacturesComponent } from './GestionFactures/list-factures/list-factures.component';
import { UpdateFactureComponent } from './GestionFactures/update-facture/update-facture.component';
import { ListClientComponent } from './list-client/list-client.component';
import { ListRayonComponent } from './Rayon/list-rayon/list-rayon.component';
import { TestComponent } from './test/test.component';

const routes: Routes = [
  {path:"home", component:TestComponent},
  {path:"listclient", component:ListClientComponent},
  {path:"facturenonpayer", component:ListFacturesComponent},
  {path:"facturepayer", component:ListFacturesPayerComponent},
  {path:"facture/add", component:AddFactureComponent},
  {path:"facture/update/:id", component:UpdateFactureComponent},
  {path:"", redirectTo:"home", pathMatch:"full"},
  {path:"fournisseur",component:ListFournisseurComponent},
  {path:"fournisseur/update/:id",component:UpdateFournisseurComponent},
  {path:"fournisseur/add",component:AddFournisseurComponent},
  {path:"rayon",component:ListRayonComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
