package com.nequi.controller;

import com.nequi.dto.FranchiseDTO;
import com.nequi.model.Response;
import com.nequi.services.IFranchiseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/franchise")
public class FranchiseController {

    private IFranchiseService franchiseService;

    public FranchiseController(IFranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping
    public Response allFranchises() {
        Response result = franchiseService.getFranchises();
        return result;
    }

    @GetMapping("/{id}")
    public Response getFranchise(@PathVariable Long id) {
        Response result = franchiseService.getFranchiseById(id);
        return result;
    }

    @PostMapping
    public Response addFranchise(@RequestBody FranchiseDTO franchiseDTO ) {
        Response result = franchiseService.addFranchise(franchiseDTO);
        return result;
    }

    @PutMapping("/{id}")
    public Response updateFranchise(@PathVariable Long id, @RequestBody FranchiseDTO franchiseDTO) {
        Response result = franchiseService.updateFranchise(id, franchiseDTO);
        return result;
    }
}
