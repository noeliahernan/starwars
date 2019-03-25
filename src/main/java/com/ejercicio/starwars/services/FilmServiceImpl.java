package com.ejercicio.starwars.services;

import com.ejercicio.starwars.dao.FilmRepository;
import com.ejercicio.starwars.dao.PersonRepository;
import com.ejercicio.starwars.model.Film;
import com.ejercicio.starwars.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    protected FilmRepository filmRepository;
    @Autowired
    protected PersonRepository personRepository;

    /**
     * Almacena una película
     * @param film
     * @return
     */
    @Override
    public Film save(Film film) {
        return this.filmRepository.save(film);
    }

    /**
     * Recupera un listado de películas
     * @return
     */
    @Override
    public List<Film> getFilms() {
        return this.filmRepository.findAll();
    }

    /**
     * Recupera las películas en las que aparece una persona
     * @param idPerson
     * @return
     */
    @Override
    public List<Film> getFilmsByPerson(Long idPerson) {
        Optional<Person> person = this.personRepository.findById(idPerson);
        return this.filmRepository.getFilmsByPeopleIsContaining(person);
    }

}
