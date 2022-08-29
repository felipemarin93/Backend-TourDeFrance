package com.sofka.ciclismo.backend.usecase.cyclist;

import com.sofka.ciclismo.backend.collection.Cyclist;
import com.sofka.ciclismo.backend.mapper.CyclistMapper;
import com.sofka.ciclismo.backend.repository.CyclistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ListCyclistsByTeamNameUseCaseTest {

    @MockBean
    CyclistRepository cyclistRepository;

    @MockBean
    ListCyclistsByTeamNameUseCase listCyclistsByNameTeamUseCase;

    CyclistMapper mapper = new CyclistMapper();

    @BeforeEach
    void setUp() {
        cyclistRepository = mock(CyclistRepository.class);
        listCyclistsByNameTeamUseCase = new ListCyclistsByTeamNameUseCase(
                cyclistRepository, mapper
        );
    }

    @Test
    void listCyclistsByTeamNameValidationTest() {

        var cyclist = new Cyclist();
        cyclist.setIdCyclist("01");
        cyclist.setFullName("Doris Marin");
        cyclist.setCyclistNumber("001");
        cyclist.setTeamName("Sofka");
        cyclist.setNationality("Colombia");

        var cyclistDTO = mapper.mapCyclistToCyclistDTO().apply(cyclist);

        when(cyclistRepository.save(cyclist)).thenReturn(Mono.just(cyclist));

        when(cyclistRepository.findCyclistsByTeamName(cyclist.getTeamName())).thenReturn(Flux.just(cyclist));

        StepVerifier.create(listCyclistsByNameTeamUseCase.apply(cyclist.getTeamName()))
                .expectSubscription()
                .expectNext(cyclistDTO)
                .verifyComplete();

        verify(cyclistRepository).findCyclistsByTeamName(cyclist.getTeamName());
    }
}