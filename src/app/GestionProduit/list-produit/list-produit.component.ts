import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from 'src/app/Models/produit';
import { ProduitService } from 'src/app/Services/produit.service';

import { Rayon } from 'src/app/Models/rayon';
import { detailProduit } from 'src/app/Models/detailProduit';
import { Stock } from 'src/app/Models/stock';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css']
})
export class ListProduitComponent implements OnInit {

  listProduits : Produit[];
  listRayons : Rayon[];
  listStocks : Stock[];

  produit : Produit = new Produit();

  
  
  listDetails : detailProduit[];
  constructor(private produitService: ProduitService,private router: Router) { }

  

  ngOnInit(): void {
    
   this.getAllProduits();
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
      
  }
  deleteProduit(id : number){
    this.produitService.deleteProduitById(id).subscribe(
      res=>{
        console.log('Rayons :');
        
      }
    );
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

  getAllProduits(){
    this.produitService.getAllProduits().subscribe(
      res=>{
        console.log('PRoduits :');
        this.listProduits = res;
        console.log(this.listProduits)
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

  addProduit(){
    
    console.log(this.produit.idDetail);
   this.produitService.addProduit(this.produit,this.produit.idRayon,this.produit.idStock,this.produit.idDetail).subscribe(
    res=>{
      console.log('Stocks :');
      this.produit = res;
      console.log(this.listStocks+"aa")
    }
  )
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

  
}
