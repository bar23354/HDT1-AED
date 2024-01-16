/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructura de Datos – sección 40
 * Roberto Barreda – 23354 | Lingna Chen - 23173
 */
 
/**
 * Implementación de la interfaz IRadio que representa un objeto de radio.
 */

import java.util.HashMap;
import java.util.Map;

class Radio implements IRadio {
    private boolean on;
    private boolean am;
    private double currentStation;
    private Map<Integer, Double> savedStations;

    public Radio() {
        this.on = false;
        this.am = true;
        this.currentStation = 530.0;
        this.savedStations = new HashMap<>();
    }

    @Override
    public void saveStation(int buttonId, double station) {
        if (am && station >= 530 && station <= 1610) {
            savedStations.put(buttonId, station);
        } else if (!am && station >= 87.9 && station <= 107.9) {
            savedStations.put(buttonId, station);
        } else {
            System.out.println("La estación no está en el rango permitido.");
        }
    }

    @Override
    public boolean isAM() {
        return am;
    }

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public double selectStation(int buttonId) {
        return savedStations.getOrDefault(buttonId, 0.0);
    }

    @Override
    public void switchOnOff() {
        on = !on;
        if (!on) {
            currentStation = 530.0; // Resetear la estación al apagar la radio
        }
    }

    @Override
    public void switchAMFM() {
        if (on) {
            am = !am;
            if (am) {
                currentStation = Math.max(currentStation, 530.0);
            } else {
                currentStation = Math.max(currentStation, 87.9);
            }
        } else {
            System.out.println("La radio está apagada. Enciéndala para cambiar AM/FM.");
        }
    }

    @Override
    public double nextStation() {
        if (on) {
            if (am) {
                currentStation += 10.0;
                if (currentStation > 1610.0) {
                    currentStation = 530.0; // regreso en "loop" al inicio del rango AM
                }
            } else {
                currentStation += 0.2;
                if (currentStation > 107.9) {
                    currentStation = 87.9; // regreso en "loop" al inicio del rango FM
                }
            }

            currentStation = Math.round(currentStation * 10.0) / 10.0;
        } else {
            System.out.println("Enciende la radio antes de seleccionar la siguiente estación.");
        }
        return currentStation;
    }
}