package com.carnauba.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carnauba.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>  {

}
