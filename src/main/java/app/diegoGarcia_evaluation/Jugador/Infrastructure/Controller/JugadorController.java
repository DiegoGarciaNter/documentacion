package app.diegoGarcia_evaluation.Jugador.Infrastructure.Controller;

import app.diegoGarcia_evaluation.Equipo.Application.services.EquipoService;
import app.diegoGarcia_evaluation.Equipo.Domain.Entities.Equipo;
import app.diegoGarcia_evaluation.Jugador.Application.JugadorService;
import app.diegoGarcia_evaluation.Jugador.Domain.Entities.Jugador;
import app.diegoGarcia_evaluation.Jugador.Domain.Mapper.JugadorMapper;
import app.diegoGarcia_evaluation.Jugador.Infrastructure.DTO.JugadorInputDTO;
import app.diegoGarcia_evaluation.Jugador.Infrastructure.DTO.JugadorOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jugadores")
public class JugadorController {

    private final JugadorMapper jugadorMapper;
    private final JugadorService jugadorService;
    private final EquipoService equipoService;


    @GetMapping
    public ResponseEntity<?> getAllJugadores() {
        List<Jugador> result = jugadorService.findAll();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<JugadorOutputDTO> dtoList = result.stream()
                    .map(jugadorMapper::OutputJugadorToJugadorDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorOutputDTO> getJugadorById(@PathVariable Long id) {
        Jugador jugador = jugadorService.findById(id);
        return ResponseEntity.ok(jugadorMapper.OutputJugadorToJugadorDto(jugador));
    }


    @PostMapping
    public List<JugadorOutputDTO> createAll(@RequestBody List<JugadorInputDTO> jugadoresDTO) {


        List<Jugador> jugadores = jugadoresDTO.stream()
                .map(jugadorDTO -> {
                    Jugador jugador = new Jugador();
                    Long idEquipo = jugadorDTO.getId_equipo();
                    Equipo equipo = equipoService.findById(idEquipo);
                    jugador.setNombre(jugadorDTO.getNombre());
                    jugador.setApellidos(jugadorDTO.getApellidos());
                    jugador.setEdad(jugadorDTO.getEdad());
                    jugador.setEmail(jugadorDTO.getEmail());
                    jugador.setEquipo(equipo);
                    jugador.setPosicion(jugadorDTO.getPosicion());
                    return jugador;
                })
                .collect(Collectors.toList());

        jugadorService.saveAll(jugadores);

        return jugadores.stream()
                .map(jugadorMapper::OutputJugadorToJugadorDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> updateJugador(@PathVariable Long id, @RequestBody Jugador jugadorDetails) {


        Jugador jugador = jugadorService.findById(id);

        if (jugadorDetails.getNombre() != null) {
            jugador.setNombre(jugadorDetails.getNombre());
        }
        if (jugadorDetails.getApellidos() != null) {
            jugador.setApellidos(jugadorDetails.getApellidos());
        }
        if (jugadorDetails.getEdad() != 0) {
            jugador.setEdad(jugadorDetails.getEdad());
        }
        if (jugadorDetails.getEmail() != null) {
            jugador.setEmail(jugadorDetails.getEmail());
        }
        if (jugadorDetails.getPosicion() != null) {
            jugador.setPosicion(jugadorDetails.getPosicion());
        }

//        jugador.setEquipo(jugadorDetails.getEquipo());

        Jugador updatedJugador = jugadorService.save(jugador);
        return ResponseEntity.ok(updatedJugador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Jugador> deleteJugador(@PathVariable Long id) {
        Jugador jugador = jugadorService.findById(id);
        jugadorService.deleteById(id);
        return ResponseEntity.ok(jugador);
    }
}
