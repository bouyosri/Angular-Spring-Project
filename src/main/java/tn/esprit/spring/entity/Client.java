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

import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter



@Table( name = "Client")
public class Client implements Serializable {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="idClient")
private Long idClient; 

@Column(name="nom")
private String nom;

@Column(name="prenom")
private String prenom;

@Column(name="email")
private String email;

@Column(name="password")
private String password;

@Temporal(TemporalType.DATE)
@Column(name="dateNaissance")
private Date dateNaissance;

@Enumerated(EnumType.STRING)
@Column(name="profession")
private Profession profession;
@JsonIgnore
@Enumerated(EnumType.STRING)
@Column(name="categorieClient")
private CategorieClient categorieClient;

@OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
private Set<Facture> Factures ;

 


}