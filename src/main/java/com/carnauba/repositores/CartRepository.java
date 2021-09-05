package com.carnauba.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carnauba.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>  {

}
