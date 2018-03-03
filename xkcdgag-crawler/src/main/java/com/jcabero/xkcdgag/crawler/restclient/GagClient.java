package com.jcabero.xkcdgag.crawler.restclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcabero.xkcdgag.gag.model.Gag;

@FeignClient("GAG")
public interface GagClient {
 
      @RequestMapping( value = "/gag/{number}", method = RequestMethod.GET )
      public Gag find(@PathVariable("number") Long number); 
      
      @RequestMapping( value = "/gag", method = RequestMethod.POST, consumes = "application/json")
      public void create(@RequestBody Gag gag);
}
