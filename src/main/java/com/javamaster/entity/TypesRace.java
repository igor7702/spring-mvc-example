package com.javamaster.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "typesrace")
public class TypesRace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Getter
    @Setter
    private String nametypesrace;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TypesRace{" +
                "id=" + id +
                ", name='" + nametypesrace + '\'' +
                '}';
    }
}

