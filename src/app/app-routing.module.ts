import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { StockListComponent } from './stock-list/stock-list.component';
import { CreateStockComponent } from './create-stock/create-stock.component';
import { UpdateStockComponent } from './update-stock/update-stock.component';
import { StockDetailsComponent } from './stock-details/stock-details.component';
import { CreateReclamationComponent } from './create-reclamation/create-reclamation.component';
import { ReclamationListComponent } from './reclamation-list/reclamation-list.component';
import { ReclamationDetailsComponent } from './reclamation-details/reclamation-details.component';
import { ReclamationUpdateComponent } from './reclamation-update/reclamation-update.component';

const routes: Routes = [
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
  exports: [RouterModule],
})
export class AppRoutingModule {}
