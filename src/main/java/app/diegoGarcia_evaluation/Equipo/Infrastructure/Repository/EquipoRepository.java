package app.diegoGarcia_evaluation.Equipo.Infrastructure.Repository;

import app.diegoGarcia_evaluation.Equipo.Domain.Entities.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}