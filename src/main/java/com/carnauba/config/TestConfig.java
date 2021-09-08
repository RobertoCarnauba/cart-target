package com.carnauba.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.carnauba.entities.Cart;
import com.carnauba.entities.CartItem;
import com.carnauba.entities.Category;
import com.carnauba.entities.Product;
import com.carnauba.entities.User;
import com.carnauba.repositores.CartItemRepository;
import com.carnauba.repositores.CartRepository;
import com.carnauba.repositores.CategoryRepository;
import com.carnauba.repositores.ProductRepository;
import com.carnauba.repositores.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
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
		
		User u1 = new User(null, "Roberto Carnaúba Dias", "beto@teste.com", "11963328498", "123654", null);
		User u2 = new User(null, "Pedro Dantas da Silva", "pedro@teste.com", "15983328489", "741369", null);
		User u3 = new User(null, "Maria de Mello Rego", "mmrego@teste.com", "13963987852", "789654", null);
		
		Cart cart1 =  new Cart(null, Instant.parse("2021-09-01T03:20:23Z"), u1, (double) 12, 100.12, 326.00);
		Cart cart2 =  new Cart(null, Instant.parse("2021-09-01T03:20:23Z"), u1, (double) 12, 100.12, 326.00);
		Cart cart3 =  new Cart(null, Instant.parse("2021-09-01T03:20:23Z"), u3, (double) 12, 100.12, 326.00);
		Cart cart4 =  new Cart(null, Instant.parse("2021-09-01T03:20:23Z"), u2, (double) 12, 100.12, 326.00);
		
		Category category1 = new Category(null, "HomeAppliances");
		Category category2 = new Category(null, "Computers");
		Category category3 = new Category(null, "Beers");
		
		
		Product product1 =  new Product(null, "Computer XPTO Core I5", 1500.00);
		Product product2 =  new Product(null, "Refrigerador Philco Side By Side ", 5500.10);
		Product product3 =  new Product(null, "Smart TV LED 32\" TCL 32S6500S Android, HDR", 1400.90);
		Product product4 =  new Product(null, "AOC Roku TV Smart TV LED 43” Full HD 43S5195/78 com Wi-fi, ", 1999.70);
		Product product5 =  new Product(null, "SPEYSIDE - GARRAFA 330ML", 33.90);
		Product product6 =  new Product(null, "LA TRAPPE BLOND - GARRAFA 750ML", 150.30);
		Product product7 =  new Product(null, "FULLER'S LONDON PRIDE LATA 500ML", 45.40);
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		cartRepository.saveAll(Arrays.asList(cart1, cart2, cart3, cart4));
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		productRepository.saveAll(Arrays.asList(product1,product2,product3,product4, product5, product6,product7));
		
		
		product1.getCategories().add(category2);
		product2.getCategories().add(category1);
		product3.getCategories().add(category1);
		product3.getCategories().add(category1);
		product4.getCategories().add(category1);
		product5.getCategories().add(category3);
		product6.getCategories().add(category3);
		product7.getCategories().add(category3);
		
		productRepository.saveAll(Arrays.asList(product1,product2,product3,product4, product5, product6,product7));
		
		
		CartItem cartItem1 = new CartItem(cart3, product1, 1, product1.getPrice());
		CartItem cartItem2 = new CartItem(cart1, product2, 1, product1.getPrice());
		CartItem cartItem3 = new CartItem(cart4, product7, 1, product1.getPrice());
		
		cartItemRepository.saveAll(Arrays.asList(cartItem1, cartItem2, cartItem3));
		
	}
	
	

}
