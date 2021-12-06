package com.example.personnage.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.personnage.mappers.PersonnageMapper;
import com.example.personnage.models.dtos.PersonnageDTO;
import com.example.personnage.models.entities.Personnage;
import com.example.personnage.models.forms.PersonnageForm;
import com.example.personnage.repositories.PersonnageRepository;

import org.springframework.stereotype.Service;

@Service
public class PersonnageService implements BaseService<PersonnageDTO, PersonnageForm, Long> {

    private final PersonnageRepository personnageRepository;
    private final PersonnageMapper personnageMapper;

    public PersonnageService(PersonnageRepository personnageRepository, PersonnageMapper personnageMapper) {

        this.personnageRepository = personnageRepository;
        this.personnageMapper = personnageMapper;
    }

    @Override
    public List<PersonnageDTO> getAll() {

        return this.personnageRepository
                .findAll()
                .stream()
                .map(this.personnageMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonnageDTO getOneById(Long id) {

        return this.personnageMapper.entityToDto(this.personnageRepository
                                                  .findById(id)
                                                  .orElse(null));
    }

    @Override
    public PersonnageDTO insert(PersonnageForm form) {

        Personnage p = this.personnageMapper.formToEntity(form);

        return this.personnageMapper.entityToDto(this.personnageRepository.save(p));
    }

    @Override
    public Long delete(Long id) {

        Personnage p = this.personnageRepository
                        .findById(id)
                        .orElse(null);

        if (p != null) {

            this.personnageRepository.delete(p);

            return p.getId();
        }

        return -1L;
    }

    @Override
    public PersonnageDTO update(PersonnageForm form, Long id) {

        Personnage p = this.personnageRepository
                        .findById(id)
                        .orElse(null);

        if (p != null) {

            p.setFirstname(form.getFirstname());
            p.setLastname(form.getLastname());
            this.personnageRepository.save(p);
        }
        return this.personnageMapper.entityToDto(p);
    }

}