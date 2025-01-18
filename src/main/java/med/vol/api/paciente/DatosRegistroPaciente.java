package med.vol.api.paciente;

import med.vol.api.dto.DatosDireccion;

public record DatosRegistroPaciente(
        String nombre,
        String email,
        String telefono,
        String documento,
        DatosDireccion direccion
) {
}
