package com.jcabero.xkcdgag.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
//@EnableDiscoveryClient
@EnableConfigServer
public class XkcdgagConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(XkcdgagConfigApplication.class, args);
	}
}
