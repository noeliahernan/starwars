package com.ejercicio.starwars.dao;

import com.ejercicio.starwars.model.Starship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarshipRepository extends JpaRepository<Starship, Long> {
}
