package com.sofka.ciclismo.backend.repository;

import com.sofka.ciclismo.backend.collection.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TeamRepository extends ReactiveMongoRepository<Team, String> {
    Mono<Team> findTeamByTeamCode(String teamCode);
    Flux<Team> findAll();
    Flux<Team> findTeamsByCountry(String country);

}
