package com.springdb.mysql.springbootmysql.controller;

import com.springdb.mysql.springbootmysql.model.Product;
import com.springdb.mysql.springbootmysql.service.ProductService;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping(value = "/all")
    public List<Product> findAllProduct() {
        return productService.listAll();
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer Id) {
        try {
            Product product = productService.get(Id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value="/loadData")
    public void loadNewProduct(@RequestBody final Product productInformation ) {
          productService.save(productInformation);
        }


    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
        try {
            Product existProduct = productService.get(id);
            System.out.println("Existing Product"+ existProduct.getId());
            existProduct.setName(product.getName());
            existProduct.setPrice(product.getPrice());
            productService.save(existProduct);


            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
      /**  Delete the Product   **/
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }


    }
