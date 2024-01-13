import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IRadio radio = new Radio();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("*************************************");
                System.out.println("Menu de la radio:");
                System.out.println("1. Encender o apagar");
                System.out.println("2. Cambiar AM/FM");
                System.out.println("3. Siguiente estación");
                System.out.println("4. Guardar estación");
                System.out.println("5. Seleccionar estación");
                System.out.println("6. Salir del programa");
                System.out.println("*************************************");

                int choice = 0;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Intente nuevamente.");
                    scanner.next();
                    continue;
                }

                switch (choice) {
                    case 1:
                        radio.switchOnOff();
                        System.out.println("La radio está " + (radio.isOn() ? "Encendida" : "Apagada"));
                        break;
                    case 2:
                        if (radio.isOn()) {
                            radio.switchAMFM();
                            System.out.println("Cambiar a " + (radio.isAM() ? "AM" : "FM"));
                        } else {
                            System.out.println("La radio está apagada. Enciéndala para cambiar AM/FM.");
                        }
                        break;
                    case 3:
                        if (radio.isOn()) {
                            double nextStation = radio.nextStation();
                            System.out.println("Tuned en: " + String.format("%.1f", nextStation));
                        } else {
                            System.out.println("La radio está apagada. Enciéndala para sintonizar la siguiente estación.");
                        }
                        break;
                    case 4:
                        if (radio.isOn()) {
                            System.out.println("ID del botón (1-12): ");
                            int buttonId = 0;
                            try {
                                buttonId = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida para el ID del botón. Intente nuevamente.");
                                scanner.next();
                                continue;
                            }

                            System.out.println("Ingrese la frecuencia de la estación: ");
                            double station = 0.0;
                            try {
                                station = scanner.nextDouble();
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida para la frecuencia de la estación. Intente nuevamente.");
                                scanner.next();
                                continue;
                            }

                            radio.saveStation(buttonId, station);
                            System.out.println("Estación guardada en el botón: " + buttonId);
                        } else {
                            System.out.println("La radio está apagada. Enciéndala para guardar una estación.");
                        }
                        break;
                    case 5:
                        if (radio.isOn()) {
                            System.out.println("ID del botón (1-12): ");
                            int selectedButton = 0;
                            try {
                                selectedButton = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida para el ID del botón. Intente nuevamente.");
                                scanner.next();
                                continue;
                            }

                            double selectedStation = radio.selectStation(selectedButton);
                            if (selectedStation > 0) {
                                System.out.println("Seleccione la estación: " + selectedStation);
                            } else {
                                System.out.println("No hay una estación guardada en el botón: " + selectedButton);
                            }
                        } else {
                            System.out.println("La radio está apagada. Enciéndala para seleccionar una estación.");
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
    }
}