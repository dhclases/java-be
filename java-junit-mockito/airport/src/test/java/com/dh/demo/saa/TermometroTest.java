package com.dh.demo.saa;

import com.dh.demo.mockito.MockitoExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Dada las condiciones del termometro")
class TermometroTest {

    @InjectMocks
    Termometro termometro;

    @Mock
    Sensor sensor;

    @Test
    @DisplayName("Cuando funciona el Sensor")
    void probarFuncionamientoDelSensor() {
        termometro.setTemperatura(25.0);
        when(sensor.isBlocked()).thenReturn(false);
        assertEquals(sensor, termometro.getSensor());
        assertEquals(25.0, termometro.getTemperatura(), 0.001);
        verify(sensor, times(1)).isBlocked();
    }

    @Test
    @DisplayName("Cuando no funciona el Sensor")
    void testBlockedSensor() {
        termometro.setTemperatura(25.0);
        when(sensor.isBlocked()).thenReturn(true);
        assertEquals(sensor, termometro.getSensor());
        assertThrows(RuntimeException.class, () -> termometro.getTemperatura());
        verify(sensor, times(1)).isBlocked();
    }

}
