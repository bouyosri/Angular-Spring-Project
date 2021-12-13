import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Reclamation } from './reclamation';

@Injectable({
  providedIn: 'root',
})
export class ReclamationService {
  constructor(private http: HttpClient) {}
  url: string = 'http://localhost:8084/SpringMVC/reclamations';
  getAllReclamations(): Observable<any> {
    return this.http.get<any>(this.url + `/retrieve-all-reclamations`);
  }
  /*addStocks(body: any): Observable<any> {
    return this.http.post<any>(this.url + `/add-stock`, body);
  }*/
  createReclamation(reclamation: Reclamation): Observable<Object> {
    return this.http.post(this.url + `/add-reclamation`, reclamation);
  }
  deleteReclamation(idClient: number): Observable<Object> {
    return this.http.delete(this.url + `/remove-reclamation/${idClient}`);
  }
  getClient(idClient: any): Observable<any> {
    return of({
      idClient: 1,
    });
  }
  updateReclamation(
    idReclamation: number,
    reclamation: Reclamation
  ): Observable<any> {
    return this.http.put(
      this.url + `/modify-reclamation/${idReclamation}`,
      reclamation
    );
  }
  getReclamationById(idClient: number): Observable<Reclamation> {
    return this.http.get<Reclamation>(
      this.url + `/retrieve-reclamation/${idClient}`
    );
  }
}
