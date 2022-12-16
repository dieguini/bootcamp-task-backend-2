package com.example.lambdashoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.config.RepositoriesConfigurator;
import com.example.controllers.ProductController;

@SpringBootApplication
@Import({ProductController.class, RepositoriesConfigurator.class})
public class LambdaShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(LambdaShoppingCartApplication.class, args);
	}

}
