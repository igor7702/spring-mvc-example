package com.javamaster.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Setter
    @Getter
    private String code;

    @Column
    @Setter
    @Getter
    private Date date;

    @Column
    @Setter
    @Getter
    private String text;

    @Column
    @Setter
    @Getter
    private Integer grade;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}

    //book_id INTEGER,