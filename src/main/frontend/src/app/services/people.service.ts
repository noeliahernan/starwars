import { Film } from './../model/film';
import { Observable } from 'rxjs';
import { Person } from './../model/person';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {
  constructor(private http: HttpClient) { }

  /**
   * Recupera todos los personajes
   */
  public getPeople(): Observable<Person[]> {
    return this.http.get<Person[]>('/api/getPeople');
  }
  
  /**
   * Recupera las películas por identificador de persona
   * @param idPerson 
   */
  public getFilmsByPerson(idPerson: number): Observable<Film[]> {
    return this.http.get<Film[]>('/api/getFilmsByPerson/' + idPerson);
  }
}
