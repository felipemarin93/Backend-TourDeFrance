package com.sofka.ciclismo.backend.usecase.cyclist;

import com.sofka.ciclismo.backend.dto.CyclistDTO;
import com.sofka.ciclismo.backend.mapper.CyclistMapper;
import com.sofka.ciclismo.backend.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class GetCyclistUseCase implements Function<String, Mono<CyclistDTO>> {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistmapper;

    public GetCyclistUseCase(CyclistRepository cyclistRepository, CyclistMapper cyclistMapper){
        this.cyclistRepository = cyclistRepository;
        this.cyclistmapper = cyclistMapper;
    }

    @Override
    public Mono<CyclistDTO> apply(String id){
        Objects.requireNonNull(id, "cyclist ID is required");
        return cyclistRepository.findById(id)
                .map(cyclistmapper.mapCyclistToCyclistDTO());
    }

}
