package app.block5crudvalidation.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CrearPersonaController {

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        return "formulario";
    }
}
