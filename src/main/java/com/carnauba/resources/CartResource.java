package com.carnauba.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carnauba.entities.Cart;
import com.carnauba.services.CartService;

@RestController
@RequestMapping(value="/carts")
public class CartResource {
	
	@Autowired
	private CartService service;
	
	@GetMapping
	public ResponseEntity<List<Cart>> findAll(){
		List<Cart> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cart> findById(@PathVariable Long id){
		Cart obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
