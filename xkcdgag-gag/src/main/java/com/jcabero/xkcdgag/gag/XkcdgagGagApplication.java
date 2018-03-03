package com.jcabero.xkcdgag.gag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class XkcdgagGagApplication {

	public static void main(String[] args) {
		SpringApplication.run(XkcdgagGagApplication.class, args);
	}
}
	