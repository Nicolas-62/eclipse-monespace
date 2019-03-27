package com.cnam.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.cnam.demo.model.Produit;

public interface ProduitRepositery extends CrudRepository<Produit, Integer>{
	
	Iterable<Produit> findByNom(String nom);
}
