package com.sofka.ciclismo.backend.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cyclist")
public class Cyclist {

    @Id
    private String idCyclist;
    private String fullName;

    @Indexed(unique = true)
    private Integer cyclistNumber;
    private String teamId;
    private String nationality;

}
