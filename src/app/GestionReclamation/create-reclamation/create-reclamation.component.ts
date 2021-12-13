import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Reclamation } from 'src/app/reclamation';
import { ReclamationService } from 'src/app/reclamation.service';


@Component({
  selector: 'app-create-reclamation',
  templateUrl: './create-reclamation.component.html',
  styleUrls: ['./create-reclamation.component.css'],
})
export class CreateReclamationComponent implements OnInit {
  idClient: number;
  reclamation: Reclamation = new Reclamation();

  constructor(
    private reclamationService: ReclamationService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.reclamation.clientReclamation = { idClient: null };
  }
  saveReclamation() {
    this.reclamationService.createReclamation(this.reclamation).subscribe(
      (data) => {
        console.log(data);
        this.goToReclamationList();
      },
      (error) => console.log(error)
    );
  }

  goToReclamationList() {
    this.router.navigate(['/reclamation-list']);
  }

  onSubmit() {
    console.log(this.reclamation);
    this.saveReclamation();
  }
}
