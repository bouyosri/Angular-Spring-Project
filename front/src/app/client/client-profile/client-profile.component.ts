import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/Models/client';
import { ClientServiceService } from 'src/app/Services/client-service.service';



@Component({
  selector: 'app-client-profile',
  templateUrl: './client-profile.component.html',
  styleUrls: ['./client-profile.component.css']
})
export class ClientProfileComponent implements OnInit {
  idC: number ;
  client: Client ;
  constructor( private route: ActivatedRoute,private clientService:ClientServiceService) { }
  nbFacture: number ;
  totalFacture: number ;
  PCA: number ;
  subject: string;
  content: string ;
  email: string ;

  ngOnInit(): void {
    
    this.route.params.subscribe(params => {
      this.idC = params['id'];
      
      this.client=this.getClient();
      this.nbFacture=this.getNbFacture();
      this.totalFacture=this.getTotalFacture();
      this.PCA= this.getCAT();
      
    });
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
    

      var btnPopup1 = document.getElementById('btnPopup1');
    var overlay1 = document.getElementById('overlay1');
    btnPopup1.addEventListener('click',openMoadl1);
    function openMoadl1() {
    overlay1.style.display='block';
    }

    var btnClose1 = document.getElementById('btnClose1');
    btnClose1.addEventListener('click',closeModal1);
    function closeModal1() {
      overlay1.style.display='none';
      }
    
    
  }

  updateClient(){

    this.clientService.SaveClient(this.client).subscribe(
      res => {
        this.client= res;
      });
    err => {
      console.log(err);
    }

    location.reload();

  }
  sendMail(){
    this.clientService.sendMail(this.content,this.subject,this.client.email).subscribe(
      res => {
        
      });
    err => {
      console.log(err);
    }

    location.reload();
    
  }

  getClient() {
    this.clientService.getClientById(this.idC).subscribe(
      res => {
        console.log('Clients :');
        this.client= res;
        console.log(this.client);
      });
    err => {
      console.log(err);
    }
    return this.client;
  }

  getNbFacture(){
    this.clientService.getTotalfacturenbre(this.idC).subscribe(
      res => {
        console.log('Clients :');
        this.nbFacture= res;
        console.log(this.nbFacture);
      
      });
    err => {
      console.log(err);
    }
    return this.nbFacture;

  }

  getTotalFacture(){
    this.clientService.getTotalfacture(this.idC).subscribe(
      res => {
        console.log('Clients :');
        this.totalFacture= res;
        console.log(this.nbFacture);
      
      });
    err => {
      console.log(err);
    }
    return this.totalFacture;

  }

  getCAT(){
    this.clientService.getCAT().subscribe(
      res => {
        this.PCA= this.getTotalFacture()/res;
      
      });
    err => {
      console.log(err);
    }
    return this.PCA;

  }

}
