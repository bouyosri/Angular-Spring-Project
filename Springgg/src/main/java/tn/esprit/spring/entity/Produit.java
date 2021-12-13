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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@Table( name = "Produit")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idProduit")

public class Produit implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idproduit")
	private Long idProduit; // Clé primaire
	private String code;
	private String libelle;
	private float prixUnitaire;
	
	
	


	@OneToMany(cascade = CascadeType.ALL, mappedBy="Totheparentdetailfacture")
	private Set<detailFacture> detailFacture;
	
	
	
	
	@OneToOne
	@JoinColumn(name = "idDetailProduit")
	private DetailProduit Detailproduit;
	
	
	
	@ManyToOne
	@JsonIgnore
	private Stock stockproduit; 
	
	@ManyToOne
	@JsonIgnore
	private Rayon rayonproduit; 
	
	
	@ManyToMany(cascade = CascadeType.ALL) 
	private Set<Fournisseur> fournisseurproduit;


	public Long getIdProduit() {
		return idProduit;
	}


	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
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


	public float getPrixUnitaire() {
		return prixUnitaire;
	}


	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}


	public Set<detailFacture> getDetailFacture() {
		return detailFacture;
	}


	public void setDetailFacture(Set<detailFacture> detailFacture) {
		this.detailFacture = detailFacture;
	}


	public DetailProduit getDetailproduit() {
		return Detailproduit;
	}


	public void setDetailproduit(DetailProduit detailproduit) {
		Detailproduit = detailproduit;
	}


	public Stock getStockproduit() {
		return stockproduit;
	}


	public void setStockproduit(Stock stockproduit) {
		this.stockproduit = stockproduit;
	}


	public Rayon getRayonproduit() {
		return rayonproduit;
	}


	public void setRayonproduit(Rayon rayonproduit) {
		this.rayonproduit = rayonproduit;
	}


	public Set<Fournisseur> getFournisseurproduit() {
		return fournisseurproduit;
	}


	public void setFournisseurproduit(Set<Fournisseur> fournisseurproduit) {
		this.fournisseurproduit = fournisseurproduit;
	}

	
	

}