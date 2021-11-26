package com.dbc.biblioteca.repository;

import com.dbc.biblioteca.entity.TrocaPontosEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrocaPontosRepository extends MongoRepository<TrocaPontosEntity, String> {

}
