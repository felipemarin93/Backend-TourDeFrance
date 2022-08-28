package com.sofka.ciclismo.backend.usecase.team;

import com.sofka.ciclismo.backend.dto.TeamDTO;
import com.sofka.ciclismo.backend.mapper.TeamMapper;
import com.sofka.ciclismo.backend.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class GetTeamUseCase implements Function<String, Mono<TeamDTO>> {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public GetTeamUseCase(TeamRepository teamRepository, TeamMapper teamMapper){
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }
    @Override
    public Mono<TeamDTO> apply(String id){
        Objects.requireNonNull(id, "Team ID is required");
        return teamRepository.findById(id)
                .map(teamMapper.mapTeamToTeamDTO());
    }

}
