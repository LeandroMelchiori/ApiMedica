package med.vol.api.medico;

import jakarta.validation.constraints.NotNull;
import med.vol.api.dto.DatosDireccion;

public record DatosActualizarMedico(
        @NotNull Long id,
        String nombre,
        String documento,
        DatosDireccion direccion
) {
}
