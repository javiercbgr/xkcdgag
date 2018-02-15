package com.jcabero.xkcdgag.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class XkcdgagCrawlerApplication  {

	private static final Logger log = LoggerFactory.getLogger(XkcdgagCrawlerApplication.class);
	
    @Autowired
    JdbcTemplate jdbcTemplate;
    
	public static void main(String[] args) {
		SpringApplication.run(XkcdgagCrawlerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(GagDAO gagDAO) {
		return (args) -> {
			gagDAO.save(new Gag(1L,"<url>", "Test gag", 2L, 0L));
			Iterable<Gag> allGags = gagDAO.findAll();
			for (Gag g : allGags) {
				log.info(g.toString());
			}
		};
	}
}
