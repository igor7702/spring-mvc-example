package com.javamaster.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Getter
    @Setter
    private String name_teams;

    @Column
    @Getter
    @Setter
    private int year_teams;

    @Column
    @Getter
    @Setter
    private String code_teams;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "id=" + id +
                ", name='" + name_teams + '\'' +
                ", year='" + year_teams + '\'' +
                ", code='" + code_teams + '\'' +
                '}';
    }
}

