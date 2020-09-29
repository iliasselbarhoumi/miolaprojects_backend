package com.miolaprojects.MiolaProjects.Dao;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<DaoUser, Long>{

	DaoUser findByUsername(String username);
}
