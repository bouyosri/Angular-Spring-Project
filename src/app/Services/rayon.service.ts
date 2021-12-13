import { Injectable } from '@angular/core';
 import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { rayon } from '../Models/rayon';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
import { _ } from 'ajv';


@Injectable({
  providedIn: 'root'
})
export class RayonService {
  choixmenu : string  = 'A';
  list : rayon[];
  public dataForm:  FormGroup;
  
  
 
   
 
  constructor(private http: HttpClient) { }
  private baseURL = "http://localhost:8084/SpringMVC";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
    form: FormGroup = new FormGroup({
      $idFournisseur: new FormControl(null),
      code: new FormControl('',[Validators.required, Validators.minLength(8)]),
      libelle: new FormControl(''),
  
      
    });
    
  initializeFormGroup() {
    this.form.setValue({
      $key: null,
      fullName: '',
      email: '',
      
    });
  }
 
 /*  getData(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
 
  addfournisseur (Fournisseur: fournisseur): Observable<fournisseur> {
    return this.http.post<fournisseur>(this.baseUrl, Fournisseur, this.httpOptions);}
  
  updatefournisseur (id: number, fournisseur: fournisseur): Observable<fournisseur> {
    return this.http.put<fournisseur>(this.baseUrl+'/'+ id, fournisseur, this.httpOptions);
    }
 
    deletefournisseurt (fournisseur: fournisseur): Observable<fournisseur> {
      const url=this.baseUrl+'/'+ fournisseur.idFournisseur;
      return this.http.delete<fo *//* urnisseur>(url); */
      //}

  getrayons(): Observable<rayon[]>{
    return this.http.get<rayon[]>(this.baseURL+"/rayon/retrieve-all-rayons",this.httpOptions);
    }
     
      deleteRayon (rayon:rayon): Observable<rayon> {

        return this.http.delete<rayon>(this.baseURL+'/rayon/remove-rayon/'+rayon.idRayon);
        
      }
      getRayonbyid(idRayon: number) : Observable<rayon>{
        return this.http.get<rayon>(this.baseURL+`/rayon/retrieve-rayon/${idRayon}`);
      }
    
        updateRayon (rayon:rayon): Observable<rayon> {
          return this.http.put<rayon>(this.baseURL+"/rayon/modify-rayon",rayon, this.httpOptions);
          }
          createRayon(rayon: rayon): Observable<rayon> {
            return this.http.post<rayon>(this.baseURL+'/rayon/add-rayon',rayon);
          }

          populateForm(four){
            this.form.setValue(rayon);
          }
          
    
     
      
}


  