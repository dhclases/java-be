package test.com.dh.medicamentos.service;

import com.dh.clinica.dao.impl.PacienteDaoH2;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.PacienteService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicamentoServiceTest {

    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @Test
    public void guardarMedicamentoTest() {
        Paciente paciente = new Paciente("Ibuprofeno", "lab123", 1000, 200.0);
        pacienteService.guardar(paciente);
        assertTrue(pacienteService.buscar(1) != null);

    }

    @Test
    public void buscarPorIdTest() {
        Paciente paciente = pacienteService.buscar(1);
        assertTrue(paciente != null);
    }
}
