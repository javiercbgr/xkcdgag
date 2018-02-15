package com.jcabero.xkcdgag.model;

import org.springframework.data.repository.CrudRepository;

import com.jcabero.xkcdgag.daos.Gag;

public interface GagDAO extends CrudRepository<Gag, Long>{

}
