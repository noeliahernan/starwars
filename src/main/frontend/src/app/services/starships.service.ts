import { Observable } from 'rxjs';
import { Starship } from './../model/starship';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StarshipsService {
  constructor(private http: HttpClient) { }

  /**
   * Recupera todas las naves espaciales
   */
  public getStarships(): Observable<Starship[]> {
    return this.http.get<Starship[]>('/api/getStarships');
  }

}
