import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reclamation } from 'src/app/reclamation';
import { ReclamationService } from 'src/app/reclamation.service';


@Component({
  selector: 'app-reclamation-list',
  templateUrl: './reclamation-list.component.html',
  styleUrls: ['./reclamation-list.component.css'],
})
export class ReclamationListComponent implements OnInit {
  reclamations: Reclamation[];
  constructor(
    private reclamationService: ReclamationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    setTimeout( ()=>{
      this.getAllReclamation(); 
      },  100)
    
  }

  private getAllReclamation() {
    this.reclamationService.getAllReclamations().subscribe((data) => {
      this.reclamations = data;
      console.log(data);
    });
  }

  getReclamationById(id: number) {
    this.router.navigate(['reclamation-details', id]);
  }

  updateReclamation(id: number) {
    this.router.navigate(['reclamation-update', id]);
  }

  deleteReclamation(id: number) {
    this.reclamationService.deleteReclamation(id).subscribe((data) => {
      console.log(data);
      this.getAllReclamation();
    });
  }
}
