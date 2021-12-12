import { Component, OnInit } from '@angular/core';
 import { Router } from '@angular/router';
 import { FournisseurService } from 'src/app/Services/fournisseur.service';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import { fournisseur } from 'src/app/Models/fournisseur';
  
 

@Component({
  selector: 'app-add-fournisseur',
  templateUrl: './add-fournisseur.component.html',
  styleUrls: ['./add-fournisseur.component.css']
})
export class AddFournisseurComponent implements OnInit {
  
  fournisseur: fournisseur = new fournisseur();
  submitted = false;
  constructor(private FournisseurService:FournisseurService,private router:Router) { }


  ngOnInit(): void {
     
  }
  addfournisseur() {
    this.submitted = true;
    this.FournisseurService.createfournisseur(this.fournisseur)
    .subscribe(data => console.log(data), error => console.log(error));
    this.fournisseur = new fournisseur();
 
   
  }



   /* onSubmit() {
      if (this.service.form.valid) {
        if (!this.service.form.get('$key').value)
          this.service.insertEmployee(this.service.form.value);
        else
        this.service.updateEmployee(this.service.form.value);
        this.service.form.reset();
        this.service.initializeFormGroup();
        this.notificationService.success(':: Submitted successfully');
        this.onClose();
      }
    
  }*/
  

     


}
