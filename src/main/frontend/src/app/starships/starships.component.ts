import { StarshipsService } from './../services/starships.service';
import { Starship } from './../model/starship';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-starships',
  templateUrl: './starships.component.html',
  styleUrls: ['./starships.component.css']
})
export class StarshipsComponent implements OnInit {

  starships: Starship[];
  constructor(private starshipService:StarshipsService) { }

  ngOnInit() {
    this.loadStarships();
  }

  /**
   * Carga el listado de naves espaciales
   */
  private loadStarships(){
    this.starshipService.getStarships().subscribe(res => {
      this.starships = res;
    });
  }

}
