package com.ejercicio.starwars.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PEOPLE")
@Access(AccessType.FIELD)
public class Person {
    @Id
    @Column(name="ID_PERSON")
    Long idPerson;
    @Column(name="NAME")
    String name;
    @Column(name="HEIGHT")
    String height;
    @Column(name="MASS")
    String mass;
    @Column(name="HAIR_COLOR")
    String hair_color;
    @Column(name="SKIN_COLOR")
    String skin_color;
    @Column(name="EYE_COLOR")
    String eye_color;
    @Column(name="BIRTH_YEAR")
    String birth_year;
    @Column(name="GENDER")
    String gender;
    @Column(name="HOMEWORLD")
    String homeworld;
    @Column(name="CREATED")
    Date created;
    @Column(name="EDITED")
    Date edited;
    @Column(name="URL")
    String url;
    public Long getIdPerson() {
        return idPerson;
    }
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "PEOPLE_STARSHIPS",
            joinColumns = @JoinColumn(name = "ID_PERSON"),
            inverseJoinColumns = @JoinColumn(name = "ID_STARSHIP"))
    Set<Starship> starshipsPeople;
    Long countPerson;

    public Person(Object o) {
    }

    public Person() {
    }


    public Person(Long idPerson, String name, String height, String mass, String hair_color, String skin_color, String eye_color, String birth_year, String gender, String homeworld, Date created, Date edited, String url, Set<Starship> starshipsPeople, Long countPerson) {
        this.idPerson = idPerson;
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld = homeworld;
        this.created = created;
        this.edited = edited;
        this.url = url;
        this.starshipsPeople = starshipsPeople;
        this.countPerson = countPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
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

    public Set<Starship> getStarshipsPeople() {
        return starshipsPeople;
    }

    public void setStarshipsPeople(Set<Starship> starshipsPeople) {
        this.starshipsPeople = starshipsPeople;
    }

    public Long getCountPerson() {
        return countPerson;
    }

    public void setCountPerson(Long countPerson) {
        this.countPerson = countPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(idPerson, person.idPerson) &&
                Objects.equals(name, person.name) &&
                Objects.equals(height, person.height) &&
                Objects.equals(mass, person.mass) &&
                Objects.equals(hair_color, person.hair_color) &&
                Objects.equals(skin_color, person.skin_color) &&
                Objects.equals(eye_color, person.eye_color) &&
                Objects.equals(birth_year, person.birth_year) &&
                Objects.equals(gender, person.gender) &&
                Objects.equals(homeworld, person.homeworld) &&
                Objects.equals(created, person.created) &&
                Objects.equals(edited, person.edited) &&
                Objects.equals(url, person.url) &&
                Objects.equals(starshipsPeople, person.starshipsPeople) &&
                Objects.equals(countPerson, person.countPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, name, height, mass, hair_color, skin_color, eye_color, birth_year, gender, homeworld, created, edited, url, starshipsPeople, countPerson);
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                ", hair_color='" + hair_color + '\'' +
                ", skin_color='" + skin_color + '\'' +
                ", eye_color='" + eye_color + '\'' +
                ", birth_year='" + birth_year + '\'' +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", created=" + created +
                ", edited=" + edited +
                ", url='" + url + '\'' +
                ", starshipsPeople=" + starshipsPeople +
                ", countPerson=" + countPerson +
                '}';
    }
}
