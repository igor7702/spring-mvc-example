package com.javamaster.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "XlsLoadResults1")
public class XlsLoadResults1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Getter
    @Setter
    double position;

    @Column
    @Getter
    @Setter
    double numberPilot;

    @Column
    @Getter
    @Setter
    String namePilot;

    @Column
    @Getter
    @Setter
    String team;

    @Column
    @Getter
    @Setter
    String motor;

    @Column
    @Getter
    @Setter
    double laps;

    @Column
    @Getter
    @Setter
    String raceTime;

    @Column
    @Getter
    @Setter
    String lead;

    @Column
    @Getter
    @Setter
    String gap;

    @Column
    @Getter
    @Setter
    double pitStops;

    @Column
    @Getter
    @Setter
    String crash;

    @Column
    @Getter
    @Setter
    double points;

    @Column
    @Getter
    @Setter
    double country;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "XlsLoadResults1{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", numberPilot='" + numberPilot + '\'' +
                ", namePilot='" + namePilot + '\'' +
                ", team='" + team + '\'' +
                ", motor='" + motor + '\'' +
                ", laps='" + laps + '\'' +
                ", raceTime='" + raceTime + '\'' +
                ", lead='" + lead + '\'' +
                ", gap='" + gap + '\'' +
                ", pitStops='" + pitStops + '\'' +
                ", crash='" + crash + '\'' +
                ", points='" + points + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}