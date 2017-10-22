package com.pbg.SocketsDemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pbg.SocketsDemo.model.Peticion;

@Repository
public interface PeticionDao extends CrudRepository<Peticion, String> {

}
