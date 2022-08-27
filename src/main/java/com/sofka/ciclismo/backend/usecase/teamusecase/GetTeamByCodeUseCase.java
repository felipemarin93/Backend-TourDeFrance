package com.sofka.ciclismo.backend.usecase.teamusecase;

import com.sofka.ciclismo.backend.dto.TeamDTO;
import com.sofka.ciclismo.backend.mapper.TeamMapper;
import com.sofka.ciclismo.backend.repository.TeamRepository;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class GetTeamByCodeUseCase implements Function<String, Mono<TeamDTO>> {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public GetTeamByCodeUseCase(TeamRepository teamRepository, TeamMapper teamMapper){
        this.teamMapper = teamMapper;
        this.teamRepository = teamRepository;
    }

    @Override
    public Mono<TeamDTO> apply (String code){
        return teamRepository.findTeamByTeamCode(code)
                .map(teamMapper.mapTeamToTeamDTO());
    }
}
