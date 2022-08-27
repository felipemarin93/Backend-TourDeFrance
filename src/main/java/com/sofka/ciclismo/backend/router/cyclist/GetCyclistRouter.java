package com.sofka.ciclismo.backend.router.cyclist;

import com.sofka.ciclismo.backend.dto.CyclistDTO;
import com.sofka.ciclismo.backend.usecase.cyclist.GetCyclistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCyclistRouter {
    @Bean
    public RouterFunction<ServerResponse> getCyclist(GetCyclistUseCase getCyclistUseCase){
        return route(
                GET("/cyclist/get/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getCyclistUseCase
                                .apply(request.pathVariable("id")), CyclistDTO.class))
        );
    }
 }
