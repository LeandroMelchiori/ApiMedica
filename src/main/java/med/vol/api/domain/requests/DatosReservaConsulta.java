package med.vol.api.domain.requests;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.vol.api.domain.medico.Especialidad;

import java.time.LocalDateTime;

public record DatosReservaConsulta(
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future
        LocalDateTime fecha,
        Especialidad especialidad
) {
}
