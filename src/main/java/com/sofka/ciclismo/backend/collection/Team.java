package com.sofka.ciclismo.backend.collection;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
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
    @Size(min=1 , max=3)
    private String teamCode;
    @NotBlank
    private String country;

}
