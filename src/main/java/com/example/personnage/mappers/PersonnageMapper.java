package com.example.personnage.mappers;

import com.example.personnage.models.dtos.PersonnageDTO;
import com.example.personnage.models.entities.Personnage;
import com.example.personnage.models.forms.PersonnageForm;
import org.springframework.stereotype.Service;

@Service
public class PersonnageMapper implements BaseMapper<PersonnageDTO, PersonnageForm, Personnage> {

    @Override
    public Personnage formToEntity(PersonnageForm form) {

        Personnage p = new Personnage();

        p.setFirstname(form.getFirstname());
        p.setLastname(form.getLastname());
        return p;
    }

    @Override
    public PersonnageDTO entityToDto(Personnage entity) {

        if (entity != null && entity.getId() > 0) {

            return PersonnageDTO.builder()
                    .id(entity.getId())
                    .firstname(entity.getFirstname())
                    .lastname(entity.getLastname())
                    .build();
        }

        return null;
    }

    @Override
    public Personnage dtoToEntity(PersonnageDTO dto) {

        Personnage p = new Personnage();
        if (dto != null && dto.getId() > 0) {

            p.setId(dto.getId());
            p.setFirstname(dto.getFirstname());
            p.setLastname(dto.getLastname());
        }
        
        return p;
    }

}