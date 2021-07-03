package com.axsos.authentication.eventsPlanner.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.authentication.eventsPlanner.models.User;
@Repository

public interface UserRepository  extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
