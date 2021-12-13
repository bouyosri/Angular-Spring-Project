import { Injectable } from '@angular/core';
import { Client } from '../Models/client';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientServiceService {
 
  private baseURL = "http://localhost:8013/SpringMVC";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  getAllclients(): Observable<Client[]> {
    return this.http.get<Client[]>(this.baseURL + '/client/retrieve-all-clients', this.httpOptions)
  }

  getClientById(id:number): Observable<Client> {
    return this.http.get<Client>(this.baseURL + '/client/retrieve-client/'+id, this.httpOptions)
  }

  getTotalfacturenbre(id:number): Observable<number> {
    return this.http.get<number>(this.baseURL + '/client/nbfacture/'+id, this.httpOptions)
  }

  getTotalfacture(id:number): Observable<number> {
    return this.http.get<number>(this.baseURL + '/client/totalfactures/'+id, this.httpOptions)
  }

  getCAT(): Observable<number> {
    return this.http.get<number>(this.baseURL + '/client/CAT/', this.httpOptions)
  }


  SaveClient(client:Client): Observable<Client> {
    const body=JSON.stringify(client);
    return this.http.post<Client>(this.baseURL + '/client/add-client',body, this.httpOptions)
  }

  sendMail(content:string,subject:string,email:string): Observable<Client> {
    console.log("this is the add"+email);
      return this.http.get<Client>(this.baseURL + '/email/mailtest/'+content+'/'+subject+'/'+email, this.httpOptions);
     
  }


  deleteClient(id:number): Observable<Client> {
    return this.http.delete<Client>(this.baseURL + '/client/remove-client/'+id, this.httpOptions)
  }


  
}
