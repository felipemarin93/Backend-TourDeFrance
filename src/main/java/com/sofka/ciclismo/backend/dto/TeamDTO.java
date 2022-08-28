package com.sofka.ciclismo.backend.dto;

import com.sofka.ciclismo.backend.collection.Cyclist;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TeamDTO {

    private String teamId;

    @NotBlank
    private String teamName;

    @NotBlank
    @Indexed(unique = true)
    @Size(min = 1, max =3)
    private String teamCode;

    @NotBlank
    private String country;

    private Set<Cyclist> cyclistTeam;

    public TeamDTO(String teamId, String teamName, String teamCode, String country){
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamCode = teamCode;
        this.country = country;

    }

    public Set<Cyclist> getCyclistTeam(){
        this.cyclistTeam  = Optional.ofNullable(cyclistTeam).orElse(new HashSet<>());
        return cyclistTeam;
    }

}
