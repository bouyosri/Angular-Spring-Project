import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { detailProduit } from 'src/app/Models/detailProduit';
import { DetailProduitService } from 'src/app/Services/detail-produit.service';
import { ProduitService } from 'src/app/Services/produit.service';


@Component({
  selector: 'app-list-details',
  templateUrl: './list-details.component.html',
  styleUrls: ['./list-details.component.css']
})
export class ListDetailsComponent implements OnInit {

   listDetails : detailProduit[];
   detailProduit : detailProduit = new detailProduit();

  constructor(private detailProduitService: DetailProduitService,private router : Router) { }

  ngOnInit(): void {

    this.getAllDetails();
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

  getAllDetails(){
    this.detailProduitService.getAllDetails().subscribe(
      res=>{
        console.log('Rayons :');
        this.listDetails = res;
        console.log(this.listDetails)
      }
    );
    }

    deleteDetail(id:number){
      this.detailProduitService.deleteDetailById(id).subscribe(
        res=>{
          console.log('Detail deleted');
          
        }
      );
      }

    addDetail(){
      console.log(this.detailProduit);
      this.detailProduitService.addDetail(this.detailProduit).subscribe(
        res=>{
          
         // this.detailProduit = res;
         
        }
      )
}

}
