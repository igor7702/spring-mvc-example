package com.javamaster.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "XlsLoadResults1")
public class XlsLoadResults1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Getter
//    @Setter
    private int id;

    @Column
    @Getter
    @Setter
    int position;

    @Column
    @Getter
    @Setter
    long numberpilot;

    @Column
    @Getter
    @Setter
    String namepilot;

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
    int laps;

//    @Column
//    @Getter
//    @Setter
//    String racetime;
//
//    @Column
//    @Getter
//    @Setter
//    String lead;
//
//    @Column
//    @Getter
//    @Setter
//    String gap;
//
//    @Column
//    @Getter
//    @Setter
//    long pitstops;
//
//    @Column
//    @Getter
//    @Setter
//    String crash;
//
//    @Column
//    @Getter
//    @Setter
//    long points;
//
//    @Column
//    @Getter
//    @Setter
//    long country;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "XlsLoadResults1{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", numberPilot='" + numberpilot + '\'' +
                ", namePilot='" + namepilot + '\'' +
                ", team='" + team + '\'' +
                ", motor='" + motor + '\'' +
                ", laps='" + laps + '\'' +
//                ", raceTime='" + racetime + '\'' +
//                ", lead='" + lead + '\'' +
//                ", gap='" + gap + '\'' +
//                ", pitStops='" + pitstops + '\'' +
//                ", crash='" + crash + '\'' +
//                ", points='" + points + '\'' +
//                ", country='" + country + '\'' +
                '}';
    }
}