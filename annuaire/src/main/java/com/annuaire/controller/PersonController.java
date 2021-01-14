package com.annuaire.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.annuaire.AnnuaireApplication;
import com.annuaire.model.Person;
import com.annuaire.repository.PersonRepository;


@RestController
public class PersonController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);


    @Autowired
    private PersonRepository personRepository;
    
	@RequestMapping("/api")
	public String sayHelloAPI() {
		LOGGER.info("Api called");
		return "Hello World!!! API";
	}
	
	@RequestMapping("/api/{id}")
	public String sayHelloAPI(@PathVariable("id") long id) {
		return "Hello World!!! API " + id;
	}
	
	@GetMapping("/foos/{id}")
	@ResponseBody
	public String getFooById(@PathVariable String id) {
	    return "ID: " + id;
	}
	@GetMapping("/foos")
	@ResponseBody
	public String getFooByIdUsingQueryParam(@RequestParam String id) {
	    return "ID: " + id;
	}
    
    @RequestMapping("/person")
    public List<Person> getPersons() {
    	LOGGER.info("/person called");
        return personRepository.findAll();
    }
	@RequestMapping("/person/{id}")
	public Optional<Person> getById(@PathVariable("id") long id) {
		return personRepository.findById(id);
	}
	@RequestMapping("/person/fn/{name}")
	public List<Person> getByFirstName(@PathVariable("name") String name) {
		LOGGER.info("/person/fn called");
		return personRepository.findPersonByFirstName(name);
	}
	@RequestMapping("/person/ln/{name}")
	public List<Person> getByLastName(@PathVariable("name") String name) {
		return personRepository.findPersonByLastName(name);
	}
	@RequestMapping("/person/email/{email}")
	public List<Person> getByEmail(@PathVariable("email") String email) {
		return personRepository.findPersonByEmail(email);
	}
	@RequestMapping("/person/company/{company}")
	public List<Person> getByCompany(@PathVariable("company") String company) {
		return personRepository.findPersonByCompany(company);
	}
	@RequestMapping("/person/departement/{departement}")
	public List<Person> getByDepartement(@PathVariable("departement") String departement) {
		return personRepository.findPersonByDepartement(departement);
	}
    @PostMapping("/person")
    public Person createPerson( @RequestBody Person person) {
        return personRepository.save(person);
    }

}
