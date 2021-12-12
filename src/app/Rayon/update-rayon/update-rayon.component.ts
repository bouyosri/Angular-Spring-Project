import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RayonService } from 'src/app/Services/rayon.service';
import { Router } from '@angular/router';
import { rayon } from 'src/app/Models/rayon';

@Component({
  selector: 'app-update-rayon',
  templateUrl: './update-rayon.component.html',
  styleUrls: ['./update-rayon.component.css']
})
export class UpdateRayonComponent implements OnInit {
  parameter:any;
  idRayon: any;
  rayon: rayon = new rayon();
  constructor(private rs:RayonService, private route :ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.parameter=params['id']
    }

   )
   this.getrayon(this.parameter);
     
  }
  onSubmit() {
    this.rayon.idRayon=this.parameter;
        console.log(this.rayon)
    this.rs.updateRayon( this.rayon).subscribe(
      (data) => {
        
        this.goToStockList();
      },
      (error) => console.log(error)
    );
  }
  getrayon(id :any){
     this.rs.getRayonbyid(id).subscribe(
       res=>{this.rayon=res
       }
     )
  }  goToStockList() {
    this.router.navigate(['/fournisseur']);
  }

}
