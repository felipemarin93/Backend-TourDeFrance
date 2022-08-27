package com.sofka.ciclismo.backend.usecase.team;

import com.sofka.ciclismo.backend.dto.TeamDTO;
import com.sofka.ciclismo.backend.mapper.TeamMapper;
import com.sofka.ciclismo.backend.repository.TeamRepository;

import com.sofka.ciclismo.backend.usecase.interfaces.SaveTeam;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UpdateTeamUseCase implements SaveTeam {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public UpdateTeamUseCase(TeamRepository teamRepository, TeamMapper teamMapper){
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public Mono<TeamDTO> apply(TeamDTO teamDTO){
        return teamRepository
                .save(teamMapper.mapTeamDTOToTeam(teamDTO.getTeamId())
                        .apply(teamDTO))
                            .map(teamMapper.mapTeamToTeamDTO());
    }
}
