package com.javamaster.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    @OneToMany(mappedBy = "user")
    private Set<Account> accounts;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

}
