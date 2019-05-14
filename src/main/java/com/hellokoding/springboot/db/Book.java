package com.hellokoding.springboot.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Book")
public class Book {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name="title")
    private String title;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}