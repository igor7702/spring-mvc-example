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
    private String codeCountry;

    @Column
    private String nameCountry;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return nameCountry;
    }
    public void setName(String street) {
        this.nameCountry = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", code='" + codeCountry + '\'' +
                ", name='" + nameCountry + '\'' +
                '}';
    }
}

