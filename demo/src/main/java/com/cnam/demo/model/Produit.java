package com.cnam.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotNull
	@Size(min=2, max=30, message="Taille minimum de {min} et {max} au maximum.")
	private String nom;
	@NotNull
	@Positive
	private double prix;
	
}
