package com.ejercicio.starwars.services;

import com.google.gson.JsonArray;

public interface StarWarApiService {
    void importDataStarWars();
    void insertDataFilms(JsonArray films);
    void insertDataPeople(JsonArray people);
    void insertDataStarships(JsonArray starships);
}
