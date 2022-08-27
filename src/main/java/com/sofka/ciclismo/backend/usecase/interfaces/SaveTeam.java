package com.sofka.ciclismo.backend.usecase.interfaces;


import com.sofka.ciclismo.backend.dto.TeamDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface SaveTeam {
    Mono<TeamDTO> apply(@Valid TeamDTO teamDTO);
}
