package com.ejercicio.starwars.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "FILMS")
@Access(AccessType.FIELD)
public class Film{

    @Id
    @Column(name="ID_FILM")
    private Long idFilm;
    @Column(name="TITLE")
    private String title;
    @Column(name="EPISODE_ID")
    private Long episode_id;
    @Column(name="OPENING_CRAWL")
    @Size(max = 10000)
    private String opening_crawl;
    @Column(name="DIRECTOR")
    private String director;
    @Column(name="PRODUCER")
    private String producer;
    @Column(name="RELEASE_DATE")
    private Date release_date;
    @Column(name="CREATED")
    private Date created;
    @Column(name="EDITED")
    private Date edited;
    @Column(name="URL")
    private String url;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "FILMS_PEOPLE",
            joinColumns = @JoinColumn(name = "ID_FILM"),
            inverseJoinColumns = @JoinColumn(name = "ID_PERSON") )
    Set<Person> people;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "FILMS_STARSHIPS",
            joinColumns = @JoinColumn(name = "ID_FILM"),
            inverseJoinColumns = @JoinColumn(name = "ID_STARSHIP"))
    Set<Starship> starshipsFilms;

    public Film() {
    }

    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(Long episode_id) {
        this.episode_id = episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getEdited() {
        return edited;
    }

    public void setEdited(Date edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public Set<Starship> getStarshipsFilms() {
        return starshipsFilms;
    }

    public void setStarshipsFilms(Set<Starship> starshipsFilms) {
        this.starshipsFilms = starshipsFilms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(idFilm, film.idFilm) &&
                Objects.equals(title, film.title) &&
                Objects.equals(episode_id, film.episode_id) &&
                Objects.equals(opening_crawl, film.opening_crawl) &&
                Objects.equals(director, film.director) &&
                Objects.equals(producer, film.producer) &&
                Objects.equals(release_date, film.release_date) &&
                Objects.equals(created, film.created) &&
                Objects.equals(edited, film.edited) &&
                Objects.equals(url, film.url) &&
                Objects.equals(people, film.people) &&
                Objects.equals(starshipsFilms, film.starshipsFilms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, title, episode_id, opening_crawl, director, producer, release_date, created, edited, url, people, starshipsFilms);
    }

    @Override
    public String toString() {
        return "Film{" +
                "idFilm=" + idFilm +
                ", title='" + title + '\'' +
                ", episode_id=" + episode_id +
                ", opening_crawl='" + opening_crawl + '\'' +
                ", director='" + director + '\'' +
                ", producer='" + producer + '\'' +
                ", release_date=" + release_date +
                ", created=" + created +
                ", edited=" + edited +
                ", url='" + url + '\'' +
                ", people=" + people +
                ", starships=" + starshipsFilms +
                '}';
    }
}
