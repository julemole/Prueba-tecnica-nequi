package com.nequi.services;

import com.nequi.dto.ProductDTO;
import com.nequi.model.Response;

public interface IProductService {
    public abstract Response getAllProducts();
    public abstract Response getProductById(Long id);
    public abstract Response getProductsBySucursalId(Long sucursalId);
    public abstract Response addProduct(ProductDTO productDTO, Long sucursalId);
    public abstract Response updateProduct(Long id, ProductDTO productDTO);
    public abstract Response updateProductStock(Long id, Long stock);
    public abstract Response deleteProduct(Long id);
}
