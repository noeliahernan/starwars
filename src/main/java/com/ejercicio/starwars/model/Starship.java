package com.ejercicio.starwars.model;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "STARSHIPS")
@Access(AccessType.FIELD)
public class Starship {

    @Id
    @Column(name="ID_STARSHIP")
    private Long idStarship;
    @Column(name="NAME")
    private String name;
    @Column(name="MODEL")
    private String model;
    @Column(name="MANUFACTURER")
    private String manufacturer;
    @Column(name="COST_IN_CREDITS")
    private String cost_in_credits;
    @Column(name="LENGTH")
    private String length;
    @Column(name="MAX_ATMOSPHERING_SPEED")
    private String max_atmosphering_speed;
    @Column(name="CREW")
    private String crew;
    @Column(name="PASSENGERS")
    private String passengers;
    @Column(name="CARGO_CAPACITY")
    private String cargo_capacity;
    @Column(name="CONSUMABLES")
    private String consumables;
    @Column(name="HYPERDRIVE_RATING")
    private String hiperdrive_rating;
    @Column(name="MGLT")
    private String mglt;
    @Column(name="STARSHIP_CLASS")
    private String starship_class;
    @Column(name="CREATED")
    private Date created;
    @Column(name="EDITED")
    private Date edited;
    @Column(name="URL")
    private String url;

    public Long getIdStarship() {
        return idStarship;
    }

    public void setIdStarship(Long idStarship) {
        this.idStarship = idStarship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMax_atmosphering_speed() {
        return max_atmosphering_speed;
    }

    public void setMax_atmosphering_speed(String max_atmosphering_speed) {
        this.max_atmosphering_speed = max_atmosphering_speed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargo_capacity() {
        return cargo_capacity;
    }

    public void setCargo_capacity(String cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHiperdrive_rating() {
        return hiperdrive_rating;
    }

    public void setHiperdrive_rating(String hiperdrive_rating) {
        this.hiperdrive_rating = hiperdrive_rating;
    }

    public String getMglt() {
        return mglt;
    }

    public void setMglt(String mglt) {
        this.mglt = mglt;
    }

    public String getStarship_class() {
        return starship_class;
    }

    public void setStarship_class(String starship_class) {
        this.starship_class = starship_class;
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

    public Starship() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Starship starship = (Starship) o;
        return Objects.equals(idStarship, starship.idStarship) &&
                Objects.equals(name, starship.name) &&
                Objects.equals(model, starship.model) &&
                Objects.equals(manufacturer, starship.manufacturer) &&
                Objects.equals(cost_in_credits, starship.cost_in_credits) &&
                Objects.equals(length, starship.length) &&
                Objects.equals(max_atmosphering_speed, starship.max_atmosphering_speed) &&
                Objects.equals(crew, starship.crew) &&
                Objects.equals(passengers, starship.passengers) &&
                Objects.equals(cargo_capacity, starship.cargo_capacity) &&
                Objects.equals(consumables, starship.consumables) &&
                Objects.equals(hiperdrive_rating, starship.hiperdrive_rating) &&
                Objects.equals(mglt, starship.mglt) &&
                Objects.equals(starship_class, starship.starship_class) &&
                Objects.equals(created, starship.created) &&
                Objects.equals(edited, starship.edited) &&
                Objects.equals(url, starship.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStarship, name, model, manufacturer, cost_in_credits, length, max_atmosphering_speed, crew, passengers, cargo_capacity, consumables, hiperdrive_rating, mglt, starship_class, created, edited, url);
    }

    @Override
    public String toString() {
        return "Starship{" +
                "idStarship=" + idStarship +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cost_in_credits='" + cost_in_credits + '\'' +
                ", length='" + length + '\'' +
                ", max_atmosphering_speed='" + max_atmosphering_speed + '\'' +
                ", crew='" + crew + '\'' +
                ", passengers='" + passengers + '\'' +
                ", cargo_capacity='" + cargo_capacity + '\'' +
                ", consumables='" + consumables + '\'' +
                ", hiperdrive_rating='" + hiperdrive_rating + '\'' +
                ", mglt='" + mglt + '\'' +
                ", starship_class='" + starship_class + '\'' +
                ", created=" + created +
                ", edited=" + edited +
                ", url='" + url + '\'' +
                '}';
    }
}
