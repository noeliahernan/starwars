import { StarshipsService } from './services/starships.service';
import { FilmsService } from './services/films.service';
import { PeopleService } from './services/people.service';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FilmsComponent } from './films/films.component';
import { PeopleComponent } from './people/people.component';
import { StarshipsComponent } from './starships/starships.component';
import { PersonComponent } from './person/person.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FilmsComponent,
    PeopleComponent,
    StarshipsComponent,
    PersonComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    PeopleService,
    FilmsService,
    StarshipsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
