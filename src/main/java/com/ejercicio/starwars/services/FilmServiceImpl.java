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

    @Override
    public Film save(Film film) {
        return this.filmRepository.save(film);
    }

    @Override
    public List<Film> getFilms() {
        return this.filmRepository.findAll();
    }

    @Override
    public List<Film> getFilmsByPerson(Long idPerson) {
        Optional<Person> person = this.personRepository.findById(idPerson);
        return this.filmRepository.getFilmsByPeopleIsContaining(person);
    }

}
