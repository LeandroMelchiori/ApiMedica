package med.vol.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import org.antlr.v4.runtime.misc.MultiMap;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Boolean findActivoById(@NotNull Long aLong);
}