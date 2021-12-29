package com.javamaster.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id")
    private Races races;

    @Column
    @Setter
    @Getter
    private String race_name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_race_id")
    private TypesRace typesrace;

    @Column
    @Setter
    @Getter
    private String type_race_namе;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Teams teams;

    @Column
    @Setter
    @Getter
    private String team_name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pilot_id")
    private Pilots pilots;

    @Column
    @Setter
    @Getter
    private String pilot_name;

    @Column
    @Setter
    @Getter
    private int laps;

    @Column
    @Setter
    @Getter
    private boolean bestlap;

    @Column
    @Setter
    @Getter
    private int start_grid;

    @Column
    @Setter
    @Getter
    private int end_grid;

    @Column
    @Setter
    @Getter
    private int points_pilot;

    @Column
    @Setter
    @Getter
    private int points_pilot_all;

    @Column
    @Setter
    @Getter
    private int points_team;

    @Column
    @Setter
    @Getter
    private int points_team_all;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Races getRaces() {
        return races;
    }
    public void setRaces(Races races) {
        this.races = races;
    }

    public Teams getTeams() {
        return teams;
    }
    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public Pilots getPilots() {
        return pilots;
    }
    public void setPilots(Pilots pilots) {
        this.pilots = pilots;
    }

    public TypesRace getTypesrace() { return typesrace; }
    public void setTypesrace(TypesRace typesrace) {
        this.typesrace = typesrace;
    }

    @Override
    public String toString() {
        return "Results{" +
                "id=" + id +
                ", race_id='" + races + '\'' +
                ", race_name='" + race_name + '\'' +
                ", type_race_id='" + typesrace + '\'' +
                ", type_race_namе='" + type_race_namе + '\'' +
                ", teams_id='" + teams + '\'' +
                ", team_name='" + team_name + '\'' +
                ", pilots_id='" + pilots + '\'' +
                ", pilot_name='" + pilot_name + '\'' +
                ", laps='" + laps + '\'' +
                ", bestlap='" + bestlap + '\'' +
                ", start_grid='" + start_grid + '\'' +
                ", end_grid='" + end_grid + '\'' +
                '}';
    }
}

