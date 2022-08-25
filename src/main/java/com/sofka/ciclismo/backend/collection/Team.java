package com.sofka.ciclismo.backend.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "team")
public class Team {
    @Id
    private String teamId;
    private String nameTeam;

    @Indexed(unique = true)
    private String teamCode;
    private String country;
    private List<Cyclist> squadron;
}
