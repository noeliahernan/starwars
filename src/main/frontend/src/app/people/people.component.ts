import { Router } from '@angular/router';
import { PeopleService } from './../services/people.service';
import { Person } from './../model/person';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.css']
})
export class PeopleComponent implements OnInit {

  constructor(private peopleService: PeopleService, private _router: Router) {

  }
  people: Person[];
  ngOnInit() {
    this.loadPeople();
  }

  /**
   * Carga el listado de personajes
   */
  private loadPeople(){
    this.peopleService.getPeople().subscribe(res => {
      this.people = res;
    });
  }

  /**
   * Nos redirige a otra pantalla para mostrarnos las películas en las que aparece el personaje seleccionado
   * @param person 
   */
  public detall(person: Person) {
    console.log(person.idPerson);
    console.log(this._router);
    this._router.navigate(['detallPerson', person.idPerson]);
  }
}
