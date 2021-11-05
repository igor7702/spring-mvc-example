package com.javamaster.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Setter
    @Getter
    private String code_country;

    @Column
    private String name_country;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName_country() {
        return name_country;
    }
    public void setName_country(String country) {
        this.name_country = country;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", code='" + code_country + '\'' +
                ", name='" + name_country + '\'' +
                '}';
    }
}

