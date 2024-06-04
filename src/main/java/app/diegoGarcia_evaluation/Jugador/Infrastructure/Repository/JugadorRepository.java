package app.diegoGarcia_evaluation.Jugador.Infrastructure.Repository;

import app.diegoGarcia_evaluation.Jugador.Domain.Entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    @Query("SELECT j FROM Jugador j JOIN j.equipo e WHERE e.id = :id_equipo")
    List<Jugador> findAllByEquipoId(@Param("id_equipo") Long idEquipo);
}