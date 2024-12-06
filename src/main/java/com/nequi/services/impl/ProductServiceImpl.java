package com.nequi.services.impl;

import com.nequi.dto.ProductDTO;
import com.nequi.model.Product;
import com.nequi.model.Response;
import com.nequi.model.Sucursal;
import com.nequi.repository.ProductRepository;
import com.nequi.repository.SucursalRepository;
import com.nequi.services.IProductService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final SucursalRepository sucursalRepository;

    public ProductServiceImpl(ProductRepository productRepository, SucursalRepository sucursalRepository) {
        this.productRepository = productRepository;
        this.sucursalRepository = sucursalRepository;
    }

    public Response getAllProducts() {
        List<Product> products = productRepository.findAll();
        return new Response(products, "Products retrieved successfully", false);
    }

    public Response getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return new Response(Collections.singletonList(productOptional.get()), "Product found", false);
        }
        return new Response(true, "Product not found");
    }

    public Response getProductsBySucursalId(Long sucursalId) {
        List<Product> products = productRepository.findBySucursalId(sucursalId);
        return new Response(products, "Products retrieved successfully", false);
    }

    public Response addProduct(ProductDTO productDTO, Long sucursalId) {
        Optional<Sucursal> sucursalOptional = sucursalRepository.findById(sucursalId);
        if (sucursalOptional.isPresent()) {
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setStock(productDTO.getStock());
            productRepository.save(product);
            return new Response("Product added successfully");
        }
        return new Response(true, "Sucursal not found");
    }

    public Response updateProduct(Long id, ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDTO.getName());
            product.setStock(productDTO.getStock());
            productRepository.save(product);
            return new Response("Product updated successfully");
        }
        return new Response(true, "Product not found");
    }

    public Response updateProductStock(Long id, Long stock) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setStock(stock);
            productRepository.save(product);
            return new Response("Product stock updated successfully");
        }
        return new Response(true, "Product not found");
    }

    public Response deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return new Response("Product deleted successfully");
        }
        return new Response(true, "Product not found");
    }
}
