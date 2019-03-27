package com.cnam.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.cnam.demo.model.Utilisateur;


/**
 * Interface pour les action CRUD (Create update,delete) entite utilisateur
 * @author dells
 *
 */
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer>  {
	
	Iterable<Utilisateur> findByNom(String nom);
	

}
