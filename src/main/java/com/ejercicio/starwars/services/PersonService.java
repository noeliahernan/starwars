package com.ejercicio.starwars.services;

import com.ejercicio.starwars.model.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {
    Person save(Person person);
    Person findById(Long idPerson);
    List<Person> getPeople();
    Map<String, String> getPersonMaxAparciones (List<Long> filmsSeleccionadas);
}
