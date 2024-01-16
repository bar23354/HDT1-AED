/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructura de Datos – sección 40
 * Roberto Barreda – 23354 | Lingna Chen - 23173
 */

/**
 * Interfaz que define el contrato para un objeto de radio.
 */
interface IRadio {
    /**
     * Guarda la estación actual en un botón específico.
     *
     * @param buttonId Identificación del botón en el que se guardará la estación.
     * @param station  Frecuencia de la estación que se va a guardar.
     */
    void saveStation(int buttonId, double station);

    /**
     * Verifica si la radio está sintonizada en AM.
     *
     * @return true si la radio está en modo AM, false si está en modo FM.
     */
    boolean isAM();

    /**
     * Verifica si la radio está encendida.
     *
     * @return true si la radio está encendida, false si está apagada.
     */
    boolean isOn();

    /**
     * Selecciona la estación guardada en un botón específico.
     *
     * @param buttonId Identificación del botón del cual se seleccionará la estación.
     * @return Frecuencia de la estación seleccionada, o 0.0 si no hay ninguna estación guardada en el botón.
     */
    double selectStation(int buttonId);

    /**
     * Enciende o apaga la radio.
     */
    void switchOnOff();

    /**
     * Cambia entre los modos AM y FM de la radio.
     */
    void switchAMFM();

    /**
     * Sintoniza la siguiente estación disponible.
     *
     * @return Frecuencia de la siguiente estación sintonizada.
     */
    double nextStation();
}