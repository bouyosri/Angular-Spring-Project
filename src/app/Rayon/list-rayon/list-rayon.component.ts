import { Component, OnInit } from '@angular/core';
import { rayon } from 'src/app/Models/rayon';
import { Observable } from "rxjs";
import { RayonService } from 'src/app/Services/rayon.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-list-rayon',
  templateUrl: './list-rayon.component.html',
  styleUrls: ['./list-rayon.component.css']
})
export class ListRayonComponent implements OnInit {

  list: rayon[];
  listRayon: Observable<rayon[]>;
  searchKey:string;
  
  rayon:rayon[]=[];
  filters={
    keyword:''
  }
  constructor(private rs:RayonService,private Router: Router,private uss: ActivatedRoute) { }

 /* listData: MatTableDataSource<any>;*/
  ngOnInit(): void {
    this.selectData();
     
  }
  selectData() {
     
      this.rs.getrayons().subscribe(
        res=>{this.list=res});
      
        err=>{console.log(err)}
      }
      
  
      
      

      deleteRayon(r:rayon) {
        this.rs.deleteRayon(r).subscribe(
          res => {
            console.log(res);
           // this.listFournisseur = this.fs.getfournisseurs();

           },
          error => console.log(error));
          this.Router.navigate(['/fournisseur']) 
          
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

      updaterayon(id: number) {
        this.Router.navigate(['/rayon/update', id])
      }

      toadd(){
        this.Router.navigate(['/rayon/add'])
      }
    


     }
