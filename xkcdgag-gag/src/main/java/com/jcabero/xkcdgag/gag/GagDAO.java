//package com.jcabero.xkcdgag.gag;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//@FeignClient("GAG")
//public interface GagDAO extends CrudRepository<Gag, Long>{
//
//	  @Query("from Gag g where g.numGag=:numGag")
//	  public Gag find(@Param("numGag") Long numGag);
//}
