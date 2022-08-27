package com.sofka.ciclismo.backend.usecase.team;

import com.sofka.ciclismo.backend.dto.TeamDTO;
import com.sofka.ciclismo.backend.mapper.TeamMapper;
import com.sofka.ciclismo.backend.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;


import java.util.function.Supplier;


@Service
@Validated
public class ListTeamsUseCase implements Supplier<Flux<TeamDTO>> {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public ListTeamsUseCase(TeamRepository teamRepository, TeamMapper teamMapper){
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public Flux<TeamDTO> get(){
        return teamRepository.findAll()
                .map(teamMapper.mapTeamToTeamDTO());
    }
}
