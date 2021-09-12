package com.carnauba.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carnauba.entities.Cart;
import com.carnauba.entities.CartItem;
import com.carnauba.entities.Product;
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
	
	@PostMapping(value = "/{id}/{quantity}")
	public ResponseEntity<CartItem> insert(@PathVariable Long id, Integer quantity, @ModelAttribute CartItem prodId){
		prodId = service.inset(prodId ,id ,quantity);
		 return ResponseEntity.ok().body(prodId);
	}

}
