package sp.repository;

import org.springframework.data.repository.CrudRepository;

import sp.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer>  {
	
	Iterable<Utilisateur> findByNom(String nom);

}
