package com.sofka.ciclismo.backend.usecase.team;

import com.sofka.ciclismo.backend.collection.Cyclist;
import com.sofka.ciclismo.backend.mapper.CyclistMapper;
import com.sofka.ciclismo.backend.repository.CyclistRepository;
import com.sofka.ciclismo.backend.usecase.cyclist.CreateCyclistUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreateTeamUseCaseTest {
    @MockBean
    CyclistRepository cyclistRepository;
    @MockBean
    CreateCyclistUseCase createCyclistUseCase;
    CyclistMapper mapper = new CyclistMapper();

    @BeforeEach
    void setUp() {
        cyclistRepository = mock(CyclistRepository.class);
        createCyclistUseCase = new CreateCyclistUseCase(cyclistRepository, mapper);
    }

    @Test
    void createCyclistValidationTest() {

        var cyclist = new Cyclist();
        cyclist.setIdCyclist("01");
        cyclist.setFullName("Daniel Marin");
        cyclist.setCyclistNumber("001");
        cyclist.setTeamName("Sofka");
        cyclist.setNationality("Colombia");

        var cyclistDTO = mapper.mapCyclistToCyclistDTO().apply(cyclist);

        when(cyclistRepository.save(any(Cyclist.class))).thenReturn(Mono.just(cyclist));

        StepVerifier.create(createCyclistUseCase.apply(cyclistDTO))
                .expectSubscription()
                .expectNext(cyclistDTO)
                .verifyComplete();


    }
}