import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/Models/client';
import { DetailFacture } from 'src/app/Models/detail-facture';
import { Facture } from 'src/app/Models/facture';
import { Produit } from 'src/app/Models/produit';
import { DetailfactureService } from 'src/app/Services/detail-facture.service';
import { FactureService } from 'src/app/Services/facture.service';

@Component({
  selector: 'app-update-facture',
  templateUrl: './update-facture.component.html',
  styleUrls: ['./update-facture.component.css']
})
export class UpdateFactureComponent implements OnInit {
  facture: Facture = new Facture();
  parameter: number;
  message: string = "";
  selectedObject: any;
  dateFacture: string;
  detailFacture: DetailFacture;
  prixTotal: number = 0;
  clients: Client[];
  produits: Produit[];
  details: DetailFacture[];
  myForm: FormGroup;

  constructor(private factureService: FactureService, private dfService: DetailfactureService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.parameter = params['id'];
    })
    this.getFacturefrompath(this.parameter);
    this.getClients();
    this.getProducts();
    this.createDetailFacture();
    this.myForm = new FormGroup({
      // dateBill:new FormControl(this.detailFacture.produit, Validators.required),
      discountAmount: new FormControl(this.detailFacture.qte),
      Status: new FormControl(this.detailFacture.pourcentageRemise)
    })
  }

  createDetailFacture() {
    this.detailFacture = new DetailFacture();
    this.detailFacture.facture = this.facture;
    this.detailFacture.produit = new Produit();
    this.detailFacture.qte = 1;
    this.detailFacture.pourcentageRemise = 0;
    this.detailFacture.montantRemise = 0;
    this.detailFacture.prixTotal = 0;
  }

  // --------------------------- Retrieving methods ----------------------------
  getClients() {
    this.factureService.getClients()
  }
  getProducts() {
    this.factureService.getProducts().subscribe(
      res => {
        console.log('Clients :');
        this.produits = res;
        console.log(this.produits);
      });
    err => {
      console.log(err);
    }
  }

  getDetailFactures(id: number) {
    this.dfService.getDetailFactureByFactureId(id).subscribe(
      res => {
        console.log('details :');
        this.details = res;
        console.log(this.details);
        this.getFacture(this.facture.idFacture);
      });
    err => {
      console.log(err);
    }
  }
  getFacturefrompath(id: number) {
    this.factureService.getFactureById(id).subscribe(
      res => {
        console.log('Facture :');
        this.facture = res;
        console.log(this.facture);
        this.createDetailFacture();
        this.getDetailFactures(this.facture.idFacture);
      });
    err => {
      console.log(err);
    }
  }
  getFacture(id: number) {
    this.factureService.getFactureById(id).subscribe(
      res => {
        console.log('Facture :');
        this.facture = res;
        console.log(this.facture);
      });
    err => {
      console.log(err);
    }
  }

  // --------------------------- Facture Methods ------------------------------------

  addFacture() {
    this.factureService.addFacture(this.parameter).subscribe(
      res => {
        console.log('Facture created!');
        this.facture = res;
        this.dateFacture = this.facture.dateFacture + "";
        this.dateFacture = this.dateFacture.substring(0, 10)
        this.createDetailFacture();
        this.getDetailFactures(this.facture.idFacture);
        console.log(this.facture)
      });
    err => {
      console.log(err);
    }
  }
  deleteFacture() {
    this.factureService.deleteFactureById(this.facture.idFacture).subscribe(
      res => {
        console.log('Facture deleted!');
        this.router.navigate(['facturenonpayer'])

      });
    err => {
      console.log(err);
    }
  }
  saveFacture() {
    if (this.facture.client) {
      this.message = "";
      this.factureService.updateFacture(this.facture).subscribe(
        res => {
          console.log('Facture created!');
          this.facture = res;
          this.dateFacture = this.facture.dateFacture + "";
          this.dateFacture = this.dateFacture.substring(0, 10)
          this.router.navigate(['facturenonpayer'])
        });
      err => {
        console.log(err);
      }
    } else {
      this.message = "Choose a Client"
    }


  }
  payFacture() {
    if (this.facture.client) {
      this.message = "";
      this.facture.active = false;
      this.factureService.updateFacture(this.facture).subscribe(
        res => {
          console.log('Facture created!');
          this.facture = res;
          this.dateFacture = this.facture.dateFacture + "";
          this.dateFacture = this.dateFacture.substring(0, 10)
          this.router.navigate(['facturepayer'])
        });
      err => {
        console.log(err);
      }
    } else {
      this.message = "Select Client"
    }
  }
  // ------------------- DetailFacture STUFF -----------------------
  saveOrUpdateDetailFacture() {
    if (this.detailFacture.idDetailFacture) {
      this.updateDetailFacture();
    } else {
      this.addDetailFacture();
    }
  }
  addDetailFacture() {
    this.dfService.addDetailFacture(this.detailFacture).subscribe(
      res => {
        console.log('detail added :');
        this.detailFacture = res;
        console.log(this.detailFacture);
        this.detailFacture = new DetailFacture();
        this.createDetailFacture();
        this.getDetailFactures(this.facture.idFacture);
      });
    err => {
      console.log(err);
    }
  }
  updateDetailFacture() {
    this.dfService.updatedetailfacture(this.detailFacture).subscribe(
      res => {
        console.log('detail Updated :');
        this.detailFacture = res;
        console.log(this.detailFacture);
        this.createDetailFacture();
        this.getDetailFactures(this.facture.idFacture);
      });
    err => {
      console.log(err);
    }
  }
  cancelDetailFacture() {
    this.createDetailFacture();
  }
  deleteDetailFacture(id: number) {
    console.log(id);
    this.dfService.deleteDetailFactureById(id).subscribe(
      res => {
        console.log('detail deleted');
        this.createDetailFacture();
        this.getDetailFactures(this.facture.idFacture);
      });
    err => {
      console.log(err);
    }
  }
  setUpdateDetailFacture(df: DetailFacture) {
    this.detailFacture = df;
  }

  // les Fonctions de calcul
  calculerDetailFactureElements() {
    this.detailFacture.montantRemise = this.detailFacture.produit.prixUnitaire * this.detailFacture.qte * this.detailFacture.pourcentageRemise / 100;
    this.detailFacture.prixTotal = this.detailFacture.produit.prixUnitaire * this.detailFacture.qte - this.detailFacture.montantRemise;
  }
  edit() {
    console.log(this.detailFacture);
  }

}
