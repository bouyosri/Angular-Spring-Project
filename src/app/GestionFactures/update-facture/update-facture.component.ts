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


  //PDF genrate button click function
  facture: Facture = new Facture();
  detailFacturemiloul: DetailFacture = new DetailFacture();
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
  parameter:any;



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

  constructor(private factureService: FactureService, private route: ActivatedRoute, private dfService: DetailfactureService, private router: Router) { }

  ngOnInit(): void {
    
    this.getClients();
    this.getProducts();
    /* this.createDetailFacture(); */
      this.route.params.subscribe(params => {
        this.parameter = params['id'];
      })

    this.getFacture(this.parameter);
  
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
    remise = (this.remiseProduit*this.prixProduit*this.qte)/100;
    this.totaldetailProduit=(this.qte*this.prixProduit)-remise ;
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

  editFacture() {
    let currentName=this.idclient;
    let currentId;
    this.clients.forEach(function (value) {
      if(value.nom==currentName)
      {
        currentId=value.idClient;
        console.log("eee"+currentId);
      }
      
      
      
    });

    

        this.factureService.editFacture(this.facture,currentId).subscribe(
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
        this.getFacture(this.parameter);
    
  }
  



  

  // --------------------------- Retrieving methods ----------------------------
  

 
  getClients() {
    this.factureService.getClients().subscribe(
      (data) => {
        this.clients = data;
      });
  }
  getProducts() {
    this.factureService.getProducts().subscribe(

      (data) => {

        this.produits = data;

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

  getDetailFactures(id: number) : DetailFacture {
    let detailfacture;
    this.dfService.getDetailFactureByFactureId(id).subscribe(
      
      res => {
        console.log('details :');
        this.details = res;
        detailfacture= res;
        console.log(this.details);
      });
    err => {
      console.log(err);
    }
    return detailfacture;
  } 
  getFacture(id: number) {
    this.factureService.getFactureById(id).subscribe(
      res => {
        this.facture = res;
        this.details=this.facture.detailFactures;
        console.log(this.facture);
        console.log(this.details);
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
    this.getFacture(this.parameter);
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
  /*payFacture() {
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
  }*/
  // ------------------- DetailFacture STUFF -----------------------
  addDetailFacture(){
    console.log("inside detail "+this.produit.libelle);
    
    this.detailFacture.idDetailFacture=0;
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
    setTimeout( ()=>{
      this.getFacture(this.parameter);
      },  100)
  }
  payFacture(id:any){
    
    this.factureService.payFacture(this.parameter);
    this.facture.active=false;
    

    console.log(this.facture);
    this.factureService.editFacture(this.facture,this.facture.client.idClient).subscribe(
      res => {
        console.log(' Facture paid!');
        this.facture = res;
        /*this.dateFacture = this.facture.dateFacture + "";
        this.dateFacture = this.dateFacture.substring(0, 10)
        this.createDetailFacture();
        this.getDetailFactures(this.facture.idFacture);
        console.log(this.facture)*/
      }
      
      );
      err => {
        console.log(err);
      };

    
    setTimeout( ()=>{
      this.getFacture(this.parameter);
      },  100)


  }


  editDetailFacture(id:any){
    console.log("inside detail "+this.produit.libelle);
    this.detailFacture.idDetailFacture=id;
    console.log('its id'+this.detailFacture.idDetailFacture);
    
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
    setTimeout( ()=>{
      this.getFacture(this.parameter);
      },  100)
    
  }


  deleteDetailFacture(id: number) {
    console.log(id);
    this.dfService.deleteDetailFactureById(id).subscribe(
      res => {
        console.log('detail deleted');
        this.getDetailFactures(this.facture.idFacture);
        this.getFacture(this.parameter);
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
