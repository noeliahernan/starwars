package com.ejercicio.starwars.dao;

import com.ejercicio.starwars.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person save(Person person);

    @Query(value ="SELECT NAME_PERSONA, NAME_STARSHIP FROM \n" +
            "(SELECT COUNT(P.ID_PERSON) AS TOTAL_APARICIONES,  P.NAME AS NAME_PERSONA, S.NAME AS NAME_STARSHIP FROM PEOPLE P, PEOPLE_STARSHIPS PS, STARSHIPS S, FILMS_PEOPLE FP, FILMS F\n" +
            "WHERE P.ID_PERSON = PS.ID_PERSON\n" +
            "AND S.ID_STARSHIP = PS.ID_STARSHIP\n" +
            "AND P.ID_PERSON = FP.ID_PERSON\n" +
            "AND F.ID_FILM = FP.ID_FILM\n" +
            "AND S.ID_STARSHIP IN \n" +
            "(SELECT ID_STARSHIP FROM \n" +
            "(SELECT COUNT(S.ID_STARSHIP) AS VECES_APARECE, S.ID_STARSHIP AS ID_STARSHIP FROM FILMS F, FILMS_STARSHIPS FS, STARSHIPS S, PEOPLE_STARSHIPS PS, PEOPLE P\n" +
            "WHERE F.ID_FILM = FS.ID_FILM\n" +
            "AND S.ID_STARSHIP = FS.ID_STARSHIP\n" +
            "AND PS.ID_STARSHIP = S.ID_STARSHIP\n" +
            "AND PS.ID_PERSON = P.ID_PERSON\n" +
            "AND F.ID_FILM IN (?1)\n" +
            "GROUP BY  S. ID_STARSHIP)\n" +
            "WHERE VECES_APARECE = \n" +
            "(SELECT MAX(VECES_APARECE) FROM \n" +
            "(SELECT COUNT(S.ID_STARSHIP) AS VECES_APARECE, S. ID_STARSHIP FROM FILMS F, FILMS_STARSHIPS FS, STARSHIPS S, PEOPLE_STARSHIPS PS, PEOPLE P\n" +
            "WHERE F.ID_FILM = FS.ID_FILM\n" +
            "AND S.ID_STARSHIP = FS.ID_STARSHIP\n" +
            "AND PS.ID_STARSHIP = S.ID_STARSHIP\n" +
            "AND PS.ID_PERSON = P.ID_PERSON\n" +
            "AND F.ID_FILM IN  (?1)\n" +
            "GROUP BY  S. ID_STARSHIP)\n" +
            ")\n" +
            ")\n" +
            "AND F.ID_FILM IN  (?1)\n" +
            "GROUP BY  P.ID_PERSON)\n" +
            "WHERE TOTAL_APARICIONES =\n" +
            "(SELECT MAX(TOTAL_APARICIONES) FROM (\n" +
            "SELECT COUNT(P.ID_PERSON) AS TOTAL_APARICIONES, P.ID_PERSON AS ID_PERSON, P.NAME FROM PEOPLE P, PEOPLE_STARSHIPS PS, STARSHIPS S, FILMS_PEOPLE FP, FILMS F\n" +
            "WHERE P.ID_PERSON = PS.ID_PERSON\n" +
            "AND S.ID_STARSHIP = PS.ID_STARSHIP\n" +
            "AND P.ID_PERSON = FP.ID_PERSON\n" +
            "AND F.ID_FILM = FP.ID_FILM\n" +
            "AND S.ID_STARSHIP IN \n" +
            "(SELECT ID_STARSHIP FROM \n" +
            "(SELECT COUNT(S.ID_STARSHIP) AS VECES_APARECE, S.ID_STARSHIP AS ID_STARSHIP FROM FILMS F, FILMS_STARSHIPS FS, STARSHIPS S, PEOPLE_STARSHIPS PS, PEOPLE P\n" +
            "WHERE F.ID_FILM = FS.ID_FILM\n" +
            "AND S.ID_STARSHIP = FS.ID_STARSHIP\n" +
            "AND PS.ID_STARSHIP = S.ID_STARSHIP\n" +
            "AND PS.ID_PERSON = P.ID_PERSON\n" +
            "AND F.ID_FILM IN (?1)\n" +
            "GROUP BY  S. ID_STARSHIP)\n" +
            "WHERE VECES_APARECE = \n" +
            "(SELECT MAX(VECES_APARECE) FROM \n" +
            "(SELECT COUNT(S.ID_STARSHIP) AS VECES_APARECE, S. ID_STARSHIP FROM FILMS F, FILMS_STARSHIPS FS, STARSHIPS S, PEOPLE_STARSHIPS PS, PEOPLE P\n" +
            "WHERE F.ID_FILM = FS.ID_FILM\n" +
            "AND S.ID_STARSHIP = FS.ID_STARSHIP\n" +
            "AND PS.ID_STARSHIP = S.ID_STARSHIP\n" +
            "AND PS.ID_PERSON = P.ID_PERSON\n" +
            "AND F.ID_FILM IN (?1)\n" +
            "GROUP BY  S. ID_STARSHIP)\n" +
            ")\n" +
            ")\n" +
            "AND F.ID_FILM IN (?1)\n" +
            "GROUP BY  P.ID_PERSON))", nativeQuery = true)
    List<Object[]>  getPersonMaxAparciones(List<Long> filmsSeleccionadas);
}
