package com.sofka.ciclismo.backend.usecase.cyclist;

import com.sofka.ciclismo.backend.dto.CyclistDTO;
import com.sofka.ciclismo.backend.mapper.CyclistMapper;
import com.sofka.ciclismo.backend.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;


@Service
@Validated
public class ListCyclistsByTeamNameUseCase implements Function<String, Flux<CyclistDTO>> {
    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public ListCyclistsByTeamNameUseCase(CyclistRepository cyclistRepository, CyclistMapper cyclistMapper) {
        this.cyclistRepository = cyclistRepository;
        this.cyclistMapper = cyclistMapper;
    }
    @Override
    public Flux<CyclistDTO> apply(String teamName){
        return cyclistRepository.findCyclistsByTeamName(teamName)
                .map(cyclistMapper.mapCyclistToCyclistDTO());
    }

}
