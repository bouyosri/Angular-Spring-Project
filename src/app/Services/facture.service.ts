import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../Models/client';
import { Facture } from '../Models/facture';
import { Produit } from '../Models/produit';

@Injectable({
  providedIn: 'root'
})
export class FactureService {

  allClients: Client[];
  private baseURL = "http://localhost:8084/SpringMVC";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(private http: HttpClient) { }

  getAllFactures(): Observable<Facture[]> {
    return this.http.get<Facture[]>(this.baseURL + '/factures/retrieve-all-Factures', this.httpOptions)
  }
  getActiveFactures(): Observable<Facture[]> {
    return this.http.get<Facture[]>(this.baseURL + '/factures/retrieve-all-Factures', this.httpOptions)
  }
  getNonActiveFactures(): Observable<Facture[]> {
    return this.http.get<Facture[]>(this.baseURL + '/factures/retrieve-all-Factures', this.httpOptions)
  }
  getFactureById(id: number): Observable<Facture> {
    return this.http.get<Facture>(this.baseURL + '/factures/retrieve-Facture/' + id, this.httpOptions)
  }

  addFacture(id: any): Observable<Facture> {
    return this.http.post<Facture>(this.baseURL + '/factures/add-Facture/'+ id, this.httpOptions)
  }
  editFacture(facture: Facture,id: any): Observable<Facture> {
    return this.http.post<Facture>(this.baseURL + '/factures/add-Facture/'+ id, facture, this.httpOptions)
  }
  updateFacture(facture: Facture): Observable<Facture> {
    return this.http.put<Facture>(this.baseURL + '/factures/modify-facture', facture, this.httpOptions)
  }

  deleteFactureById(id: number) {
    console.log(id)
    return this.http.delete(this.baseURL + '/factures/remove-Facture/' + id, this.httpOptions)
  }

  payFacture(id: number) {
    return this.http.post(this.baseURL + '/factures/pay-Facture/' + id, this.httpOptions)
  }

  getClients() : Observable<Client[]>{
    return this.http.get<Client[]>(this.baseURL + '/clients/retrieve-all-clients', this.httpOptions)
  }
  getProducts(): Observable<Produit[]> {
    return this.http.get<Produit[]>(this.baseURL + '/produits/retrieve-all-produits', this.httpOptions);
  }

}
