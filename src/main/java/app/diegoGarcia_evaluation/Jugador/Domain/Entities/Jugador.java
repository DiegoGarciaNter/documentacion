package app.diegoGarcia_evaluation.Jugador.Domain.Entities;

import app.diegoGarcia_evaluation.Equipo.Domain.Entities.Equipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "jugador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "edad")
    private int edad;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @ElementCollection
    private List<String> posicion;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Jugador jugador = (Jugador) obj;
        return Objects.equals(this.id, jugador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
