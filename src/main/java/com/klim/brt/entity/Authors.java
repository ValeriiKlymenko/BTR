package com.klim.brt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data //getter,setter, constructor, equals, hashcode
@AllArgsConstructor
@NoArgsConstructor
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name_author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "authors_id")
    private List<Books> booksList;

    public Authors(String name_author) {
        this.name_author = name_author;
    }

}
