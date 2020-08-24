package com.globallogic.bootcampgl.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.bootcampgl.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	/*
	 * Collection<Client> findByFirstName(String firstName); 
	 * Collection<Client> findByLastName(String lastName); 
	 * Collection<Client> findByMail(String mail);
	 */
	Collection<Client> findByFirstNameOrLastNameOrMail(String firstName,
			String lastName, 
			String mail);
	
}
