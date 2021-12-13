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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.spring.enume.CategorieClient;
import tn.esprit.spring.enume.Profession;
//lezem entity w serializable w @id kahaw
//non serializable il y a yne chance de perte de donnée
//ken te7otech GenerationType y7ot auto(table sequence)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table( name = "Client")
public class Client implements Serializable {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="idClient")
private Long idClient; // Clé primaire
private String nom; 
private String prenom; 
private String email; 
private String password; 
@Temporal(TemporalType.DATE)
private Date dateNaissance; //util import
@Enumerated(EnumType.STRING)
private Profession profession;
@Enumerated(EnumType.STRING)
private CategorieClient categorieClient;




public Client(Long idClient, String nom, String prenom, String email, String password, Date dateNaissance,
		Profession profession, CategorieClient categorieClient, Set<Facture> detailFacture) {
	super();
	this.idClient = idClient;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.password = password;
	this.dateNaissance = dateNaissance;
	this.profession = profession;
	this.categorieClient = categorieClient;
	this.detailFacture = detailFacture;
}




public Client() {
	super();
}


@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="ClientFacure")
private Set<Facture> detailFacture;




public Long getIdClient() {
	return idClient;
}




public void setIdClient(Long idClient) {
	this.idClient = idClient;
}




public String getNom() {
	return nom;
}




public void setNom(String nom) {
	this.nom = nom;
}




public String getPrenom() {
	return prenom;
}




public void setPrenom(String prenom) {
	this.prenom = prenom;
}




public String getEmail() {
	return email;
}




public void setEmail(String email) {
	this.email = email;
}




public String getPassword() {
	return password;
}




public void setPassword(String password) {
	this.password = password;
}




public Date getDateNaissance() {
	return dateNaissance;
}




public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}




public Profession getProfession() {
	return profession;
}




public void setProfession(Profession profession) {
	this.profession = profession;
}




public CategorieClient getCategorieClient() {
	return categorieClient;
}




public void setCategorieClient(CategorieClient categorieClient) {
	this.categorieClient = categorieClient;
}




public Set<Facture> getDetailFacture() {
	return detailFacture;
}




public void setDetailFacture(Set<Facture> detailFacture) {
	this.detailFacture = detailFacture;
}









}