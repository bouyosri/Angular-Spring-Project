package tn.esprit.spring.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.*;


import tn.esprit.spring.entity.Fournisseur;
@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {
 
	/*@Query("SELECT fr FROM Fournisseur fr WHERE fr.produit.idProduit = ?1")
	List<Fournisseur> getFournisseursByproduit(Long idProduit);*/

	
}
