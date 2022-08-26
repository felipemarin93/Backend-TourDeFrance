package com.sofka.ciclismo.backend.usecase;

import com.sofka.ciclismo.backend.dto.CyclistDTO;
import com.sofka.ciclismo.backend.mapper.CyclistMapper;
import com.sofka.ciclismo.backend.repository.CyclistRepository;
import com.sofka.ciclismo.backend.usecase.SaveCyclist;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateCyclistUseCase implements SaveCyclist {

    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public createCyclistUseCase(CyclistRepository cyclistRepository, CyclistMapper cyclistMapper){
        this.cyclistRepository = cyclistRepository;
        this.cyclistMapper = cyclistMapper;
    }
    @Override
    public Mono<CyclistDTO> apply(CyclistDTO cyclistDTO){
        return cyclistRepository
                .save(cyclistMapper.mapCyclistDTOToCyclist(null).apply(cyclistDTO))
                .map(cyclistMapper.mapCyclistToCyclistDTO());
    }
}
