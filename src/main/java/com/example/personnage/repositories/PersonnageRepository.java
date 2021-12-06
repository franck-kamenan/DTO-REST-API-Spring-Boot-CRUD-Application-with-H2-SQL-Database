package com.example.personnage.repositories;

import com.example.personnage.models.entities.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Long> {}