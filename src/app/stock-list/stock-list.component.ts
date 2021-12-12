import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { StockService } from '../stock.service';
@Component({
  selector: 'app-stock-list',
  templateUrl: './stock-list.component.html',
  styleUrls: ['./stock-list.component.css'],
})
export class StockListComponent implements OnInit {
  stockList: any;
  libelleStock: any;

  constructor(private stockService: StockService, private router: Router) {}
  ngOnInit(): void {
    this.getAllStock();
  }

  getAllStock() {
    this.stockService.getAllStocks().subscribe((res) => {
      this.stockList = res;
    });
  }
  StockDetails(id: number) {
    this.router.navigate(['stock-details', id]);
  }

  updateStock(id: number) {
    this.router.navigate(['update-stock', id]);
  }

  deleteStock(id: number) {
    this.stockService.deleteStock(id).subscribe((data) => {
      console.log(data);
      this.getAllStock();
    });
  }
  Search() {
    if (this.libelleStock != '') {
      this.stockList = this.stockList.filter((res: any) => {
        return res.libelleStock
          .toLocaleLowerCase()
          .match(this.libelleStock.toLocaleLowerCase());
      });
    } else if (this.libelleStock == '') {
      this.ngOnInit();
    }
  }
  exportToExcel() {
    this.stockService.exportExcel().subscribe((responseMessage: any) => {
      let file = new Blob([responseMessage], {
        type: 'application/vnd.ms-excel',
      });
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    });
  }

  upload(event: any) {
    this.stockService
      .pushFileToStorage(event.target.files[0])
      .subscribe((event) => {});
  }
  exportToPDF() {
    this.stockService.exportPDF().subscribe((responseMessage: any) => {
      let file = new Blob([responseMessage], {
        type: 'application/vnd.ms-excel',
      });
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    });
  }
}
