package com.ejercicio.starwars.services;


import com.ejercicio.starwars.model.Film;
import com.ejercicio.starwars.model.Person;
import com.ejercicio.starwars.model.Starship;
import com.ejercicio.starwars.util.HttpClientApi;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StarWarsApiServiceImpl implements StarWarApiService {

    private static final String FILMS = "films";
    private static final String PEOPLE = "people";
    private static final String STARSHIPS = "starships";
    private static final String URL_PEOPLE = "https://swapi.co/api/people";
    private static final String URL_FILMS = "https://swapi.co/api/films";
    private static final String URL_STARSHIPS = "https://swapi.co/api/starships";
    @Autowired
    public FilmService filmService;
    @Autowired
    public PersonService personService;
    @Autowired
    public StarshipService starshipService;

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void importDataStarWars() {
        Map<String, JsonArray> dataStarWars = getData();
        if (!dataStarWars.isEmpty()) {
            JsonArray starships = dataStarWars.get(STARSHIPS);
            if (starships.size() > 0) {
                insertDataStarships(starships);
            }
            JsonArray people = dataStarWars.get(PEOPLE);
            if (people.size() > 0) {
                insertDataPeople(people);
            }
            JsonArray films = dataStarWars.get(FILMS);
            if (films.size() > 0) {
                insertDataFilms(films);
            }
            List<Long> filmSeleccionados = new ArrayList<>();
            filmSeleccionados.add(1L);
            filmSeleccionados.add(3L);
            filmSeleccionados.add(7L);
        }
    }


    @Override
    public void insertDataFilms(JsonArray films) {
        films.forEach(film -> {
            Gson gson = new GsonBuilder().create();
            Film filmObject = gson.fromJson(film, Film.class);
            String id = (filmObject.getUrl().replaceAll(URL_FILMS,"")).replaceAll("/","");
            filmObject.setIdFilm(Long.parseLong(id));
            Set<Person> people = new HashSet<>();
            ((JsonObject) film).getAsJsonArray("characters").forEach(character->{
                String idPerson = ( character.getAsString().replaceAll(URL_PEOPLE,"")).replaceAll("/","");
                people.add(personService.findById(Long.parseLong(idPerson)));
            });
            Set<Starship> starships = new HashSet<>();
            ((JsonObject) film).getAsJsonArray("starships").forEach(starship->{
                String idStarship = ( starship.getAsString().replaceAll(URL_STARSHIPS,"")).replaceAll("/","");
                starships.add(starshipService.findById(Long.parseLong(idStarship)));
            });
            filmObject.setPeople(people);
            filmObject.setStarshipsFilms(starships);
            filmService.save(filmObject);
        });
    }

    @Override
    public void insertDataPeople(JsonArray people) {
        people.forEach(person -> {
            Gson gson = new GsonBuilder().create();
            Person personObject = gson.fromJson(person, Person.class);
            String id = (personObject.getUrl().replaceAll(URL_PEOPLE,"")).replaceAll("/","");
            personObject.setIdPerson(Long.parseLong(id));
            Set<Starship> starships = new HashSet<>();
            ((JsonObject) person).getAsJsonArray("starships").forEach(starship->{
                String idStarship = ( starship.getAsString().replaceAll(URL_STARSHIPS,"")).replaceAll("/","");
                starships.add(starshipService.findById(Long.parseLong(idStarship)));
            });
            personObject.setStarshipsPeople(starships);
            personService.save(personObject);
        });
    }

    @Override
    public void insertDataStarships(JsonArray starships) {
        starships.forEach(starship -> {
            Gson gson = new GsonBuilder().create();
            Starship starshipObject = gson.fromJson(starship, Starship.class);
            String id = (starshipObject.getUrl().replaceAll(URL_STARSHIPS,"")).replaceAll("/","");
            starshipObject.setIdStarship(Long.parseLong(id));
            starshipService.save(starshipObject);
        });
    }

    private Map<String, JsonArray> getData() {
        Map<String, JsonArray> dataStarWars = new HashMap<>();
        dataStarWars.put(FILMS, HttpClientApi.getDataApi(URL_FILMS));
        dataStarWars.put(PEOPLE, HttpClientApi.getDataApi(URL_PEOPLE));
        dataStarWars.put(STARSHIPS, HttpClientApi.getDataApi(URL_STARSHIPS));
        return dataStarWars;
    }
}
