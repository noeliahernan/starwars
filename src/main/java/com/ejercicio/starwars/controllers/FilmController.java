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

    /**
     * Recupera el listado de películas
     * @return
     */
   @RequestMapping(value= "getFilms", method= RequestMethod.GET)
    public List<Film> getFilms() {
       return this.filmService.getFilms();
   }

    /**
     * Recupera el listado de películas donde aparece una persona
     * @param personId
     * @return
     */
    @RequestMapping(value = "getFilmsByPerson/{id}", method = RequestMethod.GET)
    public List<Film> getFilmsByPerson(@PathVariable("id") Long personId)  {
        List<Film> listFilmsByPerson = new ArrayList<>();
        if (personId!=null) {

            listFilmsByPerson = filmService.getFilmsByPerson(personId);

        }
        return listFilmsByPerson;
    }
}
