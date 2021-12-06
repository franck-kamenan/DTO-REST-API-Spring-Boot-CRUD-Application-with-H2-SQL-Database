package com.example.personnage.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.personnage.models.dtos.PersonnageDTO;
import com.example.personnage.models.forms.PersonnageForm;
import com.example.personnage.services.PersonnageService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/personnage")
public class PersonnageController {

    private final PersonnageService personnageService;

    public PersonnageController(PersonnageService personnageService) {

        this.personnageService = personnageService;
    }

    @GetMapping
    public ResponseEntity<List<PersonnageDTO>> getList() {

        return ResponseEntity.ok(this.personnageService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonnageDTO> getOneById(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(this.personnageService.getOneById(id));
    }

    @PostMapping()
    public ResponseEntity<PersonnageDTO> insertOne(@Valid @RequestBody PersonnageForm form) {

        return ResponseEntity.ok(this.personnageService.insert(form));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PersonnageDTO> updateOne(@PathVariable(name = "id") Long id, @Valid @RequestBody PersonnageForm form) {

        return ResponseEntity.ok(this.personnageService.update(form, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Long> deleteOne(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(this.personnageService.delete(id));
    }
}