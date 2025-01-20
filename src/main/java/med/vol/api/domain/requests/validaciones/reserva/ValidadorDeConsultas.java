package med.vol.api.domain.requests.validaciones.reserva;

import med.vol.api.domain.requests.DatosReservaConsulta;

public interface ValidadorDeConsultas {
    void validar(DatosReservaConsulta datos);
}
