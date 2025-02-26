package med.vol.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vol.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(
        @NotBlank
        String nombre,
        @NotBlank(message = "{email.obligatorio}")
        @Email(message = "{email.invalido}")
        String email,
        @NotBlank
        String telefono,
        @NotBlank @Pattern(regexp = "\\d{4,9}")
        String documento,
        @NotNull
        Especialidad especialidad,
        @NotNull @Valid
        DatosDireccion direccion
) {
}