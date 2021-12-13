package tn.esprit.spring.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import tn.esprit.spring.entity.Fournisseur;

public interface pdfService {
	 


		ByteArrayInputStream exportPDF(List<Fournisseur> fournisseurs);
	

}
