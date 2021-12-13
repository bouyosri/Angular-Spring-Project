package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import tn.esprit.spring.enume.CategorieProduit;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table( name = "DetailProduit")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idDetailProduit")

public class DetailProduit implements Serializable {
	public Long getIdDetailProduit() {
		return idDetailProduit;
	}


	public void setIdDetailProduit(Long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}


	public Date getDateCreation() {

		return dateCreation;
	}
	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	} 




	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}




	public Date getDateDerniereModification() {
		return dateDerniereModification;
	}


	public void setDateDerniereModification(Date dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
	}


	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}


	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailProduit")
	private Long idDetailProduit; // Clé primaire
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Temporal(TemporalType.DATE)
    private Date dateDerniereModification;
	@Enumerated(EnumType.STRING)
	private  CategorieProduit categorieProduit;
		
	@OneToOne(mappedBy = "Detailproduit")
	@JsonIgnore
	private Produit produit;



	
	
	
	
}
