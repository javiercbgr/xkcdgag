package com.jcabero.xkcdgag.gag;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "gag", path = "gag")
public interface GagDAO extends PagingAndSortingRepository<Gag, Long> {

	Gag number(@Param("number") Long number); 
}
