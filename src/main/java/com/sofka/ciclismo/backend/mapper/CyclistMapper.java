package com.sofka.ciclismo.backend.mapper;

import com.sofka.ciclismo.backend.collection.Cyclist;
import com.sofka.ciclismo.backend.dto.CyclistDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CyclistMapper {

    public Function<CyclistDTO, Cyclist> mapCyclistDTOToCyclist(String id){
        return updateCyclist ->{
          var cyclist = new Cyclist();
          cyclist.setIdCyclist(id);
          cyclist.setFullName(updateCyclist.getFullName());
          cyclist.setCyclistNumber(updateCyclist.getCyclistNumber());
          cyclist.setTeamName(updateCyclist.getTeamName());
          cyclist.setNationality(updateCyclist.getNationality());

          return cyclist;
        };
    }

    public Function<Cyclist,CyclistDTO> mapCyclistToCyclistDTO(){
        return entity -> new CyclistDTO(
                entity.getIdCyclist(),
                entity.getFullName(),
                entity.getCyclistNumber(),
                entity.getTeamName(),
                entity.getNationality()

        );
    }
}
