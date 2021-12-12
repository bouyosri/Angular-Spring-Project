import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { StockService } from './stock.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  categories: string[] = ['Electromenager', 'Alimentaire', 'Quincaillerie'];
  idp = '';
  Code = '';
  Libelle = '';
  PrixU = '';
  isShown: boolean = false;
  buttonShow: boolean = true;
  dateUpdate: boolean = false;

  constructor(private stockService: StockService) {}
  toggleShow() {
    this.isShown = !this.isShown;
    this.buttonShow = !this.buttonShow;
  }
}
