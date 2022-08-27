package com.sofka.ciclismo.backend.usecase.teamusecase;

import com.sofka.ciclismo.backend.repository.TeamRepository;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

public class DeleteTeamUseCase implements Function<String, Mono<Void>> {
    private final TeamRepository teamRepository;

    public DeleteTeamUseCase(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    @Override
    public Mono<Void> apply (String id){
        Objects.requireNonNull(id, "Team ID is required");
        return teamRepository.deleteById(id);
    }

}
