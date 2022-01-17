package com.javamaster.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "csvloadpilots1")
public class CsvLoadPilots1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Getter
    @Setter
    private String namepilotrus;

    @Column
    @Getter
    @Setter
    private String codepiloteng;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "csvloadpilots1{" +
                "id=" + id +
                ", namepilotrus='" + namepilotrus + '\'' +
                ", codepiloteng='" + codepiloteng + '\'' +
                '}';
    }
}

