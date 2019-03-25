package com.ejercicio.starwars.services;

import com.ejercicio.starwars.dao.PersonRepository;
import com.ejercicio.starwars.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    protected PersonRepository personRepository;


    /**
     * Guarda una persona
     * @param person
     * @return
     */
    @Override
    public Person save(Person person) {
        return this.personRepository.save(person);
    }

    /**
     * Busca una persona por su identificador
     * @param idPerson
     * @return
     */
    @Override
    public Person findById(Long idPerson) {
        return personRepository.findById(idPerson).get();
    }

    /**
     * Recupera la lista de personajes
     * @return
     */
    @Override
    public List<Person> getPeople() {
     return this.personRepository.findAll();
    }

    /**
     * Trae una array de string con las naves que mas aparecen en las películas seleccionadas y quien la pilota
     * @param filmsSelected
     * @return
     */
    @Override
    public Map<String, String> getPersonMaxAparciones(List<Long> filmsSelected) {
        Map<String,String> peopleStarshipMaxApa = new HashMap<>();
        personRepository.getPersonMaxAparciones(filmsSelected).stream().forEach(personMaxApariciones -> {
            peopleStarshipMaxApa.put(String.valueOf(personMaxApariciones[0]), String.valueOf(personMaxApariciones[1]));
        });
      return peopleStarshipMaxApa;
    }

}
