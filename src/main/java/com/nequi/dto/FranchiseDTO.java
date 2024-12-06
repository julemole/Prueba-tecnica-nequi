package com.nequi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FranchiseDTO {
    private Long id;
    private String name;
    private List<SucursalDTO> sucursalList;

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

    public List<SucursalDTO> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<SucursalDTO> sucursalList) {
        this.sucursalList = sucursalList;
    }
}
