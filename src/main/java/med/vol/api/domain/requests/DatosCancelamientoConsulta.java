package med.vol.api.domain.requests;

import jakarta.validation.constraints.NotNull;

public record DatosCancelamientoConsulta(
        @NotNull
        Long idConsulta,
        @NotNull
        MotivoCancelamiento motivo) {
}