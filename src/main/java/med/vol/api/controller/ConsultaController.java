package med.vol.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.domain.requests.DatosCancelamientoConsulta;
import med.vol.api.domain.requests.DatosDetalleConsulta;
import med.vol.api.domain.requests.DatosReservaConsulta;
import med.vol.api.domain.requests.ReservaDeConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ReservaDeConsultas reserva;

    @PostMapping
    @Transactional
    public ResponseEntity reservar(@RequestBody @Valid DatosReservaConsulta datos){
        reserva.reservar(datos);
        System.out.println(datos);
        return ResponseEntity.ok(new DatosDetalleConsulta(null,null,null,null));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DatosCancelamientoConsulta datos) {
        reserva.cancelar(datos);
        return ResponseEntity.noContent().build();
    }
}
