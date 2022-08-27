package com.sofka.ciclismo.backend.router.team;

import com.sofka.ciclismo.backend.dto.TeamDTO;
import com.sofka.ciclismo.backend.usecase.team.ListTeamsByCountryUseCase;
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
public class ListTeamsByCountryRouter {
    @Bean

    public RouterFunction<ServerResponse> listTeamsByCountry(ListTeamsByCountryUseCase listTeamsByCountryUseCase){
        return route(
                GET("teams/{country}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(listTeamsByCountryUseCase
                                        .apply(request.pathVariable("country")),
                                TeamDTO.class))
        );
    }
}
