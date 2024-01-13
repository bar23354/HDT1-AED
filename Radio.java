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
        savedStations.put(buttonId, station);
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
    }

    @Override
    public void switchAMFM() {
        am = !am;
        if (am) {
            currentStation = Math.max(currentStation, 530.0); // cambio a AM y ajuste necesario de frecuencia
        } else {
            currentStation = Math.max(currentStation, 87.9); // cambio a FM y ajuste necesario de frecuencia
        }
    }

    @Override
    public double nextStation() {
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
        return currentStation;
    }
}






