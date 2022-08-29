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

class ListCyclistsByNationalityUseCaseTest {
    @MockBean
    CyclistRepository cyclistRepository;

    @MockBean
    ListCyclistsByNationalityUseCase listCyclistsByNationalityUseCase;

    CyclistMapper mappers = new CyclistMapper();

    @BeforeEach
    void setUp() {
        cyclistRepository = mock(CyclistRepository.class);
        listCyclistsByNationalityUseCase = new ListCyclistsByNationalityUseCase(
                cyclistRepository, mappers
        );
    }

    @Test
    void listCyclistsByNationalityValidationTest() {

        var cyclist = new Cyclist();
        cyclist.setIdCyclist("A01");
        cyclist.setFullName("Nairo Quintana");
        cyclist.setCyclistNumber("001");
        cyclist.setTeamName("Movistar");
        cyclist.setNationality("Colombia");

        var cyclistDTO = mappers.mapCyclistToCyclistDTO().apply(cyclist);

        when(cyclistRepository.save(cyclist)).thenReturn(Mono.just(cyclist));

        when(cyclistRepository.findCyclistsByNationality(cyclist.getNationality())).thenReturn(Flux.just(cyclist));

        StepVerifier.create(listCyclistsByNationalityUseCase
                        .apply(cyclist.getNationality()))
                .expectSubscription()
                .expectNext(cyclistDTO)
                .verifyComplete();

        verify(cyclistRepository).findCyclistsByNationality(cyclist.getNationality());
    }
}