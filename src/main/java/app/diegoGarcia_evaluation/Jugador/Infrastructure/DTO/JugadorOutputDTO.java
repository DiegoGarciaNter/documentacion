package app.diegoGarcia_evaluation.Jugador.Infrastructure.DTO;

import app.diegoGarcia_evaluation.Equipo.Infrastructure.DTO.EquipoOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadorOutputDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private int edad;
    private String email;
    private String nombre_equipo;
    private List<String> posicion;
}
