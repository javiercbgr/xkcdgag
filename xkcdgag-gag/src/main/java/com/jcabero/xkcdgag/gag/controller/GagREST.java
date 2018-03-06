package com.jcabero.xkcdgag.gag.controller;


import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jcabero.xkcdgag.gag.model.Gag;

@RepositoryRestResource(collectionResourceRel = "gag", path = "gag")
public interface GagREST extends PagingAndSortingRepository<Gag, Long> {

	@Query("SELECT g FROM Gag g WHERE g.number = :number GROUP BY g.id")
	Gag gag(@Param("number") Long number); 
	
	@Query("SELECT MAX(g.number) FROM Gag g")
	Integer last();

	@Query("SELECT g FROM Gag g WHERE g.number <= :from ORDER BY g.number DESC")
	Page<Gag> lastGags(Pageable pageable, @Param("from") Long from);
	
	@Modifying
	@Transactional
	@Query("UPDATE Gag g set g.likes = g.likes + 1 WHERE g.number = :number")
	void addLike(@Param("number") Long number);

	@Modifying
	@Transactional
	@Query("UPDATE Gag g set g.likes = g.likes - 1 WHERE g.number = :number")
	void rmLike(@Param("number") Long number);
}
