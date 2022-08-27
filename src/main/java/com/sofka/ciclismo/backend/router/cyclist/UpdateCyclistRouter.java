package com.sofka.ciclismo.backend.router.cyclist;

import com.sofka.ciclismo.backend.dto.CyclistDTO;
import com.sofka.ciclismo.backend.usecase.cyclist.UpdateCyclistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateCyclistRouter {
    @Bean
    public RouterFunction<ServerResponse> updateCyclist(UpdateCyclistUseCase updateCyclistUseCase) {
        Function<CyclistDTO, Mono<ServerResponse>> updateCyclist = cyclistDTO ->
                updateCyclistUseCase.apply(cyclistDTO)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(
                PUT("/cyclist/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDTO.class).flatMap(updateCyclist)
        );
    }
}
