package tn.esprit.spring.entity;
import java.io.Serializable;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity

@Table( name = "Facture")
public class Facture implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFacture")
	private Long idFacture; 
	
	@Column(name="montantRemise")
	private Float montantRemise;
	
	@Column(name="montantFacture")
	private Float montantFacture;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateFacture")
	private Date dateFacture;
	

	@Column(name="active")
	private Boolean active;

	@ManyToOne
	Client client;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<DetailFacture> DetailFactures ;

	public Long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}

	public Float getMontantRemise() {
		return montantRemise;
	}

	public void setMontantRemise(Float montantRemise) {
		this.montantRemise = montantRemise;
	}

	public Float getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(Float montantFacture) {
		this.montantFacture = montantFacture;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<DetailFacture> getDetailFactures() {
		return DetailFactures;
	}

	public void setDetailFactures(Set<DetailFacture> detailFactures) {
		DetailFactures = detailFactures;
	}

	 

	


}
