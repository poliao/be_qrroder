package com.example.newweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newweb.entity.optionsmanu;
import com.example.newweb.repository.OptionsManuRepository;

@Service
public class OptionsManuService {

    @Autowired
    private OptionsManuRepository optionsManuRepository;

    public List<optionsmanu> findAll() {
        return optionsManuRepository.findAll();
    }

    public Optional<optionsmanu> findById(Long id) {
        return optionsManuRepository.findById(id);
    }

    public optionsmanu save(optionsmanu optionsManu) {
        return optionsManuRepository.save(optionsManu);
    }

    public void deleteById(Long id) {
        optionsManuRepository.deleteById(id);
    }
}
