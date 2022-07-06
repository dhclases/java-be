package com.dh.demo.saa;

import com.dh.demo.mockito.MockitoExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AirConditioningSystemTest {

    @InjectMocks
    SistemaAireAcondicionado sistemaAA;

    @Mock
    Termometro termometro;

    @Test
    @DisplayName("Cuando se activa el AA")
    void probarActivacionDelAA() {
        when(termometro.getTemperatura()).thenReturn(25.0);
        sistemaAA.setLimiteTemperatura(24.0);
        sistemaAA.verificarTemperatura();
        assertTrue(sistemaAA.isActivo());
        verify(termometro, times(1)).getTemperatura();
    }

    @Test
    @DisplayName("Cuando se desactiva el AA")
    void probarDesactivarSistemaAA() {
        when(termometro.getTemperatura()).thenReturn(23.0);
        sistemaAA.setLimiteTemperatura(24.0);
        sistemaAA.verificarTemperatura();
        assertFalse(sistemaAA.isActivo());
        verify(termometro, times(1)).getTemperatura();
    }

}