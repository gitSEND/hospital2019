package com.salud.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salud.gestion.model.Especialty;

@Repository
public interface EspecialtyRepository extends JpaRepository<Especialty, Long>{

}
