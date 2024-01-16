/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructura de Datos – sección 40
 * Roberto Barreda – 23354 | Lingna Chen - 23173
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RadioTest {

    @Test
    void testSwitchOnOff() {
        Radio radio = new Radio();

        // Verifica que inicialmente la radio esté apagada
        assertFalse(radio.isOn());

        // Enciende la radio y verifica que esté encendida
        radio.switchOnOff();
        assertTrue(radio.isOn());

        // Apaga la radio y verifica que esté apagada nuevamente
        radio.switchOnOff();
        assertFalse(radio.isOn());
    }

    @Test
    void testSwitchAMFM() {
        Radio radio = new Radio();
    
        // Verifica que inicialmente la radio esté en modo AM
        assertTrue(radio.isAM());
    
        // Cambia a modo FM y verifica que esté en modo FM
        radio.switchAMFM();
        assertTrue(radio.isAM()); // Verifica que la radio esté en modo FM
        assertFalse(radio.isOn());  // Verifica que la radio esté encendida
    
        // Cambia nuevamente a modo AM y verifica que esté en modo AM
        radio.switchAMFM();
        assertTrue(radio.isAM());
    }
    

    @Test
    void testNextStation() {
        Radio radio = new Radio();

        // Verifica que, al principio, la próxima estación sea la correcta en modo AM
        assertEquals(530.0, radio.nextStation());

        // Enciende la radio y avanza a la siguiente estación en modo AM
        radio.switchOnOff();
        assertEquals(540.0, radio.nextStation());

        // Cambia a modo FM y avanza a la siguiente estación en modo FM
        radio.switchAMFM();
        assertEquals(87.9, radio.nextStation());
    }
}

