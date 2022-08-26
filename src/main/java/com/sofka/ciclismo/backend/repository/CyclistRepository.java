package com.sofka.ciclismo.backend.repository;

import com.sofka.ciclismo.backend.collection.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CyclistRepository extends ReactiveMongoRepository<Cyclist,String> {
    Mono<Cyclist> findCyclistByCyclistNumber(String cyclistNumber);
    Flux<Cyclist> findAll();
    Flux<Cyclist> findCyclistsByNationality(String nationality);
    Flux<Cyclist> findCyclistsByTeamName(String teamName);
}


