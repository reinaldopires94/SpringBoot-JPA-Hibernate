package com.reinaldopires.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.reinaldopires.course.entities.User;
import com.reinaldopires.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@hot.com","01989989899","123456789");
		User u2 = new User(null, "Mari Campo", "maria@yhaoo.com","02989989899","123456789");
		User u3 = new User(null, "Mara suko", "maria@gma.com","03989989899","123456789");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
	}
}