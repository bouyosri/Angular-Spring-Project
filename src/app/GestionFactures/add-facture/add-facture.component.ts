import { Component, OnInit, ViewChild, ElementRef, Input } from '@angular/core';
import { Client } from 'src/app/Models/client';
import { DetailFacture } from 'src/app/Models/detail-facture';
import { Facture } from 'src/app/Models/facture';
import { FactureService } from 'src/app/Services/facture.service';
import { DetailfactureService } from 'src/app/Services/detail-facture.service';
import { Produit } from 'src/app/Models/produit';
import { FormControl, FormGroup, Validators ,FormBuilder} from '@angular/forms';
import { Router } from '@angular/router';
import { ThrowStmt } from '@angular/compiler';
import jsPDF from 'jspdf';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import htmlToPdfmake from 'html-to-pdfmake';


@Component({
  selector: 'app-add-facture',
  templateUrl: './add-facture.component.html',
  styleUrls: ['./add-facture.component.css']
})

export class AddFactureComponent implements OnInit {


  //PDF genrate button click function
  facture: Facture = new Facture();
  message: string = "";
  selectedObject: any;
  dateFacture: string;
  
  
  prixTotal: number = 0;
  clients: Client[];
  produits: Produit[];
  details: DetailFacture[];
  client: any;



  idclient: any;
  idproduit: any;
  codeproduit : any;
  prixProduit:any;
  totaldetailProduit:any;
  produit:Produit;
  remiseProduit:any;
  qte:any;



  detailFacture: DetailFacture= {
    idDetailFacture: 0,
    qte: 0,
    prixTotal: 0,
    pourcentageRemise: 0,
    montantRemise: 0,
    facture: null,
    produit: null
  };


  form: FormGroup;
  detailform: FormGroup;

  constructor(private factureService: FactureService, private dfService: DetailfactureService, private router: Router) { }

  ngOnInit(): void {
    this.getClients();
    this.getProducts();
    /* this.createDetailFacture(); */

    
  
  }


  changeIdClient(value): void {

    console.log((value.target as HTMLInputElement).value);
    this.idclient=(value.target as HTMLInputElement).value;
    console.log(this.idclient);
  }


  getremise(value): void {

    
    
    let remise;
    remise=(value.target as HTMLInputElement).value;
    console.log(remise);
    console.log(this.remiseProduit);
    this.remiseProduit=remise;
    console.log("remise = "+this.remiseProduit);
    
  }

  calculatePrix(value): void {

    
    
    let qte;
    qte=(value.target as HTMLInputElement).value;
    this.qte=qte;
    console.log(qte);
    console.log(this.idproduit);
    this.prixProduit=this.idproduit;
    let totalProduit;
    let remise;
    remise = (this.remiseProduit*this.prixProduit*qte)/100;
    this.totaldetailProduit=(qte*this.prixProduit)-remise ;
    console.log("prix total = "+this.totaldetailProduit);
    
  }

  changeIdprod(value): void {

    this.idproduit=(value.target as HTMLInputElement).value;
    
    let currentName=(value.target as HTMLInputElement).value;
    let currentprix;
    let currentcode;
    let localP:Produit;
    this.produits.forEach(function (value) {
      
      if(value.libelle==currentName)
      {
        currentprix=value.prixUnitaire;
        currentcode=value.code;
        localP=value;

      }
      
      
      
      
    });
    this.idproduit=currentprix;
    this.codeproduit=currentcode;
    this.produit=localP;
    console.log("current Produit"+this.produit.libelle);
  }

  addFacture() {
    let currentName=this.idclient;
    let currentId;
    this.clients.forEach(function (value) {
      if(value.nom==currentName)
      {
        currentId=value.idClient;
        console.log("eee"+currentId);
      }
      
      
      
    });

    

        this.factureService.addFacture(currentId).subscribe(
          res => {
            console.log('Facture created!');
            this.facture = res;
            /*this.dateFacture = this.facture.dateFacture + "";
            this.dateFacture = this.dateFacture.substring(0, 10)
            this.createDetailFacture();
            this.getDetailFactures(this.facture.idFacture);*/
            console.log(this.facture)
          });
        err => {
          console.log(err);
        }
    
  }
  



  

  // --------------------------- Retrieving methods ----------------------------
  

 
  getClients() {
    this.factureService.getClients().subscribe(
      (data) => {
        this.clients = data;
        console.log(this.clients);
      });
  }
  getProducts() {
    this.factureService.getProducts().subscribe(

      (data) => {

        this.produits = data;
        console.log(this.produits);

      });
  }
  /*getProducts() {
    this.factureService.getProducts().subscribe(
      res => {
        this.produits = res;
        console.log(this.produits);
      });
    err => {
      console.log(err);
    }
  }*/

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

  /*submit(){
    console.log(this.form.value);
    this.factureService.addFacture(this.id, this.form.value).subscribe(res => {
         console.log('Post updated successfully!');
         this.router.navigateByUrl('post/index');
    })
  }*/

 
  deleteFacture() {
    this.factureService.deleteFactureById(this.facture.idFacture).subscribe(
      res => {
        console.log('Facture deleted!');
        this.router.navigate(['facturenonpayer']);
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
          this.router.navigate(['facturenonpayer']);
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
  addDetailFacture(){
    console.log("inside detail "+this.produit.libelle);
    
    this.detailFacture.produit=this.produit;
    this.detailFacture.pourcentageRemise=this.remiseProduit;
    this.detailFacture.qte=this.qte;
    console.log(this.detailFacture);
    this.dfService.addDetailFacture(this.detailFacture,this.facture.idFacture).subscribe(
      res => {
        
        
        console.log('Detail Facture created!');
        this.detailFacture = res;
        /*this.dateFacture = this.facture.dateFacture + "";
        this.dateFacture = this.dateFacture.substring(0, 10)
        this.createDetailFacture();
        this.getDetailFactures(this.facture.idFacture);
        console.log(this.facture)*/
      });
    err => {
      console.log(err);
    }
  }


  /*saveOrUpdateDetailFacture() {
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
  calculerFactureElements() {
    for (var value of this.details) {
      this.facture.montantTotal += value.prixTotal;
      this.facture.montantRemise += value.montantRemise;
      this.facture.montantFacture += value.montantRemise + value.prixTotal;
    }
    console.log(this.facture);
  }*/






}
