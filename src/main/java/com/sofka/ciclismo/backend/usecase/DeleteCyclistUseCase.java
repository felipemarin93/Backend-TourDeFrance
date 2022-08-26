package com.sofka.ciclismo.backend.usecase;


import com.sofka.ciclismo.backend.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class DeleteCyclistUseCase {

    private final CyclistRepository cyclistRepository;

    public DeleteCyclistUseCase(CyclistRepository cyclistRepository){
        this.cyclistRepository = cyclistRepository;
    }

    @Override
    public Mono<Void> apply(String id){
        Objects.requireNonNull(id,"Cyclist Id is required");
        return cyclistRepository.deleteById(id);
    }

}
