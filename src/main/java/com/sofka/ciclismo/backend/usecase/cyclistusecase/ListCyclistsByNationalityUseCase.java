package com.sofka.ciclismo.backend.usecase.cyclistusecase;

import com.sofka.ciclismo.backend.dto.CyclistDTO;
import com.sofka.ciclismo.backend.mapper.CyclistMapper;
import com.sofka.ciclismo.backend.repository.CyclistRepository;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class ListCyclistsByNationalityUseCase implements Function<String, Flux<CyclistDTO>> {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public ListCyclistsByNationalityUseCase(CyclistRepository cyclistRepository, CyclistMapper cyclistMapper){
        this.cyclistRepository = cyclistRepository;
        this.cyclistMapper = cyclistMapper;
    }

    @Override
    public Flux<CyclistDTO> apply(String nationality){
        return cyclistRepository.findCyclistsByNationality(nationality)
                .map(cyclistMapper.mapCyclistToCyclistDTO());
    }
}
