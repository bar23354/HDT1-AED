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
}