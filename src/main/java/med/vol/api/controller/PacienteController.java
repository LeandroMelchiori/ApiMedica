package med.vol.api.controller;

import med.vol.api.paciente.DatosRegistroPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @PostMapping
    public void registrarPaciente(@RequestBody DatosRegistroPaciente datosRegistroPaciente){
        System.out.println("datos recibidos: " + datosRegistroPaciente);
    }
}
