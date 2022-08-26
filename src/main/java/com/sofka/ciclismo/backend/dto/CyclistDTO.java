package com.sofka.ciclismo.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
public class CyclistDTO {

    private String idCyclist;

    @NotBlank
    private String fullName;

    @NotBlank
    @Indexed(unique = true)
    @Size(min = 1, max =3)
    private String cyclistNumber;

    @NotBlank
    private String teamName;
    @NotBlank
    private String nationality;

    public CyclistDTO(String idCyclist, String fullName, String cyclistNumber, String teamName, String nationality){
        this.idCyclist = idCyclist;
        this.fullName = fullName;
        this.cyclistNumber = cyclistNumber;
        this.teamName = teamName;
        this.nationality = nationality;
    }
}
