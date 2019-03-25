import { Film } from './../model/film';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmsService {
  constructor(private http: HttpClient) { }

  /**
   * Recupera todas las películas
   */
  public getFilms(): Observable<Film[]> {
    return this.http.get<Film[]>('/api/getFilms');
  }

  /**
   * Recupera las personas o persona que mas conduce la nave que más aparecen en las películas
   * @param filmsSelected 
   */
  public getPeopleMaxApaByFilm(filmsSelected: number[]): Observable<any> {
    return this.http.post('/api/getPeopleMaxApaByFilm', filmsSelected);
  }

}
