package com.nequi.controller;

import com.nequi.dto.ProductDTO;
import com.nequi.model.Response;
import com.nequi.services.IProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Response getAllProducts() {
        Response result = productService.getAllProducts();
        return result;
    }

    @GetMapping("/{id}")
    public Response getProductById(Long id) {
        Response result = productService.getProductById(id);
        return result;
    }

    @GetMapping("/sucursal/{sucursalId}")
    public Response getProductsBySucursalId(Long sucursalId) {
        Response result = productService.getProductsBySucursalId(sucursalId);
        return result;
    }

    @PostMapping("/{sucursalId}")
    public Response addProduct(@RequestBody ProductDTO productDTO, @PathVariable Long sucursalId) {
        Response result = productService.addProduct(productDTO, sucursalId);
        return result;
    }

    @PutMapping("/{id}")
    public Response updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Response result = productService.updateProduct(id, productDTO);
        return result;
    }

    @PatchMapping("/{id}")
    public Response updateProductStock(@PathVariable Long id, @RequestBody Long stock) {
        Response result = productService.updateProductStock(id, stock);
        return result;
    }

    @DeleteMapping("/{id}")
    public Response deleteProduct(@PathVariable Long id) {
        Response result = productService.deleteProduct(id);
        return result;
    }


}
