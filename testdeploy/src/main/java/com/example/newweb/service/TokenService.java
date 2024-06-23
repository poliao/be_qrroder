package com.example.newweb.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newweb.entityinnewuppop.Person;
import com.example.newweb.repository.PersonRepository;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

@Service
public class TokenService {
    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Autowired
    private PersonRepository personRepository;

    public String generateToken(String email) {
        Person person = personRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("id", person.getIdUser());
        claims.put("email", person.getEmail());
        claims.put("firstname", person.getFirstName());
        claims.put("lastname", person.getLastName());
        claims.put("tyuser", person.getTypeUser());
        claims.put("username", person.getUsername());
        claims.put("faculty", person.getFaculty());

        // Set token expiration time (e.g., 30 minutes)
        long expirationTime = 30 * 60 * 1000; // 30 minutes in milliseconds
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public Optional<Person> getPersonFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Long personId = claims.get("id", Long.class);
        return personRepository.findById(personId);
    }
}
