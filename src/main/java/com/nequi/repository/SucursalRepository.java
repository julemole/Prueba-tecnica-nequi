package com.nequi.repository;

import com.nequi.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "SucursalRepository")
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    List<Sucursal> findByFranchiseId(Long franchiseId);
}
