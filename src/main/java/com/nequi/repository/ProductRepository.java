package com.nequi.repository;

import com.nequi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ProductRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findBySucursalId(Long sucursalId);
}
