import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { detailProduit } from '../Models/detailProduit';

@Injectable({
  providedIn: 'root'
})
export class DetailProduitService {

  listDetails: detailProduit[];
  private baseURL = "http://localhost:8013/SpringMVC";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(private http: HttpClient) { }

  getAllDetails(): Observable<detailProduit[]> {
    return this.http.get<detailProduit[]>(this.baseURL + '/detail/retrieve-all-details', this.httpOptions)
  } 
  
  deleteDetailById(id: number) {
    console.log("tessst delete detail");
    console.log(id);
    return this.http.delete(this.baseURL + '/detail/delete-detail/' + id, this.httpOptions)
  }

  addDetail(detailProduit: detailProduit): Observable<detailProduit> {

    const data=JSON.stringify(detailProduit);
   

    return this.http.post<detailProduit>(this.baseURL + '/detail/add-detail-produit',data, this.httpOptions)
  }

}
