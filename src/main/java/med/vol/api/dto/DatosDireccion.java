package med.vol.api.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(
        @NotBlank String calle,
        @NotBlank String numero,
        @NotBlank String distrito,
        @NotBlank String complemento,
        @NotBlank String ciudad
) {
}
