package med.vol.api.domain.requests;

import java.time.LocalDateTime;

public record DatosDetalleConsulta(
        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime fecha
) {
}
