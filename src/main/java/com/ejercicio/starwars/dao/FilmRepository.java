package com.ejercicio.starwars.dao;

import com.ejercicio.starwars.model.Film;
import com.ejercicio.starwars.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> getFilmsByPeopleIsContaining(Optional<Person> person);
}
