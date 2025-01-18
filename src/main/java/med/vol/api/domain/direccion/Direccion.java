package med.vol.api.domain.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class Direccion {
    private String calle;
    private String distrito;
    private String ciudad;
    private String numero;
    private String complemento;

    // Constructor sin argumentos explícito
    public Direccion() {}

    public Direccion(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.distrito = direccion.distrito();
        this.complemento = direccion.complemento();
        this.ciudad = direccion.ciudad();
    }

    public Direccion actualizarDatos(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.distrito = direccion.distrito();
        this.complemento = direccion.complemento();
        this.ciudad = direccion.ciudad();
        return this;
    }

    public String getCalle() {
        return calle;
    }

    public String getDistrito() {
        return distrito;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }
}
