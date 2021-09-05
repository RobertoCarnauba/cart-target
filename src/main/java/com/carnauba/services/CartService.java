package com.carnauba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carnauba.entities.Cart;
import com.carnauba.repositores.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository repository;
	
	public List<Cart> findAll(){
		return repository.findAll();
	}
	
	public Cart findById(Long id) {
		Optional<Cart> obj = repository.findById(id);
		return obj.get();
	}
}
