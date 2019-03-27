package com.ejercicio.starwars.services;


import com.ejercicio.starwars.model.Film;
import com.ejercicio.starwars.model.Person;
import com.ejercicio.starwars.model.Starship;
import com.ejercicio.starwars.util.HttpClientApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    @EventListener(ContextRefreshedEvent.class)
    /**
     * Se encarga de llamar a la api y llenar las tablas
     */
    public void importDataStarWars() {
        //Llama a la api y recupera un mapa con cada una de las tablas
        Map<String, JsonArray> dataStarWars = getData();
        if (!dataStarWars.isEmpty()) {
            JsonArray starships = dataStarWars.get(STARSHIPS);
            if (starships.size() > 0) {
                //Inserta los datos en la tabla
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
        }
    }


    /**
     * Método que inserta las películas de la api en su tabla correspondiente
     * @param films
     */
    @Override
    public void insertDataFilms(JsonArray films) {
        //Recibimos una lista de jsonArray de películas y las recorremos
        films.forEach(film -> {
            //Creamos un objeto json de cada registro para después mapearlo con su clase
            Gson gson = new GsonBuilder().create();
            Film filmObject = gson.fromJson(film, Film.class);
            //Recuperamos el identificador de la url y se lo pasamos al objeto
            String id = (filmObject.getUrl().replaceAll(URL_FILMS,"")).replaceAll("/","");
            filmObject.setIdFilm(Long.parseLong(id));
            //Creamos un array de personas para almacenar los personajes de las películas
            Set<Person> people = new HashSet<>();
            //Lo recorremos y sacamos el id de cada personaje para después buscar por su identificador en su tabla
            ((JsonObject) film).getAsJsonArray("characters").forEach(character->{
                String idPerson = ( character.getAsString().replaceAll(URL_PEOPLE,"")).replaceAll("/","");
                people.add(personService.findById(Long.parseLong(idPerson)));
            });
            //Hacemos lo mismo con las naves
            Set<Starship> starships = new HashSet<>();
            ((JsonObject) film).getAsJsonArray("starships").forEach(starship->{
                String idStarship = ( starship.getAsString().replaceAll(URL_STARSHIPS,"")).replaceAll("/","");
                starships.add(starshipService.findById(Long.parseLong(idStarship)));
            });
            //Añadimos al objeto tanto las naves como las personas y guardamos.
            filmObject.setPeople(people);
            filmObject.setStarshipsFilms(starships);
            filmService.save(filmObject);
        });
    }

    /**
     * Método que inserta las personas en su correspondiente tabla
     * @param people
     */
    @Override
    public void insertDataPeople(JsonArray people) {
        //Recorremos el array de json y lo mapeamos a una clase persona, recuperamos sus naves y se las mapeamos a la clase persona
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

    /**
     * Inserta la información de las naves espaciales en su correspondiente tabla
     * @param starships
     */
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


    /**
     * Conecta con la api a través de un cliente
     * @return
     */
    private Map<String, JsonArray> getData() {
        Map<String, JsonArray> dataStarWars = new HashMap<>();
        dataStarWars.put(FILMS, HttpClientApi.getDataApi(URL_FILMS));
        dataStarWars.put(PEOPLE, HttpClientApi.getDataApi(URL_PEOPLE));
        dataStarWars.put(STARSHIPS, HttpClientApi.getDataApi(URL_STARSHIPS));
        return dataStarWars;
    }
}
