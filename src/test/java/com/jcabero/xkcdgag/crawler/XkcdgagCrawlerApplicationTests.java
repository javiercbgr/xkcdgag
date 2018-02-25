package com.jcabero.xkcdgag.crawler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XkcdgagCrawlerApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(XkcdgagCrawlerApplicationTests.class);
	
	@Test
	public void contextLoads() {
		RestTemplate restTemplate = new RestTemplate();
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://xkcd.com/info.0.json");
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "multipart/form-data");
		headers.set("Accept", "text/plain");
		ResponseEntity<String> response = restTemplate.postForEntity(builder.build().encode().toUri(), 
																	new HttpEntity<MultiValueMap<String, Object>>(parameters, headers), 
																	String.class);
		log.info("Request code: " + response.getStatusCodeValue());
		log.info(response.getBody() == null ? "null" : response.getBody().toString());
//        log.info(result.getStatusCode() + " " + result.getBody());
        log.info("Finished!!");
	}

}
