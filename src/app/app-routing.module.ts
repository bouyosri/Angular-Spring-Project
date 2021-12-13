import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFactureComponent } from './GestionFactures/add-facture/add-facture.component';
import { ListFacturesPayerComponent } from './GestionFactures/list-factures-payer/list-factures-payer.component';
import { ListFacturesComponent } from './GestionFactures/list-factures/list-factures.component';
import { UpdateFactureComponent } from './GestionFactures/update-facture/update-facture.component';
import { CreateReclamationComponent } from './GestionReclamation/create-reclamation/create-reclamation.component';
import { ReclamationDetailsComponent } from './GestionReclamation/reclamation-details/reclamation-details.component';
import { ReclamationListComponent } from './GestionReclamation/reclamation-list/reclamation-list.component';
import { ReclamationUpdateComponent } from './GestionReclamation/reclamation-update/reclamation-update.component';
import { CreateStockComponent } from './GestionStock/create-stock/create-stock.component';
import { StockDetailsComponent } from './GestionStock/stock-details/stock-details.component';
import { StockListComponent } from './GestionStock/stock-list/stock-list.component';
import { UpdateStockComponent } from './GestionStock/update-stock/update-stock.component';
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
  { path: 'stocks', component: StockListComponent },
  { path: 'create-stock', component: CreateStockComponent },
  { path: '', redirectTo: 'stocks', pathMatch: 'full' },
  { path: 'stock-details/:idStock', component: StockDetailsComponent },
  { path: 'update-stock/:idStock', component: UpdateStockComponent },
  {
    path: 'reclamation-update/:idReclamation',
    component: ReclamationUpdateComponent,
  },

  { path: 'reclamation-details/:id', component: ReclamationDetailsComponent },
  { path: 'reclamation-list', component: ReclamationListComponent },
  {
    path: 'create-reclamation',
    component: CreateReclamationComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
