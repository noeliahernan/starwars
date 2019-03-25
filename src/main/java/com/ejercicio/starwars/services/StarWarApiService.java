package com.ejercicio.starwars.services;

import com.google.gson.JsonArray;

public interface StarWarApiService {
    public void importDataStarWars();
    public void insertDataFilms(JsonArray films);
    public void insertDataPeople(JsonArray people);
    public void insertDataStarships(JsonArray starships);
}
