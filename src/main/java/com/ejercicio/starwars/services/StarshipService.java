package com.ejercicio.starwars.services;

import com.ejercicio.starwars.model.Starship;

import java.util.List;

public interface StarshipService {
    Starship save(Starship starship);

    Starship findById(Long idStarship);

    List<Starship> getStarships();
}
