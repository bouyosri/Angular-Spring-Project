import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { fournisseur } from '../Models/fournisseur'; 
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
import { _ } from 'ajv';

@Injectable({
  providedIn: 'root'
})
export class FournisseurService {
  
 
   
  choixmenu : string  = 'A';
  list : fournisseur[];
  public dataForm:  FormGroup; 
  constructor(private http: HttpClient) { }
  private baseURL = "http://localhost:8005/SpringMVC";
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

  getfournisseurs(): Observable<fournisseur[]>{
    return this.http.get<fournisseur[]>(this.baseURL+"/fournissseur/retrieve-all-fournissseurs",this.httpOptions);
    }
     
      deletefour (fournisseur:fournisseur): Observable<fournisseur> {

        return this.http.delete<fournisseur>(this.baseURL+'/fournissseur/remove-fournissseur/'+fournisseur.idFournisseur);
      }
     /*getFournisseurbyid(fournisseur:fournisseur) : Observable<fournisseur>{
        return this.http.get<fournisseur>(this.baseURL+'/fournissseur/retrieve-fournissseur/'+fournisseur.idFournisseur);
      }*/

     getFournisseurbyid(idFournisseur: number): Observable<fournisseur> {
        return this.http.get<fournisseur>(this.baseURL + `/fournissseur/retrieve-fournissseur/${idFournisseur}`);
      }
    
        updateFournisseur (fournisseur:fournisseur): Observable<fournisseur> {
          return this.http.put<fournisseur>(this.baseURL+`/fournissseur/modify-fournissseur`,fournisseur, this.httpOptions);
          }
          createfournisseur(fournisseur: fournisseur): Observable<fournisseur> {
            return this.http.post<fournisseur>(this.baseURL+'/fournissseur/add-fournissseur',fournisseur);
          }

          populateForm(four){
            this.form.setValue(fournisseur);
          }
          
    
     
      
}


  