package com.ejercicio.starwars.controllers;

import com.ejercicio.starwars.model.Person;
import com.ejercicio.starwars.services.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    protected PersonService personService;

    /**
     * Recupera un listado de personas
     * @return
     */
    @RequestMapping(value = "getPeople", method = RequestMethod.GET)
    public List<Person> getPeople() {
        return this.personService.getPeople();
    }

    /**
     * Recupera las naves que más aparecen y las personas que más la conducen
     * @param filmsSeleccionadas
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getPeopleMaxApaByFilm", method = RequestMethod.POST)
    public List<String> getPeopleMaxApaByFilm(@RequestBody List<Long> filmsSeleccionadas) throws Exception {

        List<String> result = new ArrayList<>();
        if (!filmsSeleccionadas.isEmpty()) {
             personService.getPersonMaxAparciones(filmsSeleccionadas).forEach((key, value) -> {
                result.add("Nave : " + value + " Piloto :" + key );
            });

        }
        return result;
    }
}
