import { Client } from "./client";

export class Facture {
    idFacture : number ;
    montantRemise : number ;
    montantFacture : number ;
    montantTotal: number;
    dateFacture : Date ; 
    active : boolean;
    client : Client;
}
