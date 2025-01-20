package med.vol.api.domain.requests.validaciones.cancelamiento;

import med.vol.api.domain.requests.DatosCancelamientoConsulta;

public interface ValidadorCancelamientoDeConsulta {
    void validar(DatosCancelamientoConsulta datos);
}