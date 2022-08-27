package com.sofka.ciclismo.backend.usecase.team;

import com.sofka.ciclismo.backend.dto.TeamDTO;
import com.sofka.ciclismo.backend.mapper.TeamMapper;
import com.sofka.ciclismo.backend.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
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
