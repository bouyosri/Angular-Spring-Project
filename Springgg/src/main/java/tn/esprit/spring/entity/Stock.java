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
import javax.persistence.OneToOne;
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
@Table( name = "Stock")
public class Stock implements Serializable {
	public Long getIdStock() {
		return idStock;
	}



	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}



	public Integer getQte() {
		return qte;
	}



	public void setQte(Integer qte) {
		this.qte = qte;
	}



	public Integer getQteMin() {
		return qteMin;
	}



	public void setQteMin(Integer qteMin) {
		this.qteMin = qteMin;
	}



	public String getLibelleStock() {
		return libelleStock;
	}



	public void setLibelleStock(String libelleStock) {
		this.libelleStock = libelleStock;
	}



	public Set<Produit> getStockproduittt() {
		return stockproduittt;
	}



	public void setStockproduittt(Set<Produit> stockproduittt) {
		this.stockproduittt = stockproduittt;
	}



	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private Long idStock;
	private Integer qte;
	private Integer qteMin;
	private String libelleStock;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stockproduit")
	private Set<Produit> stockproduittt;



	



	
	
	
}