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

//            country_id_race
//    city_id_race

    @Column
    @Setter
    @Getter
    private String id_race;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + week_race + '\'' +
                ", email='" + year_race + '\'' +
                ", address=" + address +
                '}';
    }
}

