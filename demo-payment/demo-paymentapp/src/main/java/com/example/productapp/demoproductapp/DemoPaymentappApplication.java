package com.example.productapp.demoproductapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoPaymentappApplication{

	public static Integer COUNTER = 1;
	public static void main(String[] args) {
		SpringApplication.run(DemoPaymentappApplication.class, args);
	}



//	@Override
//	public void run(String... args) throws Exception{
//		System.out.println("migration configuration:"+ migrationConfiguration.getMigration());
//	}
}
