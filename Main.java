import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IRadio radio = new Radio();
        try (Scanner scanner = new Scanner(System.in)) {
            {
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
        }
    }
}