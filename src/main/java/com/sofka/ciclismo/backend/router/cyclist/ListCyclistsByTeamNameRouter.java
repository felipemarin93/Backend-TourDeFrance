package com.sofka.ciclismo.backend.router.cyclist;

import com.sofka.ciclismo.backend.dto.CyclistDTO;
import com.sofka.ciclismo.backend.usecase.cyclist.ListCyclistsByTeamNameUseCase;
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
public class ListCyclistsByTeamNameRouter {

    @Bean
    public RouterFunction<ServerResponse> listCyclistsByTeamName(ListCyclistsByTeamNameUseCase listCyclistsByTeamNameUseCase){
        return route(
                GET("/cyclist/list/{nameTeam}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(listCyclistsByTeamNameUseCase
                                        .apply(request.pathVariable("nameTeam")),
                                CyclistDTO.class))
        );
    }
}
