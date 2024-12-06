package com.nequi.services;

import com.nequi.dto.FranchiseDTO;
import com.nequi.model.Response;

public interface IFranchiseService {
    public abstract Response getFranchises();
    public abstract Response getFranchiseById(Long id);
    public abstract Response addFranchise(FranchiseDTO franchiseDTO);
    public abstract Response updateFranchise(Long id, FranchiseDTO franchiseDTO);
}
