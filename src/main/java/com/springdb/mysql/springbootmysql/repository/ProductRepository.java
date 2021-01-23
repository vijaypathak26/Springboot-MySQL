package com.springdb.mysql.springbootmysql.repository;

import com.springdb.mysql.springbootmysql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
