package com.carnauba.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.carnauba.entities.Cart;
import com.carnauba.entities.Category;
import com.carnauba.entities.User;
import com.carnauba.repositores.CartRepository;
import com.carnauba.repositores.CategoryRepository;
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

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Roberto Carnaúba Dias", "beto@teste.com", "11963328498", "123654", null);
		User u2 = new User(null, "Pedro Dantas da Silva", "pedro@teste.com", "15983328489", "741369", null);
		User u3 = new User(null, "Maria de Mello Rego", "mmrego@teste.com", "13963987852", "789654", null);
		
		Cart cart1 =  new Cart(null, Instant.parse("2021-09-01T03:20:23Z"), u1, (double) 12, 100.12, 326.00);
		Cart cart2 =  new Cart(null, Instant.parse("2021-09-01T03:20:23Z"), u1, (double) 12, 100.12, 326.00);
		Cart cart3 =  new Cart(null, Instant.parse("2021-09-01T03:20:23Z"), u3, (double) 12, 100.12, 326.00);
		Cart cart4 =  new Cart(null, Instant.parse("2021-09-01T03:20:23Z"), u2, (double) 12, 100.12, 326.00);
		
		Category category1 = new Category(null, "Electronics");
		Category category2 = new Category(null, "Book");
		Category category3 = new Category(null, "Beers");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		cartRepository.saveAll(Arrays.asList(cart1, cart2, cart3, cart4));
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
	}
	
	

}
