package app.diegoGarcia_evaluation.Equipo.Application.services;

import app.diegoGarcia_evaluation.Equipo.Domain.Entities.Equipo;

import java.util.List;

public interface EquipoService {

    Equipo findById(Long id);

    List<Equipo> findAll();

    Equipo save(Equipo equipo);

    void deleteById(Long id);

    void saveAll(List<Equipo> asignaturas);

}
