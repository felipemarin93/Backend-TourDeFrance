package com.sofka.ciclismo.backend.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cyclist")
public class Cyclist {

    @Id
    private String idCyclist;
    @NotBlank
    private String fullName;
    @NotBlank
    @Indexed(unique = true)
    @Size(min=1, max=3)
    private String cyclistNumber;
    @NotBlank
    private String teamName;
    @NotBlank
    private String nationality;

}
