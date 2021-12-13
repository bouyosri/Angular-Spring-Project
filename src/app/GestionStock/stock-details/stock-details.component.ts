import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Stock } from 'src/app/stock';
import { StockService } from 'src/app/stock.service';


@Component({
  selector: 'app-stock-details',
  templateUrl: './stock-details.component.html',
  styleUrls: ['./stock-details.component.css'],
})
export class StockDetailsComponent implements OnInit {
  idStock: any;
  stock: any;
  constructor(
    private route: ActivatedRoute,
    private stockService: StockService
  ) {}

  ngOnInit(): void {
    this.idStock = this.route.snapshot.params['idStock'];
    this.stock = new Stock();
    this.stockService.getStockById(this.idStock).subscribe((data) => {
      this.stock = data;
    });
  }
}
