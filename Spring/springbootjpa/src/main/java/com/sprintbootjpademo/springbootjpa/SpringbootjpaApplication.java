package com.sprintbootjpademo.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootjpaApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringbootjpaApplication.class, args);
     UserRepo repo=context.getBean(UserRepo.class);


	 User u=new User(1,"Ashsih","Dhanbad");
	 

	}

}
