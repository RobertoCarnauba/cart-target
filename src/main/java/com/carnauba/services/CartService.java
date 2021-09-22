package com.carnauba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carnauba.entities.Cart;
import com.carnauba.entities.CartItem;
import com.carnauba.entities.Product;
import com.carnauba.repositores.CartItemRepository;
import com.carnauba.repositores.CartRepository;
import com.carnauba.repositores.ProductRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	public List<Cart> findAll() {
		return repository.findAll();
	}

	public Cart findById(Long id) {
		Optional<Cart> obj = repository.findById(id);
		return obj.get();
	}

	public CartItem inset(CartItem obj, Long id, Integer quantity) {

		Cart cart = new Cart();// (id, moment);
		repository.save(cart);
		Product product = productRepository.getById(id);
		System.out.println(product.getName());
		System.out.println(cart.getId());
		CartItem cartItem = new CartItem(); // (cart, product, quantity, product.getPrice());
		cartItemRepository.save(cartItem);
		cartItem.setCart(cart);
		return cartItemRepository.save(cartItem);
	}
}
