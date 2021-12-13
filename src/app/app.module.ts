import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { TestComponent } from './test/test.component';
import { ListClientComponent } from './list-client/list-client.component';
import { AddFactureComponent } from './GestionFactures/add-facture/add-facture.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListFacturesComponent } from './GestionFactures/list-factures/list-factures.component';
import { ListFacturesPayerComponent } from './GestionFactures/list-factures-payer/list-factures-payer.component';
import { UpdateFactureComponent } from './GestionFactures/update-facture/update-facture.component';
import { ViewFactureComponent } from './GestionFactures/view-facture/view-facture.component';
import { CreateReclamationComponent } from './GestionReclamation/create-reclamation/create-reclamation.component';
import { ReclamationDetailsComponent } from './GestionReclamation/reclamation-details/reclamation-details.component';
import { ReclamationListComponent } from './GestionReclamation/reclamation-list/reclamation-list.component';
import { ReclamationUpdateComponent } from './GestionReclamation/reclamation-update/reclamation-update.component';
import { CreateStockComponent } from './GestionStock/create-stock/create-stock.component';
import { StockDetailsComponent } from './GestionStock/stock-details/stock-details.component';
import { StockListComponent } from './GestionStock/stock-list/stock-list.component';
import { UpdateStockComponent } from './GestionStock/update-stock/update-stock.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TestComponent,
    ListClientComponent,
    AddFactureComponent,
    ListFacturesComponent,
    ListFacturesPayerComponent,
    UpdateFactureComponent,
    ViewFactureComponent,
    CreateReclamationComponent,
    ReclamationDetailsComponent,
    ReclamationListComponent,
    ReclamationUpdateComponent,
    CreateStockComponent,
    StockDetailsComponent,
    StockListComponent,
    UpdateStockComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
