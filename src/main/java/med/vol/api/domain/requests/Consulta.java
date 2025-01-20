package med.vol.api.domain.requests;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import med.vol.api.domain.medico.Medico;
import med.vol.api.domain.paciente.Paciente;
import med.vol.api.domain.requests.MotivoCancelamiento;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime fecha;

    @Column(name = "motivo_cancelamiento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamiento motivoCancelamiento;

    public Consulta() {}

    public void cancelar(MotivoCancelamiento motivo) {
        this.motivoCancelamiento = motivo;
    }
    public Consulta(Long id, Medico medico, Paciente paciente, LocalDateTime fecha, MotivoCancelamiento motivoCancelamiento) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.fecha = fecha;
        this.motivoCancelamiento = motivoCancelamiento;
    }

    public Long getId() {
        return id;
    }

    public MotivoCancelamiento getMotivoCancelamiento() {
        return motivoCancelamiento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }
}
