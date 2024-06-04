package app.diegoGarcia_evaluation.Equipo.Infrastructure.DTO;

import app.diegoGarcia_evaluation.Jugador.Infrastructure.DTO.JugadorOutputDTO;
import app.diegoGarcia_evaluation.Jugador.Infrastructure.DTO.JugadorOutputDTOsinEquipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipoOutputDTO {
    private Long id;
    private String nombre_equipo;
    //Hago un DTO de jugador sin el equipo para que al mostrar la informacion del mismo no salga el nombre repetido
    private Set<JugadorOutputDTOsinEquipo> jugadores;
}
