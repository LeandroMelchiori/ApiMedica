package med.vol.api.domain.requests.validaciones.reserva;

import med.vol.api.domain.ValidacionException;
import med.vol.api.domain.requests.DatosReservaConsulta;
import med.vol.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoActivo implements ValidadorDeConsultas {

    @Autowired
    private MedicoRepository repositrory;

    public void validar(DatosReservaConsulta datos) {
        //eleccion del medico opcional
        if(datos.idMedico() == null) {
            return;
        }
        var medicoEstaActivo = repositrory.findActivoById(datos.idMedico());
        if(!medicoEstaActivo){
            throw new ValidacionException("Consulta no puede ser reservada con medico excluido");
        }
    }
}
