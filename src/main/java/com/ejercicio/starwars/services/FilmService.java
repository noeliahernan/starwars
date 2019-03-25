package com.ejercicio.starwars.services;

import com.ejercicio.starwars.model.Film;

import java.util.List;

public interface FilmService {
    Film save(Film film);
    List<Film> getFilms();
    List<Film> getFilmsByPerson(Long idPerson);
}
