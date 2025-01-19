package med.vol.api.domain.paciente;

public record DatosListaPaciente(
        Long id,
        String nombre,
        String email,
        String documento_identidad
) {
    public DatosListaPaciente(Paciente paciente) {
        this(paciente.getId(),paciente.getNombre(), paciente.getEmail(), paciente.getDocumento_identidad());
    }
}