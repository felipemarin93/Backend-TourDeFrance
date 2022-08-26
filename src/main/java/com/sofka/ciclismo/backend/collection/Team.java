package com.sofka.ciclismo.backend.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "team")
public class Team {
    @Id
    private String teamId;
    @NotBlank
    private String teamName;
    @NotBlank
    @Indexed(unique = true)
    private String teamCode;
    @NotBlank
    private String country;
    @NotBlank
    private List<Cyclist> squadron;
}
