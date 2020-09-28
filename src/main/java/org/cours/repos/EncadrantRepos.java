package org.cours.repos;

import org.cours.model.Encadrant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface EncadrantRepos extends CrudRepository<Encadrant, Long>{
	
	

}
