package tn.esprit.spring.repository;

import java.util.Set;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.DetailFacture;

@Repository
public interface DetailFactureRepository extends CrudRepository<DetailFacture, Long> {
	
	@Query("SELECT df from DetailFacture df where df.facture.idFacture = ?1 AND df.produit.idProduit = ?2")
	Set<DetailFacture> getDetFactByFactureProduit(Long idFacture, Long idProduit);

}