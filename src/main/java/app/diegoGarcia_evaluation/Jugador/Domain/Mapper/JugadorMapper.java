package app.diegoGarcia_evaluation.Jugador.Domain.Mapper;


import app.diegoGarcia_evaluation.Equipo.Domain.Entities.Equipo;
import app.diegoGarcia_evaluation.Equipo.Infrastructure.DTO.EquipoInputDTO;
import app.diegoGarcia_evaluation.Jugador.Domain.Entities.Jugador;
import app.diegoGarcia_evaluation.Jugador.Infrastructure.DTO.JugadorInputDTO;
import app.diegoGarcia_evaluation.Jugador.Infrastructure.DTO.JugadorOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface JugadorMapper {

    @Mapping(source = "equipo.nombre_equipo", target = "nombre_equipo")
    JugadorOutputDTO OutputJugadorToJugadorDto(Jugador jugador);
    Jugador InputJugadorDtoToJugador(JugadorInputDTO jugadorInputDTO);
    JugadorInputDTO InputJugadorToJugadorDto(Jugador jugador);

}
