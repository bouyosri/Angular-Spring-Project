import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ChartComponent } from "ng-apexcharts";

import {
  ApexNonAxisChartSeries,
  ApexResponsive,
  ApexChart
} from "ng-apexcharts";
import { detailProduit } from 'src/app/Models/detailProduit';
import { Produit } from 'src/app/Models/produit';
import { Rayon } from 'src/app/Models/rayon';
import { Stock } from 'src/app/Models/stock';
import { ProduitService } from 'src/app/Services/produit.service';
import { ListProduitComponent } from '../list-produit/list-produit.component';

export type ChartOptions = {
  series: ApexNonAxisChartSeries;
  chart: ApexChart;
  responsive: ApexResponsive[];
  labels: any;
};  


@Component({
  selector: 'app-single-produit',
  templateUrl: './single-produit.component.html',
  styleUrls: ['./single-produit.component.css']
})
export class SingleProduitComponent implements OnInit {
  @ViewChild("chart", { static: false }) chart: ChartComponent;
  public chartOptions: Partial<ChartOptions>;

  produit : Produit;
  idC:number;
  chartop : number[];
  stock : Stock;
  chartlib : string[];

  produits : Produit[];
  p : Produit;
  valuee:string ;
  i : number;

  listRayons : Rayon[];
  listStocks : Stock[];
  
  listDetails : detailProduit[];
  


  constructor(private route: ActivatedRoute, private produitService:ProduitService   ) {
    
    
   }

  ngOnInit(): void {
    this.getAllRayons();
  this.getAllDetails();
  this.getAllStocks();
  var btnPopup = document.getElementById('btnPopup');
  var overlay = document.getElementById('overlay');
  btnPopup.addEventListener('click',openMoadl);
  function openMoadl() {
  overlay.style.display='block';
  }

  var btnClose = document.getElementById('btnClose');
  btnClose.addEventListener('click',closeModal);
  function closeModal() {
    overlay.style.display='none';
    }
       
    this.route.params.subscribe(params => {
      this.idC = params['id'];
      this.stock=this.getStock();
    this.chartop=[]
    this.chartlib=[]
      

      this.produit=this.getProduit();
      console.log(this.produit);
     // this.chartop=[5,5,5,5,5];
      this.showstat(50);

    });


      
      
   

  }

  getAllStocks(){
    this.produitService.getAllStocks().subscribe(
      res=>{
        console.log('Stocks :');
        this.listStocks = res;
        console.log(this.listStocks+"aa")
      }
    )
  }

  getAllDetails(){
    this.produitService.getAllDetails().subscribe(
      res=>{
        console.log('details :');
        this.listDetails = res;
        console.log(this.listDetails)
      }
    )
  }


  getAllRayons(){
    console.log("TESTING");
   this.produitService.getAllRayons().subscribe(
    res=>{
      console.log('Rayons :');
      this.listRayons = res;
      console.log(this.listRayons)
    }
  );
  }

 

  getStock(){
    this.produitService.getStock(this.idC).subscribe(
      res => {
        this.stock= res;
        
      });
    err => {
      console.log(err);
    }
    return this.stock;
  

  }

  
 
  getcharop(){
    this.produitService.getProdByStock(this.produit.stockproduit.idStock).subscribe(
      res=>{
        this.produits = res;
      }
      
    )
  
   return this.produits ;
  }

  update(){
     this.valuee=(this.produit.stockproduit.qte).toString();
    //this.chartop=[Number(this.valuee),Number(this.valuee),1,1]
       this.produits=this.getcharop();
     //  console.log(this.produits);
       
       //console.log(this.chartOptions.series);
  //console.log(this.produits);
this.chartop=[];
this.chartlib=[];
  for (var i = 0; i < this.produits.length; i++){
   //console.log(this.produits[i]);
   this.chartop.push(this.produits[i].stockproduit.qte);
   this.chartlib.push(this.produits[i].libelle);
  }
  console.log(this.chartop);
    // this.produits.forEach(element => console.log(element));

   // console.log(typeof(this.produits[this.i].stockproduit.qte));
    //this.chartop[this.i]=this.produits[this.i].stockproduit.qte; 


    this.chartOptions.series=this.chartop;
    this.chartOptions.labels=this.chartlib;
  }
  
  
showstat(s:number){
 
  this.chartOptions = {
    series: [],
    chart: {
      width: 380,
      type: "pie"
    },
    labels: [],
    responsive: [
      {
        breakpoint: 480,
        options: {
          chart: {
            width: 200
          },
          legend: {
            position: "bottom"
          }
        }
      }
    ]
  };
  
}



addProduit(){
    
  console.log(this.produit.idDetail);
 this.produitService.addProduit(this.produit,this.produit.idRayon,this.produit.idStock,this.produit.idDetail).subscribe(
  res=>{
    console.log('Stocks :');
    this.produit = res;
  }
)
}



  
  getProduit() {
    this.produitService.getProduit(this.idC).subscribe(
      res => {
        this.produit= res;
        
      });
    err => {
      console.log(err);
    }
   // console.log(this.produit);
    return this.produit;
  }

  item = [{
    'name': 'Agatha Harkness',
    'played by': 'Kathryn Hahn',
    'Fictional universe': 'Marvel Universe',
    'Creator': 'Stan Lee'
  }]

  qrInfo = JSON.stringify(this.item);
  

  
}
