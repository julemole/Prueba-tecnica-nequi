package com.nequi.services.impl;

import com.nequi.dto.SucursalDTO;
import com.nequi.model.Franchise;
import com.nequi.model.Response;
import com.nequi.model.Sucursal;
import com.nequi.repository.FranchiseRepository;
import com.nequi.repository.SucursalRepository;
import com.nequi.services.ISucursalService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class SucursalServiceImpl implements ISucursalService {

    private final SucursalRepository sucursalRepository;
    private final FranchiseRepository franchiseRepository;

    public SucursalServiceImpl(SucursalRepository sucursalRepository, FranchiseRepository franchiseRepository) {
        this.sucursalRepository = sucursalRepository;
        this.franchiseRepository = franchiseRepository;
    }

    public Response getSucursalesByFranchise(Long franchiseId) {
        List<Sucursal> sucursales = sucursalRepository.findByFranchiseId(franchiseId);
        return new Response(sucursales, "Sucursales retrieved successfully", false);
    }

    public Response getSucursalById(Long id) {
        Optional<Sucursal> sucursalOptional = sucursalRepository.findById(id);
        if (sucursalOptional.isPresent()) {
            return new Response(Collections.singletonList(sucursalOptional.get()), "Sucursal found", false);
        }
        return new Response(true, "Sucursal not found");
    }

    public Response addSucursal(SucursalDTO sucursalDTO, Long franchiseId) {
        Optional<Franchise> franchiseOptional = franchiseRepository.findById(franchiseId);
        if (!franchiseOptional.isPresent()) {
            return new Response(true, "Franchise not found");
        }

        Sucursal sucursal = new Sucursal(sucursalDTO, franchiseOptional.get());
        sucursalRepository.save(sucursal);

        return new Response("Sucursal added successfully");
    }

    public Response updateSucursal(Long id, SucursalDTO sucursalDTO) {
        Optional<Sucursal> sucursalOptional = sucursalRepository.findById(id);
        if (sucursalOptional.isPresent()) {
            Sucursal existingSucursal = sucursalOptional.get();
            existingSucursal.setName(sucursalDTO.getName());
            sucursalRepository.save(existingSucursal);
            return new Response("Sucursal updated successfully");
        }
        return new Response(true, "Sucursal not found");
    }
}
