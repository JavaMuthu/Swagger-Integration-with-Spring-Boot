/**
 * 
 */
package com.nirmal.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author muthu_m
 *
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.getProperties().put("server.port", 8081);
		SpringApplication.run(DemoApplication.class, args);
	}
}
