package com.javamaster.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pilots")
public class Pilots {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Getter
    @Setter
    private String name_pilots;

    @Column
    @Getter
    @Setter
    private int code_pilots;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pilots{" +
                "id=" + id +
                ", name='" + name_pilots + '\'' +
                ", code='" + code_pilots + '\'' +
                '}';
    }
}

