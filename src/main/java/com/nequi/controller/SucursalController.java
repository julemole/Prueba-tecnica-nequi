package com.nequi.controller;

import com.nequi.dto.SucursalDTO;
import com.nequi.model.Response;
import com.nequi.services.ISucursalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    private ISucursalService sucursalService;

    public SucursalController(ISucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping("/franchise/{franchiseId}")
    public Response getSucursalesByFranchise(@PathVariable Long franchiseId) {
        Response result = sucursalService.getSucursalesByFranchise(franchiseId);
        return result;
    }

    @GetMapping("/{id}")
    public Response getSucursal(@PathVariable Long id) {
        Response result = sucursalService.getSucursalById(id);
        return result;
    }

    @PostMapping("/{franchiseId}")
    public Response addSucursal(@RequestBody SucursalDTO sucursalDTO, @PathVariable Long franchiseId) {
        Response result = sucursalService.addSucursal(sucursalDTO, franchiseId);
        return result;
    }

    @PutMapping("/{id}")
    public Response updateSucursal(@PathVariable Long id, @RequestBody SucursalDTO sucursalDTO) {
        Response result = sucursalService.updateSucursal(id, sucursalDTO);
        return result;
    }

}
