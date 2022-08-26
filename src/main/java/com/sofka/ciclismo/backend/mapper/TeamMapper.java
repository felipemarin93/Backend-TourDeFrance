package com.sofka.ciclismo.backend.mapper;


import com.sofka.ciclismo.backend.collection.Team;
import com.sofka.ciclismo.backend.dto.TeamDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeamMapper {
    public Function<TeamDTO, Team> mapTeamDTOToTeam(String id){
        return updateTeam->{

        var team = new Team();
        team.setTeamId(id);
        team.setTeamName(updateTeam.getTeamName());
        team.setTeamCode(updateTeam.getTeamCode());
        team.setCountry(updateTeam.getCountry());

        return team;

        };

    }

    public Function<Team,TeamDTO> mapTeamToTeamDTO(){
        return entity -> new TeamDTO(
                entity.getTeamId(),
                entity.getTeamName(),
                entity.getTeamCode(),
                entity.getCountry()
        );
    }


}
