package com.nequi.services;

import com.nequi.dto.SucursalDTO;
import com.nequi.model.Response;

public interface ISucursalService {
    public abstract Response getSucursalesByFranchise(Long franchiseId);
    public abstract Response getSucursalById(Long id);
    public abstract Response addSucursal(SucursalDTO sucursalDTO, Long franchiseId);
    public abstract Response updateSucursal(Long id, SucursalDTO sucursalDTO);
}
