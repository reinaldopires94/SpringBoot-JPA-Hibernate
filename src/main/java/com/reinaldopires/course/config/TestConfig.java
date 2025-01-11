package com.reinaldopires.course.config;

import java.time.Instant;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.reinaldopires.course.entities.Category;
import com.reinaldopires.course.entities.Order;
import com.reinaldopires.course.entities.Product;
import com.reinaldopires.course.entities.User;
import com.reinaldopires.course.entities.enums.OrderStatus;
import com.reinaldopires.course.repositories.CategoryRepository;
import com.reinaldopires.course.repositories.OrderRepository;
import com.reinaldopires.course.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1  = new Category(null, "Electronics");
		Category cat2  = new Category(null, "Books");
		Category cat3  = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Film of magic and history", 1200.00, "");
		Product p2 = new Product(null, "Smart TV", "TV Full HD 8K", 8999.03, "");
		Product p3 = new Product(null, "PC Game", "Playstation 6", 999888.33, "");
		Product p4 = new Product(null, "Macbook Pro", "Notebook 32 RAM", 122.02, "");
		Product p5 = new Product(null, "Iphone 16 Pro Max", "Phone 500GB",7858.11, "");
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));	
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat1);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
			
		User u1 = new User(null, "Maria Brown", "maria@hot.com","01989989899","123456789");
		User u2 = new User(null, "Mari Campo", "maria@yhaoo.com","02989989899","123456789");
		User u3 = new User(null, "Mara suko", "maria@gma.com","03989989899","123456789");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Order o1 = new Order(null, Instant.parse("2025-07-05T09:00:00Z"), OrderStatus.CANCELED, u1);
		Order o2 = new Order(null, Instant.parse("2025-07-06T09:11:11Z"), OrderStatus.DELIVERED, u2);
		Order o3 = new Order(null, Instant.parse("2025-07-07T09:22:22Z"), OrderStatus.PAID, u3);
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
}