package med.vol.api.domain.requests;

import jakarta.validation.ValidationException;
import med.vol.api.domain.ValidacionException;
import med.vol.api.domain.medico.Medico;
import med.vol.api.domain.medico.MedicoRepository;
import med.vol.api.domain.paciente.PacienteRepository;
import med.vol.api.domain.requests.validaciones.reserva.ValidadorDeConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaDeConsultas {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private List<ValidadorDeConsultas> validadores;

    public void reservar(DatosReservaConsulta datos) {
        if (!pacienteRepository.existsById(datos.idPaciente())){
            throw new ValidacionException("no existe un paciente con el id informado");
        }
        if (datos.idMedico() != null && !medicoRepository.existsById(datos.idMedico())){
            throw new ValidacionException("no existe un medico con el id informado");
        }
        var medico = elegirMedico(datos);
        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
        var consulta = new Consulta(null, medico, paciente, datos.fecha(), null);
        consultaRepository.save(consulta);

        // validaciones
        validadores.forEach(v -> v.validar(datos));
    }

    private Medico elegirMedico(DatosReservaConsulta datos) {
        if(datos.idMedico() != null){
            return medicoRepository.getReferenceById(datos.idMedico());
        }
        if(datos.especialidad() == null){
            throw new ValidacionException("Obligatorio elegir especialidad cuando no elige un medico");
        }
        return medicoRepository.elegirFechaDisponibleMedicoAleatorio(datos.especialidad(), datos.fecha());
    }

    public void cancelar(DatosCancelamientoConsulta datos) {
        if (!consultaRepository.existsById(datos.idConsulta())) {
            throw new ValidacionException("¡El Id informado de la consulta no existe!");
        }



        var consulta = consultaRepository.getReferenceById(datos.idConsulta());
        consulta.cancelar(datos.motivo());
    }
}