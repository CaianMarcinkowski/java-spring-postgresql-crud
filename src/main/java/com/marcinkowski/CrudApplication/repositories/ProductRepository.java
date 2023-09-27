package com.marcinkowski.CrudApplication.repositories;

import com.marcinkowski.CrudApplication.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByActiveTrue();
}
