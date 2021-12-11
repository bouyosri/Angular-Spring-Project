import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFactureComponent } from './GestionFactures/add-facture/add-facture.component';
import { ListFacturesPayerComponent } from './GestionFactures/list-factures-payer/list-factures-payer.component';
import { ListFacturesComponent } from './GestionFactures/list-factures/list-factures.component';
import { UpdateFactureComponent } from './GestionFactures/update-facture/update-facture.component';
import { ListClientComponent } from './list-client/list-client.component';
import { TestComponent } from './test/test.component';

const routes: Routes = [
  {path:"home", component:TestComponent},
  {path:"listclient", component:ListClientComponent},
  {path:"facturenonpayer", component:ListFacturesComponent},
  {path:"facturepayer", component:ListFacturesPayerComponent},
  {path:"facture/add", component:AddFactureComponent},
  {path:"facture/update/:id", component:UpdateFactureComponent},
  {path:"", redirectTo:"home", pathMatch:"full"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
