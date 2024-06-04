package app.diegoGarcia_evaluation.Equipo.Domain.Entities;

import app.diegoGarcia_evaluation.Jugador.Domain.Entities.Jugador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "equipo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Long id;

    @Column(name = "nombre_equipo")
    private String nombre_equipo;

    @OneToMany(mappedBy = "equipo", fetch = FetchType.EAGER)
    private List<Jugador> jugadores;
}
