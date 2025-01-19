package med.vol.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import med.vol.api.domain.direccion.DatosDireccion;

public record DatosActualizacionPaciente(
        Long id,
        String nombre,
        @Email String email,
        String telefono,
        String documentoIdentidad,
        @Valid DatosDireccion direccion
) {
}