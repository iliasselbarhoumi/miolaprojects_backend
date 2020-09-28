package org.cours.repos;

import org.cours.model.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface EtudiantRepos extends CrudRepository<Etudiant, Long>{

}
