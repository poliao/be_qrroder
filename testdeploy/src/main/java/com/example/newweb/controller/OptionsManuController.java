package com.example.newweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.newweb.entity.optionsmanu;
import com.example.newweb.service.OptionsManuService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/optionsmanu")
public class OptionsManuController {

    @Autowired
    private OptionsManuService optionsManuService;

    @GetMapping
    public List<optionsmanu> getAllOptionsManus() {
        return optionsManuService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<optionsmanu> getOptionsManuById(@PathVariable Long id) {
        Optional<optionsmanu> optionsManu = optionsManuService.findById(id);
        if (optionsManu.isPresent()) {
            return ResponseEntity.ok(optionsManu.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public optionsmanu createOptionsManu(@RequestBody optionsmanu optionsManu) {
        return optionsManuService.save(optionsManu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<optionsmanu> updateOptionsManu(@PathVariable Long id, @RequestBody optionsmanu optionsManuDetails) {
        Optional<optionsmanu> optionsManu = optionsManuService.findById(id);
        if (optionsManu.isPresent()) {
            optionsmanu updatedOptionsManu = optionsManu.get();
            updatedOptionsManu.setMenuItem(optionsManuDetails.getMenuItem());
            updatedOptionsManu.setOptionName(optionsManuDetails.getOptionName());
            updatedOptionsManu.setOptionsdetail(optionsManuDetails.getOptionsdetail());
            return ResponseEntity.ok(optionsManuService.save(updatedOptionsManu));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOptionsManu(@PathVariable Long id) {
        if (optionsManuService.findById(id).isPresent()) {
            optionsManuService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
