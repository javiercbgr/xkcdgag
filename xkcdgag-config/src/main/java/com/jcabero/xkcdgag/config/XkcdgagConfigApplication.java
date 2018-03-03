package com.jcabero.xkcdgag.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableAutoConfiguration
@EnableConfigServer
public class XkcdgagConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(XkcdgagConfigApplication.class, args);
	}
}
