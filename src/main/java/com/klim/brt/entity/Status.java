package com.klim.brt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data //getter,setter, constructor, equals, hashcode
@AllArgsConstructor
@NoArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name_status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private List<Status> statusList;

    public Status(String name_status) {
        this.name_status = name_status;
    }
}
