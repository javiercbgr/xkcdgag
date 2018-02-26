package com.jcabero.xkcdgag.crawler.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jcabero.xkcdgag.crawler.model.Gag;

public interface GagDAO extends CrudRepository<Gag, Long>{

	  @Query("from Gag g where g.numGag=:numGag")
	  public Gag find(@Param("numGag") Long numGag);
}
