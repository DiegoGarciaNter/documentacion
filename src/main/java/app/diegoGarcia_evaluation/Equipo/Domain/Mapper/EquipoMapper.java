package app.diegoGarcia_evaluation.Equipo.Domain.Mapper;

import app.diegoGarcia_evaluation.Equipo.Domain.Entities.Equipo;
import app.diegoGarcia_evaluation.Equipo.Infrastructure.DTO.EquipoInputDTO;
import app.diegoGarcia_evaluation.Equipo.Infrastructure.DTO.EquipoOutputDTO;
import app.diegoGarcia_evaluation.Jugador.Domain.Mapper.JugadorMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {JugadorMapper.class})
public interface EquipoMapper {
    EquipoMapper INSTANCE = Mappers.getMapper(EquipoMapper.class);

    EquipoOutputDTO OutputEquipoToEquipoDto(Equipo equipo);
    Equipo InputEquipoDtoToEquipo(EquipoInputDTO equipoInputDTO);
    EquipoInputDTO InputEquipoToEquipoDto(Equipo equipo);
}
