package app.diegoGarcia_evaluation.Equipo.Infrastructure.Controller;


import app.diegoGarcia_evaluation.Equipo.Application.services.EquipoService;
import app.diegoGarcia_evaluation.Equipo.Domain.Mapper.EquipoMapper;
import app.diegoGarcia_evaluation.Equipo.Domain.Entities.Equipo;
import app.diegoGarcia_evaluation.Equipo.Infrastructure.DTO.EquipoInputDTO;
import app.diegoGarcia_evaluation.Equipo.Infrastructure.DTO.EquipoOutputDTO;
import app.diegoGarcia_evaluation.Jugador.Application.JugadorService;
import app.diegoGarcia_evaluation.Jugador.Domain.Entities.Jugador;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipos")
public class EquipoController {

    private final EquipoMapper equipoMapper;
    private final EquipoService equipoService;
    private final JugadorService jugadorService;

    @GetMapping
    public ResponseEntity<?> getAllEquipos() {
        List<Equipo> result = equipoService.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<EquipoOutputDTO> dtoList = result.stream()
                    .map(equipoMapper::OutputEquipoToEquipoDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoOutputDTO> getEquipoById(@PathVariable Long id) {
        Equipo equipo = equipoService.findById(id);
        return ResponseEntity.ok(equipoMapper.OutputEquipoToEquipoDto(equipo));
    }

    @PostMapping
    public List<EquipoInputDTO> createAll(@RequestBody List<EquipoInputDTO> equiposDTO) {

        List<Equipo> equipos = equiposDTO.stream()
                .map(equipoDTO ->{
                    Equipo equipo = new Equipo();
                    equipo.setNombre_equipo(equipoDTO.getNombre_equipo());
                    equipoService.save(equipo);

                    List<Jugador> jugadores = new ArrayList<>();
                    if (equipoDTO.getId_jugadores() != null) {
                        for(long id_jugador: equipoDTO.getId_jugadores()){
                            Jugador jugador = jugadorService.findById(id_jugador);
                            jugador.setEquipo(equipo);
                            jugadorService.save(jugador);
                            jugadores.add(jugador);
                        }
                    }
                    equipo.setJugadores(jugadores);
                    return equipo;
                })
                .collect(Collectors.toList());


        equipoService.saveAll(equipos);
        return equipos.stream()
                .map(equipoMapper::InputEquipoToEquipoDto)
                .collect(Collectors.toList());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable Long id, @RequestBody Equipo equipoDetails) {
        Equipo equipo = equipoService.findById(id);
        equipo.setNombre_equipo(equipoDetails.getNombre_equipo());
        Equipo updatedEquipo = equipoService.save(equipo);
        return ResponseEntity.ok(updatedEquipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Equipo> deleteEquipo(@PathVariable Long id) {
        Equipo equipo = equipoService.findById(id);
        equipoService.deleteById(id);
        return ResponseEntity.ok(equipo);
    }
}
