import { Component, OnInit } from '@angular/core';
import { fournisseur } from 'src/app/Models/fournisseur'; 
import { Observable } from "rxjs";
import { ActivatedRoute, Router } from '@angular/router';
 import { FournisseurService } from 'src/app/Services/fournisseur.service'; 
 import { MatDialog } from  '@angular/material/dialog';





  
import { AddFournisseurComponent } from '../add-fournisseur/add-fournisseur.component';
import { UpdateFournisseurComponent } from '../update-fournisseur/update-fournisseur.component';
 

@Component({
  selector: 'app-list-fournisseur',
  templateUrl: './list-fournisseur.component.html',
  styleUrls: ['./list-fournisseur.component.css']
})
export class ListFournisseurComponent implements OnInit {
  list: fournisseur[];
  listFournisseur: Observable<fournisseur[]>;
  searchKey:string;
  
  fournisseur:fournisseur[]=[];
  filters={
    keyword:''
  }
  constructor(private fs:FournisseurService,private Router: Router,private uss: ActivatedRoute) { }

 /* listData: MatTableDataSource<any>;*/
  ngOnInit(): void {
    this.selectData();
     
  }
  selectData() {
     
      this.fs.getfournisseurs().subscribe(res=>{this.list=res});}
      
  
      
      

      deleteFournisseur(f:fournisseur) {
        this.fs.deletefour(f).subscribe(
          res => {
            console.log(res);
           // this.listFournisseur = this.fs.getfournisseurs();
           this.tolist();
           },
          error => console.log(error));
         
          
        ;
       
          
      }
      

     /* onCreate() {
        this.service.initializeFormGroup();
        const dialogConfig = new MatDialogConfig();
        dialogConfig.disableClose = true;
        dialogConfig.autoFocus = true;
        dialogConfig.width = "60%";
        this.dialog.open(EmployeeComponent,dialogConfig);
      }
    */
     /* onEdit(row){
        this.fs.populateForm(row);
        const dialogConfig = new MatDialogConfig();
        dialogConfig.disableClose = true;
        dialogConfig.autoFocus = true;
        dialogConfig.width = "60%";
        this.dialog.open(EmployeeComponent,dialogConfig);
      }*/
    
      /*openDialog(){
        this.dialogRef.open(AddFournisseurComponent);
      }

      openDialog2(){
        this.dialogRef.open(UpdateFournisseurComponent);
      }*/

     /* onSearchClear() {
        this.searchKey = "";
        this.applyFilter();
      }*/
    
      /*applyFilter() {
        this.listData.filter = this.searchKey.trim().toLowerCase();
      }*/

      updateFournisseur(id: number) {
        this.Router.navigate(['/fournisseur/update', id])
      }

      toadd(){
        this.Router.navigate(['/fournisseur/add'])
      }

      tolist(){
        this.Router.navigate(['/fournisseur'])

      }
    


     }

  
  




