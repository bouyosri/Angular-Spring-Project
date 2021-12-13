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
 
	/*@Query("select f from Fournisseur f join f.Produit p where p.idProduit = ?")
 
	List<Fournisseur> getFournisseursByproduit(Long idProduit);*/

	
}
