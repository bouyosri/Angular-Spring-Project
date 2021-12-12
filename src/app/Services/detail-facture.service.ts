import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DetailFacture } from '../Models/detail-facture';

@Injectable({
  providedIn: 'root'
})

export class DetailfactureService {
  private baseURL = "http://localhost:8084/SpringMVC";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(private http : HttpClient) { }

  getAllDetailFactures(): Observable<DetailFacture[]>{
    return this.http.get<DetailFacture[]>(this.baseURL+'/detailfacture/retrieve-all-detailfactures',this.httpOptions)
  }
  getDetailFactureById(id:number): Observable<DetailFacture>{
    return this.http.get<DetailFacture>(this.baseURL+'/detailfacture/retrieve-detailfacture/'+id,this.httpOptions)
  }

  addDetailFacture(detailfacture : DetailFacture,id:any): Observable<DetailFacture>{
    return this.http.post<DetailFacture>(this.baseURL+'/detailfactures/add-Detail-Facture/'+id,detailfacture,this.httpOptions)
  }
  updatedetailfacture(detailfacture : DetailFacture): Observable<DetailFacture>{
    return this.http.put<DetailFacture>(this.baseURL+'/detailfacture/modify-detailfacture',detailfacture,this.httpOptions)
  }

  deleteDetailFactureById(id:number){
    return this.http.delete(this.baseURL+'/detailfactures/remove-Detail-Facture/'+id,this.httpOptions)
  }
  
  getDetailFactureByFactureId(id:number): Observable<DetailFacture[]>{
    return this.http.get<DetailFacture[]>(this.baseURL+'/detailfactures/retreive-Detail-Facture/'+id,this.httpOptions)
  }
  


}
