package com.ejercicio.starwars.controllers;

import com.ejercicio.starwars.model.Film;
import com.ejercicio.starwars.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmController {
    @Autowired
    protected FilmService filmService;

   @RequestMapping(value= "getFilms", method= RequestMethod.GET)
    public List<Film> getFilms() {
       return this.filmService.getFilms();
   }

    @RequestMapping(value = "getFilmsByPerson/{id}", method = RequestMethod.GET)
    public List<Film> getFilmsByPerson(@PathVariable("id") Long personId)  {
        List<Film> listFilmsByPerson = new ArrayList<>();
        if (personId!=null) {

            listFilmsByPerson = filmService.getFilmsByPerson(1L);

        }
        return listFilmsByPerson;
    }
}
