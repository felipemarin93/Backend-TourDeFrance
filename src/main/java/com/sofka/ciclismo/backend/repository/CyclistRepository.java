package com.sofka.ciclismo.backend.repository;

import com.sofka.ciclismo.backend.collection.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CyclistRepository extends ReactiveMongoRepository<Cyclist,String> {

}
