import java.util.Scanner;

public class RadioProgram {
    public static void main(String[] args) {
        IRadio radio = new Radio();
        Scanner scanner = new Scanner(System.in);
    }
    
    while (true) {
            System.out.println("Menu de la radio:");
            System.out.println("1. Encender o apagar");
            System.out.println("2. Cambiar AM/FM");
            System.out.println("3. Siguiente estación");
            System.out.println("4. Guardar estación");
            System.out.println("5. Seleccionar estación");
            System.out.println("6. Salir del programa");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    radio.switchOnOff();
                    System.out.println("La radio está " + (radio.isOn() ? "Encendida" : "Apagada"));
                    break;
                case 2:
                    radio.switchAMFM();
                    System.out.println("Cambiar a " + (radio.isAM() ? "AM" : "FM"));
                    break;
                case 3:
                    double nextStation = radio.nextStation();
                    System.out.println("Tuned en: " + nextStation);
                    break;
                case 4:
                    System.out.println("ID del botón (1-12): ");
                    int buttonId = scanner.nextInt();
                    System.out.println("Ingrese la frecuencia de la estación: ");
                    double station = scanner.nextDouble();
                    radio.saveStation(buttonId, station);
                    System.out.println("Estación guardada en el botón: " + buttonId);
                    break;
                case 5:
                    System.out.println("ID del botón (1-12): ");
                    int selectedButton = scanner.nextInt();
                    double selectedStation = radio.selectStation(selectedButton);
                    if (selectedStation > 0) {
                        System.out.println("Seleccione la estación: " + selectedStation);
                    } else {
                        System.out.println("No hay una estación guardada en el botón: " + selectedButton);
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida; ingrese un número del 1 al 6.");
            }
        }
    }

RADIO
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
    }MAIN
    while (true) {
                System.out.println("Menu de la radio:");
                System.out.println("1. Encender o apagar");
                System.out.println("2. Cambiar AM/FM");
                System.out.println("3. Siguiente estación");
                System.out.println("4. Guardar estación");
                System.out.println("5. Seleccionar estación");
                System.out.println("6. Salir del programa");
    
                int choice = scanner.nextInt();
    
                switch (choice) {
                    case 1:
                        radio.switchOnOff();
                        System.out.println("La radio está " + (radio.isOn() ? "Encendida" : "Apagada"));
                        break;
                    case 2:
                        radio.switchAMFM();
                        System.out.println("Cambiar a " + (radio.isAM() ? "AM" : "FM"));
                        break;
                    case 3:
                        double nextStation = radio.nextStation();
                        System.out.println("Tuned en: " + nextStation);
                        break;
                    case 4:
                        System.out.println("ID del botón (1-12): ");
                        int buttonId = scanner.nextInt();
                        System.out.println("Ingrese la frecuencia de la estación: ");
                        double station = scanner.nextDouble();
                        radio.saveStation(buttonId, station);
                        System.out.println("Estación guardada en el botón: " + buttonId);
                        break;
                    case 5:
                        System.out.println("ID del botón (1-12): ");
                        int selectedButton = scanner.nextInt();
                        double selectedStation = radio.selectStation(selectedButton);
                        if (selectedStation > 0) {
                            System.out.println("Seleccione la estación: " + selectedStation);
                        } else {
                            System.out.println("No hay una estación guardada en el botón: " + selectedButton);
                        }
                        break;
                    case 6:
                        System.out.println("Saliendo del programa.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción inválida; ingrese un número del 1 al 6.");
                }
            }
        }
    
    RADIO
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
