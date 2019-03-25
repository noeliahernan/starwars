package com.ejercicio.starwars.controllers;

import com.ejercicio.starwars.model.Film;
import com.ejercicio.starwars.model.Starship;
import com.ejercicio.starwars.services.FilmService;
import com.ejercicio.starwars.services.StarshipService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarshipController {
    @Autowired
    protected StarshipService starshipService;

   @RequestMapping(value= "getStarships", method= RequestMethod.GET)
    public List<Starship> getStarships() {
       return this.starshipService.getStarships();
   }
}
