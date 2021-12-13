package tn.esprit.spring.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.*;


import tn.esprit.spring.entity.Fournisseur;
@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
 
	/*@Query("SELECT * FROM `fournisseur`WHERE id_fournisseur=?")
 
	List<Fournisseur> getFournisseursByproduit(Long idFournisseur);*/

	
}
