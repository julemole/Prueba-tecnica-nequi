package com.nequi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "franchise")
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "franchise", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Sucursal> sucursalList;

    public Franchise() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

