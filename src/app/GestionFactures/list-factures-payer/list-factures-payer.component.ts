import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Facture } from 'src/app/Models/facture';
import { FactureService } from 'src/app/Services/facture.service';

@Component({
  selector: 'app-list-factures-payer',
  templateUrl: './list-factures-payer.component.html',
  styleUrls: ['./list-factures-payer.component.css']
})
export class ListFacturesPayerComponent implements OnInit {

  listFactures: Facture[];

  constructor(private factureService : FactureService, private router : Router ) { }

  ngOnInit(): void {
  this.retrievePaidFacture();
  }
  retrievePaidFacture(){
    this.factureService.getPaidFactures().subscribe(
      res => {
        console.log('Factures :');
        this.listFactures= res ;
        console.log(this.listFactures);
      });
    err => {
      console.log(err);
    }
  }
  deleteFacture(idFacture: number){
    this.factureService.deleteFactureById(idFacture).subscribe(
      res => {
        console.log('Facture deleted!');
        this.retrievePaidFacture();
      });
    err => {
      console.log(err);
    }
  }
  updateFacture(id:number){
    this.router.navigate(['/facture/update',id])
  }
}
