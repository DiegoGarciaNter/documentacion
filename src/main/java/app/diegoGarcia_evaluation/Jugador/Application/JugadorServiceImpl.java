package app.diegoGarcia_evaluation.Jugador.Application;

import app.diegoGarcia_evaluation.Equipo.Domain.Entities.Equipo;
import app.diegoGarcia_evaluation.Equipo.Infrastructure.Repository.EquipoRepository;
import app.diegoGarcia_evaluation.Exceptions.EntityNotFoundException;
import app.diegoGarcia_evaluation.Jugador.Domain.Entities.Jugador;
import app.diegoGarcia_evaluation.Jugador.Infrastructure.Repository.JugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JugadorServiceImpl implements JugadorService {

    private final JugadorRepository jugadorRepository;

    @Override
    public Jugador findById(Long id) {
        return jugadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jugador no encontrado con id: " + id));
    }

    @Override
    public Jugador save(Jugador jugador) {
//        ValidationUtil.validateAsignatura(asignatura);
        return jugadorRepository.save(jugador);
    }

    @Override
    public void deleteById(Long id) {
        if (!jugadorRepository.existsById(id)) {
            throw new EntityNotFoundException("No se puede eliminar, jugador no encontrado con id: " + id);
        }
        jugadorRepository.deleteById(id);
    }

    @Override
    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    @Override
    public void saveAll(List<Jugador> jugadores) {


//        for (Equipo equipo : equipos) {
//            ValidationUtil.validateAsignatura(asignatura);
//        }
        jugadorRepository.saveAll(jugadores);
    }

    public List<Jugador> findAllByJugadorId (Long id_jugador){
        return jugadorRepository.findAllByEquipoId(id_jugador);
    }

}
