package com.sofka.ciclismo.backend.repository;

import com.sofka.ciclismo.backend.collection.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TeamRepository extends ReactiveMongoRepository<Team, String> {

}
