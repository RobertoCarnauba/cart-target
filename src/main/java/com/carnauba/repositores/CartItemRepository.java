package com.carnauba.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carnauba.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>  {

}
