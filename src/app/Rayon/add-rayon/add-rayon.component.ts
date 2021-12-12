import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RayonService } from 'src/app/Services/rayon.service';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import { rayon } from 'src/app/Models/rayon';
@Component({
  selector: 'app-add-rayon',
  templateUrl: './add-rayon.component.html',
  styleUrls: ['./add-rayon.component.css']
})
export class AddRayonComponent implements OnInit {

  rayon: rayon = new rayon();
  submitted = false;
  constructor(private RayonService:RayonService,private router:Router) { }


  ngOnInit(): void {
     
  }
  addrayon() {
    this.submitted = true;
    this.RayonService.createRayon(this.rayon)
    .subscribe(data => console.log(data), error => console.log(error));
    this.rayon = new rayon();
 
   
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
