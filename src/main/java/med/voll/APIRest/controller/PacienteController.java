package med.voll.APIRest.controller;

import med.voll.APIRest.paciente.DatosRegistroPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @PostMapping
    public void registrarPaciente(@RequestBody DatosRegistroPaciente pacinete){
        System.out.println("Datos recibidos: " + pacinete);
    }
}
