import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Stock } from '../stock';
import { StockService } from '../stock.service';

@Component({
  selector: 'app-update-stock',
  templateUrl: './update-stock.component.html',
  styleUrls: ['./update-stock.component.css'],
})
export class UpdateStockComponent implements OnInit {
  idStock: any;
  stock: Stock = new Stock();

  constructor(
    private stockService: StockService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.idStock = this.route.snapshot.params['idStock'];
    this.stockService.getStockById(this.idStock).subscribe(
      (data) => {
        this.stock = data;
      },
      (error) => console.log(error)
    );
  }
  onSubmit() {
    this.stockService.updateStock(this.idStock, this.stock).subscribe(
      (data) => {
        this.goToStockList();
      },
      (error) => console.log(error)
    );
  }
  goToStockList() {
    this.router.navigate(['/stocks']);
  }
}
