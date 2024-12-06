package com.nequi.repository;

import com.nequi.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository(value = "FranchiseRepository")
public interface FranchiseRepository extends JpaRepository<Franchise, Long> {
}
