package med.vol.api.domain.requests;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Boolean existsByMedicoIdAndFecha(Long aLong, @NotNull @Future LocalDateTime fecha);

    Boolean existsByPacienteIdAndFechaBetween(@NotNull Long aLong, LocalDateTime primerHorario, LocalDateTime ultimoHorario);
}
