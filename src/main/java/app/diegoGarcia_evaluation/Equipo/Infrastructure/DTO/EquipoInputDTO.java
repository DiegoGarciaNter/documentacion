package app.diegoGarcia_evaluation.Equipo.Infrastructure.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipoInputDTO {
    private String nombre_equipo;
    private List<Long> id_jugadores;
}
