import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FilmsComponent } from './films/films.component';
import { PeopleComponent } from './people/people.component';
import { PersonComponent } from './person/person.component';
import { StarshipsComponent } from './starships/starships.component';

const routes: Routes = [
  {path: '', redirectTo: '/films', pathMatch: 'full'},
  {path: 'films', component: FilmsComponent},
  {path: 'starships', component: StarshipsComponent},
  {path: 'people', component: PeopleComponent},
  {path: 'detallPerson/:idPerson', component: PersonComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
