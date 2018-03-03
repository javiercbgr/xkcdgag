package com.jcabero.xkcdgag.gag.controller;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jcabero.xkcdgag.gag.model.Gag;

@RepositoryRestResource(collectionResourceRel = "gag", path = "gag")
public interface GagREST extends PagingAndSortingRepository<Gag, Long> {

	Gag number(@Param("number") Long number); 
}
