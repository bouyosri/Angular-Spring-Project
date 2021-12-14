package tn.esprit.spring.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Client;




@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	@Query("SELECT c FROM Client c WHERE c.dateNaissance BETWEEN ':d1' AND ':d2' ")
	public List<Client> retrieveClientsByDate(
	@Param("d1") Date d1,	@Param("d1") Date d2);
	
	
	@Query(value = "SELECT c FROM Client c WHERE c.dateNaissance BETWEEN ':d1' AND ':d2'",
			nativeQuery = true)
			public List<Client> retrieveClientsByDate_SQL(
			@Param("d1") Date d1,	@Param("d1") Date d2);
	
	@Query("SELECT c FROM Client c WHERE c.categorieClient = ':cat' ")
	public List<Client> retrieveClientsByCat(
	@Param("cat") String cat);
	
	
	
void findByDateNaissanceGreaterThan(Date dateN);
	 
	
	
	@Query("SELECT c FROM Client c WHERE c.dateNaissance BETWEEN :d1 and :d2")
	List<Client> retrieveClientsByDateNaissance(@Param("d1") Date d1 , @Param("d2") Date d2);
	
	

	
	
	@Query(value="SELECT COUNT(*) from facture f where f.client_facure_id_client= ?1" , nativeQuery= true)
	 int getnbrefacture(Long id_client);
	
	@Query(value="SELECT SUM(montant_facture) from facture f where f.client_facure_id_client= ?1" , nativeQuery= true)
	 float gettotalfacture(Long id_client);
	
	@Query(value="SELECT SUM(montant_facture) from facture f " , nativeQuery= true)
	 float gettotalfactures();
	
	@Query(value="SELECT * from client c where c.nom LIKE %?1% " , nativeQuery= true)
	List<Client> search(String nom);
	
	
}
