package com.example.newweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.newweb.entity.optionsmanu;

@Repository
public interface OptionsManuRepository extends JpaRepository<optionsmanu, Long> {
}
