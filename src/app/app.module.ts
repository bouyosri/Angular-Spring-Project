import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CreateStockComponent } from './create-stock/create-stock.component';
import { StockListComponent } from './stock-list/stock-list.component';
import { UpdateStockComponent } from './update-stock/update-stock.component';

import { StockDetailsComponent } from './stock-details/stock-details.component';
import { AppRoutingModule } from './app-routing.module';
import { CreateReclamationComponent } from './create-reclamation/create-reclamation.component';
import { ReclamationListComponent } from './reclamation-list/reclamation-list.component';
import { ReclamationDetailsComponent } from './reclamation-details/reclamation-details.component';
import { ReclamationUpdateComponent } from './reclamation-update/reclamation-update.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateStockComponent,
    StockListComponent,
    UpdateStockComponent,

    StockDetailsComponent,
    CreateReclamationComponent,
    ReclamationListComponent,
    ReclamationDetailsComponent,
    ReclamationUpdateComponent,
  ],
  imports: [BrowserModule, HttpClientModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
