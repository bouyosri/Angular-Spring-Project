import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { fournisseur } from 'src/app/Models/fournisseur';
import { FournisseurService } from 'src/app/Services/fournisseur.service';

@Component({
  selector: 'app-update-fournisseur',
  templateUrl: './update-fournisseur.component.html',
  styleUrls: ['./update-fournisseur.component.css']
})
export class UpdateFournisseurComponent implements OnInit {
  idFournisseur: any;
  fournisseur: fournisseur = new fournisseur();
  parameter :any;  
  constructor(private fs:FournisseurService, private route :ActivatedRoute,private router:Router) { }

  ngOnInit(): void {

     this.route.params.subscribe(params => {
       this.parameter=params['id']
     }

    )
    this.getfournisseur(this.parameter);
      
   
  }
 onSubmit() {
    this.fournisseur.idFournisseur=this.parameter;
        console.log(this.fournisseur)
    this.fs.updateFournisseur( this.fournisseur).subscribe(
      (data) => {
        
        this.goToStockList();
      },
      (error) => console.log(error)
    );
  }
  getfournisseur(id :any){
     this.fs.getFournisseurbyid(id).subscribe(
       res=>{this.fournisseur=res
       }
     )
  }  goToStockList() {
    this.router.navigate(['/fournisseur']);
  }

}
