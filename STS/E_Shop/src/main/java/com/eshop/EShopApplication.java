package com.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EShopApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EShopApplication.class, args);
		AppController controller = context.getBean(AppController.class);
		controller.init(new LightTimer(),new TimeReader());

	}
}
