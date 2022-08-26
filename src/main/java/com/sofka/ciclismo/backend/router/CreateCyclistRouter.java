package com.sofka.ciclismo.backend.router;

import com.sofka.ciclismo.backend.dto.CyclistDTO;
import com.sofka.ciclismo.backend.usecase.CreateCyclistUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateCyclistRouter {
    @Bean
    @RouterOperation(beanClass = CreateCyclistUseCase.class, beanMethod = "apply", operation = @Operation(
         operationId = "createCyclist", summary = "- Create Cyclist", tags = {
         "Cyclist"}, responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters in body supplied"),
            @ApiResponse(responseCode = "404", description = "Cyclist not found")}))

    public RouterFunction<ServerResponse> createCyclist(CreateCyclistUseCase createCyclistUseCase){
        Function<CyclistDTO, Mono<ServerResponse>> createCyclist = cyclistDTO ->
                createCyclistUseCase.apply(cyclistDTO)
                        .flatMap(result-> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));
        return route(
                POST("/cyclist/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDTO.class).flatmap(createCyclist)
        );
    }


}
