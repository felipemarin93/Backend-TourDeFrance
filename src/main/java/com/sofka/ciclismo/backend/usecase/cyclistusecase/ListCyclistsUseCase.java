package com.sofka.ciclismo.backend.usecase.cyclistusecase;

import com.sofka.ciclismo.backend.dto.CyclistDTO;
import com.sofka.ciclismo.backend.mapper.CyclistMapper;
import com.sofka.ciclismo.backend.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class ListCyclistsUseCase implements Supplier<Flux<CyclistDTO>> {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;


    public ListCyclistsUseCase(CyclistRepository cyclistRepository, CyclistMapper cyclistMapper){
        this.cyclistRepository = cyclistRepository;
        this.cyclistMapper = cyclistMapper;
    }

    public Flux<CyclistDTO> get(){
        return cyclistRepository.findAll()
                .map(cyclistMapper.mapCyclistToCyclistDTO());
    }
}
