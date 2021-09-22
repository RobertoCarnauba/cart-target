package com.carnauba.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.carnauba.entities.Cart;
import com.carnauba.entities.CartItem;
import com.carnauba.entities.Category;
import com.carnauba.entities.Product;
import com.carnauba.repositores.CartItemRepository;
import com.carnauba.repositores.CartRepository;
import com.carnauba.repositores.CategoryRepository;
import com.carnauba.repositores.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category category1 = new Category(null, "HomeAppliances");
		Category category2 = new Category(null, "Computers");
		Category category3 = new Category(null, "Beers");

		Product product1 = new Product(null, "Computer XPTO Core I5", 1500.00);
		Product product2 = new Product(null, "Refrigerador Philco Side By Side ", 5500.10);
		Product product3 = new Product(null, "Smart TV LED 32\" TCL 32S6500S Android, HDR", 1400.90);
		Product product4 = new Product(null, "AOC Roku TV Smart TV LED 43” Full HD 43S5195/78 com Wi-fi, ", 1999.70);
		Product product5 = new Product(null, "SPEYSIDE - GARRAFA 330ML", 33.90);
		Product product6 = new Product(null, "LA TRAPPE BLOND - GARRAFA 750ML", 150.30);
		Product product7 = new Product(null, "FULLER'S LONDON PRIDE LATA 500ML", 45.40);

		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5, product6, product7));

		product1.getCategories().add(category2);
		product2.getCategories().add(category1);
		product3.getCategories().add(category1);
		product3.getCategories().add(category1);
		product4.getCategories().add(category1);
		product5.getCategories().add(category3);
		product6.getCategories().add(category3);
		product7.getCategories().add(category3);

		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5, product6, product7));

		Cart cart1 = new Cart(null);
		Cart cart3 = new Cart(null);
		Cart cart4 = new Cart(null);
		cartRepository.saveAll(Arrays.asList(cart1, cart3, cart4));

		CartItem cartItem1 = new CartItem(cart3, product5, 6, product5.getPrice());
		CartItem cartItem2 = new CartItem(cart1, product4, 1, product4.getPrice());
		CartItem cartItem3 = new CartItem(cart4, product3, 1, product3.getPrice());
		CartItem cartItem4 = new CartItem(cart3, product6, 4, product6.getPrice());
		CartItem cartItem5 = new CartItem(cart1, product5, 2, product5.getPrice());
		CartItem cartItem6 = new CartItem(cart1, product7, 10, product7.getPrice());

		cartItemRepository.saveAll(Arrays.asList(cartItem1, cartItem2, cartItem3, cartItem4, cartItem5, cartItem6));

	}

}
