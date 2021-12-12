package tn.esprit.spring.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



/*@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode*/
@Entity

public class DetailProduit implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long idDetailProduit; // Clé primaire
	@NonNull
	@Temporal(TemporalType.DATE)
	Date dateCreation;
	@NonNull
	@Temporal(TemporalType.DATE)
	Date dateDernièreModification;
	@NonNull
	@Enumerated(EnumType.STRING)
	CategorieProduit categorieProduit;
	@JsonIgnore
	@NonNull
	@OneToOne(mappedBy = "detailProduit")
    Produit produit;
	
	public void setDateDerniereModification(Date date) {
		// TODO Auto-generated method stub
		dateDernièreModification=date;
	}

	public Long getIdDetailProduit() {
		return idDetailProduit;
	}

	public void setIdDetailProduit(Long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateDernièreModification() {
		return dateDernièreModification;
	}

	public void setDateDernièreModification(Date dateDernièreModification) {
		this.dateDernièreModification = dateDernièreModification;
	}

	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	
}
		
	
	
	



