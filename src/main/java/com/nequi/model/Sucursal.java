package com.nequi.model;

import com.nequi.dto.SucursalDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


@Entity
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "sucursal", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> productList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    public Sucursal() {}

    public Sucursal(SucursalDTO sucursalDTO, Franchise franchise) {
        this.name = sucursalDTO.getName();
        this.franchise = franchise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }
}

