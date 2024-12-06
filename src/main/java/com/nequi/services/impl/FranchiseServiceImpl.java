package com.nequi.services.impl;

import com.nequi.dto.FranchiseDTO;
import com.nequi.model.Franchise;
import com.nequi.model.Response;
import com.nequi.repository.FranchiseRepository;
import com.nequi.repository.SucursalRepository;
import com.nequi.services.IFranchiseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FranchiseServiceImpl implements IFranchiseService {

    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }
    @Transactional
    public Response getFranchises() {
        List<Franchise> franchises = franchiseRepository.findAll();
        return new Response(franchises, "Franchises retrieved successfully", false);
    }

    public Response getFranchiseById(Long id) {
        Optional<Franchise> franchiseOptional = franchiseRepository.findById(id);
        if (franchiseOptional.isPresent()) {
            return new Response(Collections.singletonList(franchiseOptional.get()));
        }
        return new Response(true, "Franchise not found");
    }

    /**
     * Method to add a franchise
     * @param franchiseDTO
     * @return Response indicating the result of the operation
     */
    public Response addFranchise(FranchiseDTO franchiseDTO) {
        Franchise franchise = new Franchise();
        franchise.setName(franchiseDTO.getName());
        franchiseRepository.save(franchise);
        return new Response("Franchise added successfully");
    }

    public Response updateFranchise(Long id, FranchiseDTO franchiseDTO) {
        Optional<Franchise> franchiseOptional = franchiseRepository.findById(id);
        if (franchiseOptional.isPresent()) {
            Franchise existingFranchise = franchiseOptional.get();
            existingFranchise.setName(franchiseDTO.getName());
            franchiseRepository.save(existingFranchise);
            return new Response("Franchise updated successfully");
        }
        return new Response(true, "Franchise not found");
    }


}
