import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../Models/client';
import { detailProduit } from '../Models/detailProduit';
import { Produit } from '../Models/produit';
import { Rayon } from '../Models/rayon';
import { Stock } from '../Models/stock';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  allClients: Client[];
  private baseURL = "http://localhost:8013/SpringMVC";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(private http: HttpClient) { }

  getAllRayons(): Observable<Rayon[]> {
    return this.http.get<Rayon[]>(this.baseURL + '/rayon/retrieve-all-rayons', this.httpOptions)
  } 

  getProduitById(id: number): Observable<Produit> {
    return this.http.get<Produit>(this.baseURL + '/produit/retrieve-Facture/' + id, this.httpOptions)
  }

  addProduit(Produit: Produit,ids : number, idr : number,idd : number): Observable<Produit> {

    const data=JSON.stringify(Produit);
    console.log("data is"+Produit);
    return this.http.post<Produit>(this.baseURL + '/produit/add-produit/'+idr+"/"+ids+"/"+idd,data, this.httpOptions)
  }

  updateFacture(Produit: Produit): Observable<Produit> {
    return this.http.put<Produit>(this.baseURL + '/produit/modify-facture', Produit, this.httpOptions)
  }

  deleteProduitById(id: number) {
    console.log("tessstZZZZ");
    console.log(id);
    return this.http.delete(this.baseURL + '/produit/delete-produit/' + id, this.httpOptions)
  }

  

  getAllProduits(): Observable<Produit[]> {
    return this.http.get<Produit[]>(this.baseURL + '/produit/retrieve-all-produits', this.httpOptions);
  }

  getAllDetails(): Observable<detailProduit[]> {
    return this.http.get<detailProduit[]>(this.baseURL + '/detail/retrieve-all-details', this.httpOptions);
  }

  getAllStocks(): Observable<Stock[]> {
    return this.http.get<Stock[]>(this.baseURL + '/stock/retrieve-all-stocks', this.httpOptions);
  }

  getProduit(id: number){
    return this.http.get<Produit>(this.baseURL + '/produit/get-produit/' + id, this.httpOptions);
  }

  getStock(id: number){
    return this.http.get<Stock>(this.baseURL + '/stock/get-stock/' + id, this.httpOptions);
  }

  getProdByStock(id:number):Observable<Produit[]>{
    return this.http.get<Produit[]>(this.baseURL + '/produit/a/' + id, this.httpOptions);

  }

}
