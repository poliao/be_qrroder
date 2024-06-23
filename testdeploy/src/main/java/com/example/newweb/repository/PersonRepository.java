package com.example.newweb.repository;




import com.example.newweb.entityinnewuppop.Person;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUsernameAndPassword(String username, String password);

    Optional<Person> findByEmail(String email);
}
