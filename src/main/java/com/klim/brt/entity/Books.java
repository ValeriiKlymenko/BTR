package com.klim.brt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data //getter,setter, constructor, equals, hashcode
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String subtitle;
    private int page;
    private String notes;
//    private Image image;
//    private Data start;
//    private Data finished;
    @ManyToOne
    private Authors authors;

    @OneToOne
    private Status status;

}
