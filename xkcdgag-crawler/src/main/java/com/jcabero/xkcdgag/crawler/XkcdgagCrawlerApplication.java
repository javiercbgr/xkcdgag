package com.jcabero.xkcdgag.crawler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.jcabero.xkcdgag.crawler.restclient.GagClient;
import com.jcabero.xkcdgag.crawler.xkcd.model.XKCDGag;
import com.jcabero.xkcdgag.crawler.xkcd.model.XKCDGag2GagParser;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class XkcdgagCrawlerApplication  {

	private static final Logger log = LoggerFactory.getLogger(XkcdgagCrawlerApplication.class);
	
    @Autowired
    JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(XkcdgagCrawlerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner demo(GagClient gagDAO) {
		return (args) -> {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<XKCDGag> response = restTemplate.getForEntity("https://www.xkcd.com/info.0.json", XKCDGag.class);
			List<XKCDGag> gagList = new ArrayList<XKCDGag>();
			XKCDGag lastGag = response.getBody();
			log.info(lastGag.toString());
			for (int i=lastGag.getNum()-1;i>=0;i--) {
				try {
					XKCDGag gag = restTemplate.getForEntity("https://xkcd.com/" + i + "/info.0.json", XKCDGag.class).getBody();
					gagList.add(gag);
					log.info(gag.toString());
					if (gagDAO.find((long) gag.getNum()) == null) {
						log.info("Doesn't exist, storing.");
						gagDAO.create(XKCDGag2GagParser.parse(gag));
					} else {
						log.info("Already exists, skipping.");
					}
				} catch (RestClientException e) {
					log.info("Gag " + i + " not found.");
					continue;
				}
			}
	        log.info("Finished!!");
		};
	}
}
