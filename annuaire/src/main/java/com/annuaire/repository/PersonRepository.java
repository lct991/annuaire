package com.annuaire.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.annuaire.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>  {
	  //Person findByfirst_name(String first_name);
	
	
	  @Query("SELECT p FROM Person p WHERE p.first_name =:name")
	  List<Person> findPersonByFirstName(@Param("name") String name);
	  
	  @Query("SELECT p FROM Person p WHERE p.last_name =:name")
	  List<Person> findPersonByLastName(@Param("name") String name);
	  
	  @Query("SELECT p FROM Person p WHERE p.email =:email")
	  List<Person> findPersonByEmail(@Param("email") String email);
	  
	  @Query("SELECT p FROM Person p WHERE p.company =:company")
	  List<Person> findPersonByCompany(@Param("company") String company);
	  
	  @Query("SELECT p FROM Person p WHERE p.departement =:departement")
	  List<Person> findPersonByDepartement(@Param("departement") String departement);
}
