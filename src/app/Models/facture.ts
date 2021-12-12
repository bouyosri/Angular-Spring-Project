import { Client } from "./client";
import { DetailFacture } from "./detail-facture";

export class Facture {
    idFacture : number ;
    montantRemise : number ;
    montantFacture : number ;
    montantTotal: number;
    dateFacture : Date ; 
    active : boolean;
    client : Client;
    detailFactures: DetailFacture[];
}
