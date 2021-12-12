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
import com.sun.istack.NotNull;




@Entity

@Table( name = "Produit")
public class Produit implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private Long idProduit; 
	@NotNull
	@Column(name="code")
	private String code;
	@NotNull
	@Column(name="libelle")
	private String libelle;
	@NotNull
	@Column(name="prixUnitaire")
	private Float prixUnitaire;
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	Stock Stock;
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	Rayon Rayon;
	@NotNull
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> Fournisseur;
	@NotNull
	@OneToOne
	@JsonIgnore
	private DetailProduit detailProduit;
	@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<DetailFacture> DetailFactures;

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

	public Float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Stock getStock() {
		return Stock;
	}

	public void setStock(Stock stock) {
		Stock = stock;
	}

	public Rayon getRayon() {
		return Rayon;
	}

	public void setRayon(Rayon rayon) {
		Rayon = rayon;
	}

	public Set<Fournisseur> getFournisseur() {
		return Fournisseur;
	}

	public void setFournisseur(Set<Fournisseur> fournisseur) {
		Fournisseur = fournisseur;
	}

	public DetailProduit getDetailProduit() {
		return detailProduit;
	}

	public void setDetailProduit(DetailProduit detailProduit) {
		detailProduit = detailProduit;
	}

	public Set<DetailFacture> getDetailFactures() {
		return DetailFactures;
	}

	public void setDetailFactures(Set<DetailFacture> detailFactures) {
		DetailFactures = detailFactures;
	}

	

}
