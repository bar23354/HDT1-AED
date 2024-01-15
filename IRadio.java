/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructura de Datos – sección 40
 * Roberto Barreda – 23354 | Lingna Chen - 23173
 */

interface IRadio {
    void saveStation(int buttonId, double station);
    boolean isAM();
    boolean isOn();
    double selectStation(int buttonId);
    void switchOnOff();
    void switchAMFM();
    double nextStation();
}