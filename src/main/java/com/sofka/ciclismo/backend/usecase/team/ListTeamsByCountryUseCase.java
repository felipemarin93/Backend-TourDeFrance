package com.sofka.ciclismo.backend.usecase.team;

import com.sofka.ciclismo.backend.dto.TeamDTO;
import com.sofka.ciclismo.backend.mapper.TeamMapper;
import com.sofka.ciclismo.backend.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@Validated
public class ListTeamsByCountryUseCase implements Function<String, Flux<TeamDTO>> {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public ListTeamsByCountryUseCase(TeamRepository teamRepository, TeamMapper teamMapper){
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public Flux<TeamDTO> apply (String country){
        return teamRepository.findTeamsByCountry(country)
                .map(teamMapper.mapTeamToTeamDTO());
    }

}
