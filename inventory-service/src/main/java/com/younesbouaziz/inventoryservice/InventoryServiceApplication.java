package com.younesbouaziz.inventoryservice;

import com.younesbouaziz.inventoryservice.model.Inventory;
import com.younesbouaziz.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *  "@EnableEurekaClient" is deprecated, no need to annotate the main class.
 *  It is enough to add the spring-cloud-starter-netflix-eureka-client
 *  dependency to pom.xml and if we have the application name in yml
 *  or properties file it will be registered to Eureka Server.
 */
@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone_13_red");
			inventory1.setQuantity(0);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}
