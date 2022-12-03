package com.klim.brt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data //getter,setter, constructor, equals, hashcode
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name_author;

    public Authors(String name_author) {
        this.name_author = name_author;
    }

    public Authors() {
    }
}
