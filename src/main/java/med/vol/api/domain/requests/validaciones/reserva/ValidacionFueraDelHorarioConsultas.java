package med.vol.api.domain.requests.validaciones.reserva;

import med.vol.api.domain.ValidacionException;
import med.vol.api.domain.requests.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidacionFueraDelHorarioConsultas implements ValidadorDeConsultas {
    public void validar(DatosReservaConsulta datos){
        var fechaConsulta = datos.fecha();
        var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAntesDeAperturaClinica = fechaConsulta.getHour() < 7;
        var horarioDespuesDeCierreClinica = fechaConsulta.getHour() > 18;
        if (domingo || horarioAntesDeAperturaClinica || horarioDespuesDeCierreClinica){
            throw new ValidacionException("Horario seleccionada fuera del horario de atendimiento de la clinica");
        }
    }
}
