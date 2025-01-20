package med.vol.api.domain.requests.validaciones.reserva;

import med.vol.api.domain.ValidacionException;
import med.vol.api.domain.requests.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidacionConsultaConAnticipacion implements ValidadorDeConsultas {
    public void validar(DatosReservaConsulta datos) {
        var fechaConsulta = datos.fecha();
        var ahora = LocalDateTime.now();
        var diferenciaEnMinutos = Duration.between(ahora, fechaConsulta).toMinutes();
        if (diferenciaEnMinutos < 30) {
            throw new ValidacionException("Horario seleccionada menor que 30 minutos de anticipacion");
        }
    }
}
