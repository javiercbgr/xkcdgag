package com.jcabero.xkcdgag.comment.controller;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcabero.xkcdgag.comment.model.Comment;

@CrossOrigin(allowCredentials="true", 
			methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.OPTIONS,RequestMethod.DELETE},
			allowedHeaders={"x-requested-with", "accept", "authorization", "content-type", "origin"}, 
			exposedHeaders={"access-control-allow-headers", "access-control-allow-methods", "access-control-allow-origin", "access-control-max-age", "X-Frame-Options"})
@RepositoryRestResource(collectionResourceRel = "comment", path = "comment")
public interface CommentREST extends PagingAndSortingRepository<Comment, Long> {
}
