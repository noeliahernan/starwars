import { Film } from './../model/film';
import { FilmsService } from './../services/films.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-films',
  templateUrl: './films.component.html',
  styleUrls: ['./films.component.css']
})
export class FilmsComponent implements OnInit {

  constructor(private filmsService: FilmsService) { }
  multiSelect: boolean = false;
  error: string;
  films: Film[];
  maxAparList: string[] = [];
  filmsSelected: number[] = [];
  ngOnInit() {
    this.loadFilms();
  }

  private loadFilms(){
    this.filmsService.getFilms().subscribe(res => {
      this.films = res;
      console.log(res);
    });
  }

  getMaxApariciones() {
    this.error = null
    this.maxAparList = [];
    if(this.filmsSelected.length > 0){
      console.log(this.filmsSelected);
    this.filmsService.getPeopleMaxApaByFilm(this.filmsSelected).subscribe(res => {
      res.forEach(object => {
        this.maxAparList.push(object);
    });
    });
  } else{
    this.error = 'Debe seleccionar alguna película';
  }
  }
  onCheckboxStateChange(changeEvent: any, id: number) {
    if(changeEvent.target.checked){
      this.filmsSelected.push(id);
    } else {
      this.filmsSelected.splice(this.filmsSelected.indexOf(id), 1);
    }
  }

  onCheckboxAll(changeEvent: any) {
    this.multiSelect = !this.multiSelect
    if(changeEvent.target.checked){
      this.films.forEach(film => this.filmsSelected.push(film.idFilm))
    } else {
     this.filmsSelected = [];
    }
  }
}