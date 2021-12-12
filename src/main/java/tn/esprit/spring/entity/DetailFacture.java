package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity

@Table( name = "DetailFacture")

@Getter
@Setter
public class DetailFacture implements Serializable {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailFacture")
	private Long idDetailFacture; 
	
	@Column(name="qte")
	private Integer qte;
	
	
	@Column(name="prixTotal")
	private Float prixTotal;
	
	
	@Column(name="pourcentageRemise")
	private Integer pourcentageRemise;
	
	
	@Column(name="montantRemise")
	private Float montantRemise;
	
	
	@ManyToOne
	Produit produit;
	
	
	@JsonIgnore
	@ManyToOne
	Facture facture;

}
