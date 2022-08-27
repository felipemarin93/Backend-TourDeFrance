package com.sofka.ciclismo.backend.router.cyclist;

import com.sofka.ciclismo.backend.dto.CyclistDTO;
import com.sofka.ciclismo.backend.usecase.cyclist.CreateCyclistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateCyclistRouter {
    @Bean
    public RouterFunction<ServerResponse> createCyclist(CreateCyclistUseCase createCyclistUseCase){
        Function<CyclistDTO, Mono<ServerResponse>> createCyclist = cyclistDTO ->
                createCyclistUseCase.apply(cyclistDTO)
                        .flatMap(result-> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));
        return route(
                POST("/cyclist/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDTO.class).flatMap(createCyclist)
        );
    }


}
