package com.sofka.ciclismo.backend.usecase.cyclist;

import com.sofka.ciclismo.backend.collection.Cyclist;
import com.sofka.ciclismo.backend.mapper.CyclistMapper;
import com.sofka.ciclismo.backend.repository.CyclistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetCyclistUseCaseTest {
    @MockBean
    CyclistRepository cyclistRepository;
    @MockBean
    GetCyclistUseCase getCyclistUseCase;
    CyclistMapper mapper = new CyclistMapper();

    @BeforeEach
    void setUp() {
        cyclistRepository = mock(CyclistRepository.class);
        getCyclistUseCase = new GetCyclistUseCase(cyclistRepository, mapper);
    }

    @Test
    void getCyclistValidationTest() {

        var cyclist = new Cyclist();
        cyclist.setIdCyclist("BB2");
        cyclist.setFullName("Daniel Marin");
        cyclist.setCyclistNumber("001");
        cyclist.setTeamName("Sofka");
        cyclist.setNationality("Colombia");

        var cyclistDTO = mapper.mapCyclistToCyclistDTO().apply(cyclist);

        when(cyclistRepository.findById(cyclist.getIdCyclist())).thenReturn(Mono.just(cyclist));

        StepVerifier.create(getCyclistUseCase.apply(cyclist.getIdCyclist()))
                .expectSubscription()
                .expectNext(cyclistDTO)
                .verifyComplete();

        verify(cyclistRepository).findById(cyclist.getIdCyclist());
    }

}