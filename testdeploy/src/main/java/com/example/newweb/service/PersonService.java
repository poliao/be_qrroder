package com.example.newweb.service;
import com.example.newweb.entityinnewuppop.Person;
import com.example.newweb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person createPerson(Person person) {
        
        Optional<Person> existingPerson = personRepository.findByEmail(person.getEmail());
        if (existingPerson.isPresent()) {
            
            throw new RuntimeException("Email already exists!");
        }
       
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Optional<Person> personOptional = personRepository.findById(id);

        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            person.setUsername(personDetails.getUsername());
            person.setFaculty(personDetails.getFaculty());
            person.setEmail(personDetails.getEmail());
            person.setTypeUser(personDetails.getTypeUser());
            person.setPassword(personDetails.getPassword());
            person.setFirstName(personDetails.getFirstName());
            person.setLastName(personDetails.getLastName());

            return personRepository.save(person);
        } else {
            throw new RuntimeException("Person not found with id " + id);
        }
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
