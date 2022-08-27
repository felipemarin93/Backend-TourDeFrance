package com.sofka.ciclismo.backend.usecase.interfaces;

import com.sofka.ciclismo.backend.dto.CyclistDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface SaveCyclist {
    Mono<CyclistDTO> apply(@Valid CyclistDTO cyclistDTO);
}
