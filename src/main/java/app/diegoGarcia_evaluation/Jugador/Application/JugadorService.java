package app.diegoGarcia_evaluation.Jugador.Application;

import app.diegoGarcia_evaluation.Jugador.Domain.Entities.Jugador;

import java.util.List;

public interface JugadorService {

    Jugador findById(Long id);

    List<Jugador> findAll();

    Jugador save(Jugador jugador);

    void deleteById(Long id);

    void saveAll(List<Jugador> jugadores);

}
