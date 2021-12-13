import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Stock } from 'src/app/stock';
import { StockService } from 'src/app/stock.service';


@Component({
  selector: 'app-stock',
  templateUrl: './create-stock.component.html',
  styleUrls: ['./create-stock.component.css'],
})
export class CreateStockComponent implements OnInit {
  stockList: any;
  /*body: any = {
    idStock: 7,
    qte: 3,
    qteMin: 2,
    libelleStock: 'eee body',
  };*/
  stock: Stock = new Stock();
  constructor(private stockService: StockService, private router: Router) {}

  ngOnInit(): void {
    this.getAllStock();
  }

  getAllStock() {
    this.stockService.getAllStocks().subscribe((res) => {
      this.stockList = res;
    });
  }

  saveStock() {
    this.stockService.createStock(this.stock).subscribe(
      (data) => {
        console.log(data);
        this.goToStockList();
      },
      (error) => console.log(error)
    );
  }
  goToStockList() {
    this.router.navigate(['/stocks']);
  }
  onSubmit() {
    console.log(this.stock);
    this.saveStock();
  }
}
