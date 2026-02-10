import java.util.Scanner;
import java.util.Stack;

public class Main {

    static final int maxLineas = 10;

    public static void mostrarFichero(String[] lineas, int lineaActiva) {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < maxLineas; i++) {
            String marca = (i == lineaActiva) ? "*" : " ";
            System.out.println(i + ":" + marca + "| " + lineas[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lineas = new String[maxLineas];
        Stack<String[]> historial = new Stack<>();

        
        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[I] permite intercambiar dos lineas";
        lineas[6] = "[B] borra el contenido de la linea activa";
        lineas[7] = "[D] deshace la ultima accion realizada";
        lineas[8] = "[S] sale del programa";
        lineas[9] = "";

        int lineaActiva = 1;

        while (true) {
            mostrarFichero(lineas, lineaActiva);
            System.out.print(">> ");
            String comando = scanner.nextLine().toUpperCase();

            if (comando.equals("S")) {
                System.out.println("Saliendo de EDLIN...");
                break;
            }

            else if (comando.equals("L")) {
                System.out.print("Numero de linea activa (0-9): ");
                try {
                    int nuevaLinea = Integer.parseInt(scanner.nextLine());
                    if (nuevaLinea >= 0 && nuevaLinea < maxLineas) {
                        lineaActiva = nuevaLinea;
                    } else {
                        System.out.println("Linea fuera de rango");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida");
                }
            }

            else if (comando.equals("E")) {
                historial.push(lineas.clone());
                System.out.print("Nuevo contenido: ");
                lineas[lineaActiva] = scanner.nextLine();
            }

            else if (comando.equals("B")) {
                historial.push(lineas.clone());
                lineas[lineaActiva] = "";
            }

            else if (comando.equals("I")) {
                try {
                    System.out.print("Primera linea (0-9): ");
                    int linea1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Segunda linea (0-9): ");
                    int linea2 = Integer.parseInt(scanner.nextLine());

                    if (linea1 >= 0 && linea1 < maxLineas && linea2 >= 0 && linea2 < maxLineas) {
                        historial.push(lineas.clone());
                        String temp = lineas[linea1];
                        lineas[linea1] = lineas[linea2];
                        lineas[linea2] = temp;
                    } else {
                        System.out.println("Lineas fuera de rango");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida");
                }
            }

            else if (comando.equals("D")) {
                if (!historial.isEmpty()) {
                    lineas = historial.pop();
                } else {
                    System.out.println("No hay acciones para deshacer");
                }
            }

            else {
                System.out.println("Comando no reconocido");
            }
        }

        scanner.close();
    }
}
