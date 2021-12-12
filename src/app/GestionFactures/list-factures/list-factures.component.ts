import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Facture } from 'src/app/Models/facture';
import { FactureService } from 'src/app/Services/facture.service';

@Component({
  selector: 'app-list-factures',
  templateUrl: './list-factures.component.html',
  styleUrls: ['./list-factures.component.css']
})
export class ListFacturesComponent implements OnInit {

  listFactures: Facture[];

  constructor(private factureService: FactureService, private router: Router) { }

  ngOnInit(): void {
    this.retrieveNotPaidFacture()
  }

  retrieveNotPaidFacture() {
    this.factureService.getAllFactures().subscribe(
      res => {
        console.log('Factures :');
        this.listFactures = res;
        console.log(this.listFactures);
      });
    err => {
      console.log(err);
    }
  }

  deleteFacture(idFacture: number) {
    console.log(idFacture)
    this.factureService.deleteFactureById(idFacture).subscribe(
      res => {
        console.log('Facture deleted!');
        this.retrieveNotPaidFacture();
      });
    err => {
      console.log(err);
    }
  }
  updateFacture(id: number) {
    this.router.navigate(['/facture/update', id])
  }

}
