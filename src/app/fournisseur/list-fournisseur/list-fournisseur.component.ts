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
  listFournisseur: fournisseur;
  searchKey:string;
  idFournisseur:any;
  sizefournisseur:any;
  
  fournisseur:fournisseur[]=[];
  filters={
    keyword:''
  }
  fournisseurList: any;
  libelleFournisseur:any;
  constructor(private fs:FournisseurService,private Router: Router,private uss: ActivatedRoute) { }

 /* listData: MatTableDataSource<any>;*/
  ngOnInit(): void {
    this.selectData();
    let i: number = 2;

while (i < 4) {
  setTimeout(()=>{
    this.sizefournisseurcron();
    console.log(this.sizefournisseur)
  },500)
    i++;
}
    
    
     
  }
  selectData() {
     
      this.fs.getfournisseurs().subscribe(res=>{this.list=res});
    }
      
  
      
      

  deleteFournisseur(f:fournisseur) {
        this.fs.deletefour(f).subscribe(
          res => {
            console.log(res);
           // this.listFournisseur = this.fs.getfournisseurs();
      
           },
          error => console.log(error));
         
          
        ;
        setTimeout(()=>{
          this.selectData();
        },500
        )
       
          
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
      Search() {
        if (this.libelleFournisseur != '') {
          this.fournisseurList = this.fournisseurList.filter((res: any) => {
            return res.libelleStock
              .toLocaleLowerCase()
              .match(this.libelleFournisseur.toLocaleLowerCase());
          });
        } else if (this.libelleFournisseur == '') {
          this.ngOnInit();
        }
      }

      exportToPDF() {
        this.fs.exportPDF().subscribe((responseMessage: any) => {
          const file = new Blob([responseMessage], {
            type: 'application/pdf',
          });
          const fileURL = URL.createObjectURL(file);
          window.open(fileURL);
        });
      }
      recherche(idFournisseur: number){
       this.fournisseurList= this.fs.getFournisseurbyidlist(idFournisseur).subscribe(res => {
          
          this.fournisseurList = res;
          setTimeout(()=>{
            this.list=[];
            this.list[0]=this.fournisseurList;
            console.log( res);
          },500)
          
          
          

    
         },
        error => console.log(error));
       
        
      ;}

      sizefournisseurcron(){
        
        this.sizefournisseur=this.fs.getsize().subscribe(res => {
          
          this.sizefournisseur = res;
          
          
          
          

    
         },
        error => console.log(error));
       
        
      ;}
;

      }


      


     

  
  




