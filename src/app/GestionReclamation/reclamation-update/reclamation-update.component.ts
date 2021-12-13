import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Reclamation } from 'src/app/reclamation';
import { ReclamationService } from 'src/app/reclamation.service';


@Component({
  selector: 'app-reclamation-update',
  templateUrl: './reclamation-update.component.html',
  styleUrls: ['./reclamation-update.component.css'],
})
export class ReclamationUpdateComponent implements OnInit {
  idReclamation: number;
  reclamation: Reclamation = new Reclamation();
  constructor(
    private reclamationService: ReclamationService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.idReclamation = this.route.snapshot.params['idReclamation'];

    this.reclamationService.getReclamationById(this.idReclamation).subscribe(
      (data) => {
        this.reclamation = data;
      },
      (error) => console.log(error)
    );
  }
  onSubmit() {
    this.reclamationService
      .updateReclamation(this.idReclamation, this.reclamation)
      .subscribe(
        (data) => {
          this.getReclamationById();
        },
        (error) => console.log(error)
      );
  }
  getReclamationById() {
    this.router.navigate(['/reclamation-list']);
  }
}
