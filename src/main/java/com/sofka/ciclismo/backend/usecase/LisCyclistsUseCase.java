package com.sofka.ciclismo.backend.usecase;

import com.sofka.ciclismo.backend.dto.CyclistDTO;
import com.sofka.ciclismo.backend.mapper.CyclistMapper;
import com.sofka.ciclismo.backend.repository.CyclistRepository;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

public class LisCyclistsUseCase implements Supplier<Flux<CyclistDTO>> {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;


    public LisCyclistsUseCase(CyclistRepository cyclistRepository, CyclistMapper cyclistMapper){
        this.cyclistRepository = cyclistRepository;
        this.cyclistMapper = cyclistMapper;
    }

    public Flux<CyclistDTO> get(){
        return cyclistRepository.findAll()
                .map(cyclistMapper.mapCyclistToCyclistDTO());
    }
}
