package com.klim.brt.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.mapping.ToOne;

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

    @ManyToOne
    private Status status;

    public Books(String title, String subtitle, int page, String notes, Authors authors, Status status) {
        this.title = title;
        this.subtitle = subtitle;
        this.page = page;
        this.notes = notes;
        this.authors = authors;
        this.status = status;
    }
    public Books() {
    }
}
