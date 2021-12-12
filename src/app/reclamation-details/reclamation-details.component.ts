import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Reclamation } from '../reclamation';
import { ReclamationService } from '../reclamation.service';

@Component({
  selector: 'app-reclamation-details',
  templateUrl: './reclamation-details.component.html',
  styleUrls: ['./reclamation-details.component.css'],
})
export class ReclamationDetailsComponent implements OnInit {
  id: number;
  reclamation: Reclamation;
  constructor(
    private route: ActivatedRoute,
    private reclamationService: ReclamationService
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.reclamation = new Reclamation();
    this.reclamationService.getReclamationById(this.id).subscribe((data) => {
      this.reclamation = data;
    });
  }
}
