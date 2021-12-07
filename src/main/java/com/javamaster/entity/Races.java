package com.javamaster.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "races")
public class Races {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Setter
    @Getter
    private String week_race;

    @Column
    @Setter
    @Getter
    private String year_race;

    @Column
    @Setter
    @Getter
    private String country_name_race;

    @Column
    @Setter
    @Getter
    private String city_name_race;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id_race")
    private Countries countries;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id_race")
    private Cities cities;

    @Column
    @Setter
    @Getter
    private String id_race;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Cities getCities() {
        return cities;
    }
    public void setCities(Cities cities) {
        this.cities = cities;
    }

    public Countries getCountries() {
        return countries;
    }
    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "Races{" +
                "id=" + id +
                ", week_race='" + week_race + '\'' +
                ", year_race='" + year_race + '\'' +
                ", country_name_race='" + country_name_race + '\'' +
                ", city_name_race='" + city_name_race + '\'' +
                ", id_race='" + id_race + '\'' +
                '}';
    }
}

