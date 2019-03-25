import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Film } from './../model/film';
import { PeopleService } from './../services/people.service';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  constructor( private _route: ActivatedRoute, private _peopleService: PeopleService) { }
  filmsByPeople: Film[] = [];
  idPerson: number;
  ngOnInit() {
    this.idPerson = this._route.snapshot.params['idPerson'];
    this.load();
  }

  async load(){
    //Cargamos las peliculas de la persona seleccionada
    await this._peopleService.getFilmsByPerson(this.idPerson).subscribe(res => {
      this.filmsByPeople = res;
    });
  }
}
