//Seleccionamos el nombre de la persona que más conduce las naves que más aparecen en las películas seleccionadas
SELECT NAME_PERSONA, NAME_STARSHIP FROM 
	(SELECT COUNT(P.ID_PERSON) AS TOTAL_APARICIONES,  P.NAME AS NAME_PERSONA, S.NAME AS NAME_STARSHIP FROM PEOPLE P, PEOPLE_STARSHIPS PS, STARSHIPS S, FILMS_PEOPLE FP, FILMS F
	WHERE P.ID_PERSON = PS.ID_PERSON
	AND S.ID_STARSHIP = PS.ID_STARSHIP
	AND P.ID_PERSON = FP.ID_PERSON
	AND F.ID_FILM = FP.ID_FILM
	AND S.ID_STARSHIP IN 
		(SELECT ID_STARSHIP FROM 
			(SELECT COUNT(S.ID_STARSHIP) AS VECES_APARECE, S.ID_STARSHIP AS ID_STARSHIP FROM FILMS F, FILMS_STARSHIPS FS, STARSHIPS S, PEOPLE_STARSHIPS PS, PEOPLE P
			WHERE F.ID_FILM = FS.ID_FILM
			AND S.ID_STARSHIP = FS.ID_STARSHIP
			AND PS.ID_STARSHIP = S.ID_STARSHIP
			AND PS.ID_PERSON = P.ID_PERSON
			AND F.ID_FILM IN (1,2)
			GROUP BY  S. ID_STARSHIP)
		WHERE VECES_APARECE = 
			(SELECT MAX(VECES_APARECE) FROM 
				(SELECT COUNT(S.ID_STARSHIP) AS VECES_APARECE, S. ID_STARSHIP FROM FILMS F, FILMS_STARSHIPS FS, STARSHIPS S, PEOPLE_STARSHIPS PS, PEOPLE P
				WHERE F.ID_FILM = FS.ID_FILM
				AND S.ID_STARSHIP = FS.ID_STARSHIP
				AND PS.ID_STARSHIP = S.ID_STARSHIP
				AND PS.ID_PERSON = P.ID_PERSON
				AND F.ID_FILM IN  (1,2)
				GROUP BY  S. ID_STARSHIP)
			)
		)
	AND F.ID_FILM IN  (1,2)
	GROUP BY  P.ID_PERSON)
//Condición que el total de apariciones del piloto de las naves que más salen sean igual al máximo de apariciones de esos pilotos para esas naves
	WHERE TOTAL_APARICIONES =
	(SELECT MAX(TOTAL_APARICIONES) FROM (
		SELECT COUNT(P.ID_PERSON) AS TOTAL_APARICIONES FROM PEOPLE P, PEOPLE_STARSHIPS PS, STARSHIPS S, FILMS_PEOPLE FP, FILMS F
		WHERE P.ID_PERSON = PS.ID_PERSON
		AND S.ID_STARSHIP = PS.ID_STARSHIP
		AND P.ID_PERSON = FP.ID_PERSON
		AND F.ID_FILM = FP.ID_FILM
		AND S.ID_STARSHIP IN 
		//Selecciona las naves que más aparecen en las películas seleccionadas
			(SELECT ID_STARSHIP FROM 
				(SELECT COUNT(S.ID_STARSHIP) AS VECES_APARECE, S.ID_STARSHIP AS ID_STARSHIP FROM FILMS F, FILMS_STARSHIPS FS, STARSHIPS S, PEOPLE_STARSHIPS PS, PEOPLE P
				WHERE F.ID_FILM = FS.ID_FILM
				AND S.ID_STARSHIP = FS.ID_STARSHIP
				AND PS.ID_STARSHIP = S.ID_STARSHIP
				AND PS.ID_PERSON = P.ID_PERSON
				AND F.ID_FILM IN (1,2)
				GROUP BY  S. ID_STARSHIP)
			WHERE VECES_APARECE = 
			//Recupera el número de veces que sale la que más sale
				(SELECT MAX(VECES_APARECE) FROM 
					(SELECT COUNT(S.ID_STARSHIP) AS VECES_APARECE, S. ID_STARSHIP FROM FILMS F, FILMS_STARSHIPS FS, STARSHIPS S, PEOPLE_STARSHIPS PS, PEOPLE P
					WHERE F.ID_FILM = FS.ID_FILM
					AND S.ID_STARSHIP = FS.ID_STARSHIP
					AND PS.ID_STARSHIP = S.ID_STARSHIP
					AND PS.ID_PERSON = P.ID_PERSON
					AND F.ID_FILM IN (1,2)
					GROUP BY  S. ID_STARSHIP)
				)
			)
	AND F.ID_FILM IN (1,2)
	GROUP BY  P.ID_PERSON))