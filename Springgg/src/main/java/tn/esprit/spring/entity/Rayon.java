package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table( name = "Rayon")
public class Rayon implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idRayon")
	private Long idRayon; 
	private String code;
	private String libelle;
	
	
	
	
	
	public Long getIdRayon() {
		return idRayon;
	}





	public void setIdRayon(Long idRayon) {
		this.idRayon = idRayon;
	}





	public String getCode() {
		return code;
	}





	public void setCode(String code) {
		this.code = code;
	}





	public String getLibelle() {
		return libelle;
	}





	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}





	public Set<Produit> getRayonproduittt() {
		return rayonproduittt;
	}





	public void setRayonproduittt(Set<Produit> rayonproduittt) {
		this.rayonproduittt = rayonproduittt;
	}





	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayonproduit")
	private Set<Produit> rayonproduittt;

	
	
	
}
