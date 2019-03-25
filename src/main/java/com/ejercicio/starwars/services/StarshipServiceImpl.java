package com.ejercicio.starwars.services;

import com.ejercicio.starwars.dao.StarshipRepository;
import com.ejercicio.starwars.model.Starship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarshipServiceImpl implements StarshipService {

    @Autowired
    protected StarshipRepository starshipRepository;

    /**
     * Almacena una nave
     * @param starship
     * @return
     */
    @Override
    public Starship save(Starship starship) {
        return this.starshipRepository.save(starship);
    }

    /**
     * Recupera una nave por su identificador
     * @param idStarship
     * @return
     */
    @Override
    public Starship findById(Long idStarship) {
        return starshipRepository.findById(idStarship).get();
    }

    /**
     * Recupera el listado de naves
     * @return
     */
    @Override
    public List<Starship> getStarships() {
        return starshipRepository.findAll();
    }
}
