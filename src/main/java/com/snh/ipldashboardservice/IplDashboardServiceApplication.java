package com.snh.ipldashboardservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IplDashboardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IplDashboardServiceApplication.class, args);
	}

//	@Bean(name = "transactionManager")
//	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//		return new JpaTransactionManager(entityManagerFactory);
//	}

}
