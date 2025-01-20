package med.vol.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.vol.api.domain.direccion.Direccion;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String nombre;
    private String email;
    private String documento_identidad;
    private String telefono;
    @Embedded
    private Direccion direccion;

    private Boolean activo;

    public Paciente() {}

    public Paciente(DatosRegistroPaciente datos) {
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documento_identidad = datos.documentoIdentidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public void actualizarInformacion(DatosActualizacionPaciente datos) {
        if (datos.nombre() != null)
            this.nombre = datos.nombre();

        if (datos.telefono() != null)
            this.telefono = datos.telefono();

        if (datos.direccion() != null)
            direccion.actualizarDatos(datos.direccion());
    }

    public void inactivar() {
        this.activo = false;
    }

    public Long getId() {
        return id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }
}