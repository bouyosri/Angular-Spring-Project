package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table( name = "Produit")
public class Produit implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private Long idProduit; 

	@Column(name="code")
	private String code;

	@Column(name="libelle")
	private String libelle;
	
	@Column(name="prixUnitaire")
	private Float prixUnitaire;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	Stock Stock;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	Rayon Rayon;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> Fournisseur;
	
	@JsonIgnore
	@OneToOne
	private DetailProduit DetailProduit;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<DetailFacture> DetailFactures;

	

}
