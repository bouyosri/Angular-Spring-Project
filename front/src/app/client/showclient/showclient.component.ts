import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/Models/client';
import { ClientServiceService } from 'src/app/Services/client-service.service';
import { ActivatedRoute, Router } from '@angular/router';



@Component({
  selector: 'app-showclient',
  templateUrl: './showclient.component.html',
  styleUrls: ['./showclient.component.css']
})
export class ShowclientComponent implements OnInit {

  ListClient: Client[];
  client: Client= new Client();
  id: number;
  constructor(private clientService:ClientServiceService, private router: Router) { }

  ngOnInit(): void {
    this.retrieveClients()
    
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


  retrieveClients() {
    this.clientService.getAllclients().subscribe(
      res => {
        console.log('Clients :');
        this.ListClient= res;
      });
    err => {
      console.log(err);
    }
  }

  AddClient(){

    this.clientService.SaveClient(this.client).subscribe(
      res => {
        this.client= res;
      });
    err => {
      console.log(err);
    }

    location.reload();

  }
  DeleteClient(id:number){
    this.clientService.deleteClient(id).subscribe(
      res => {
        this.client= res;
        
      });
    err => {
      console.log(err);
    } 
    location.reload();

  }

}
