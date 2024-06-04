package app.diegoGarcia_evaluation.Equipo.Application.services;

import app.diegoGarcia_evaluation.Equipo.Domain.Entities.Equipo;
import app.diegoGarcia_evaluation.Equipo.Infrastructure.Repository.EquipoRepository;
import app.diegoGarcia_evaluation.Exceptions.EntityNotFoundException;
import app.diegoGarcia_evaluation.Jugador.Infrastructure.Repository.JugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;
    private final JugadorRepository jugadorRepository;

//    @Override
//    public Equipo findById(Long id) {
//        return equipoRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Equipo no encontrado con id: " + id));
//    }

    @Override
    public Equipo findById(Long id) {
        Equipo e = equipoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Equipo no encontrado con id: " + id));
        e.setJugadores(jugadorRepository.findAllByEquipoId(id));
        return e;
    }

    @Override
    public List<Equipo> findAll() {
        List<Equipo> equipos = equipoRepository.findAll();
        for(Equipo equipo: equipos){
            equipo.setJugadores(jugadorRepository.findAllByEquipoId(equipo.getId()));
        }
        return equipos;
    }


    @Override
    public Equipo save(Equipo equipo) {
//        ValidationUtil.validateAsignatura(asignatura);
        return equipoRepository.save(equipo);
    }

    @Override
    public void deleteById(Long id) {
        if (!equipoRepository.existsById(id)) {
            throw new EntityNotFoundException("No se puede eliminar, equipo no encontrado con id: " + id);
        }
        equipoRepository.deleteById(id);
    }


    @Override
    public void saveAll(List<Equipo> equipos) {
//        for (Equipo equipo : equipos) {
//            ValidationUtil.validateAsignatura(asignatura);
//        }
        equipoRepository.saveAll(equipos);
    }

}
