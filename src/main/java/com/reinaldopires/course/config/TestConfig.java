package com.reinaldopires.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.reinaldopires.course.entities.Category;
import com.reinaldopires.course.entities.Order;
import com.reinaldopires.course.entities.User;
import com.reinaldopires.course.entities.enums.OrderStatus;
import com.reinaldopires.course.repositories.CategoryRepository;
import com.reinaldopires.course.repositories.OrderRepository;
import com.reinaldopires.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1  = new Category(null, "Electronics");
		Category cat2  = new Category(null, "Books");
		Category cat3  = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
			
		User u1 = new User(null, "Maria Brown", "maria@hot.com","01989989899","123456789");
		User u2 = new User(null, "Mari Campo", "maria@yhaoo.com","02989989899","123456789");
		User u3 = new User(null, "Mara suko", "maria@gma.com","03989989899","123456789");
		
		Order o1 = new Order(null, Instant.parse("2025-07-05T09:00:00Z"), OrderStatus.CANCELED, u1);
		Order o2 = new Order(null, Instant.parse("2025-07-06T09:11:11Z"), OrderStatus.DELIVERED, u2);
		Order o3 = new Order(null, Instant.parse("2025-07-07T09:22:22Z"), OrderStatus.PAID, u3);
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
}