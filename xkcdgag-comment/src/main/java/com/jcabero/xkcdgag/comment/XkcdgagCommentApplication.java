package com.jcabero.xkcdgag.comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class XkcdgagCommentApplication {

	public static void main(String[] args) {
		SpringApplication.run(XkcdgagCommentApplication.class, args);
	}
}
	