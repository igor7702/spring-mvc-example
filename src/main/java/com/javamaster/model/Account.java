package com.javamaster.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private long amount;

    @ManyToOne
    private User user;

    public Account(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String name) {
        this.name = name;
    }

}
