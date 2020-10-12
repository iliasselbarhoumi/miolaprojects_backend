package org.cours.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<DaoUser, Long>{

	DaoUser findByUsername(String username);
	@Query(value = "select username from DaoUser")
	List<String> getAllUsernames();
}	
