import java.util.Scanner;

public class Conversor {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int tipo;
        int opcion;
        double valor;
        double resultado;

        System.out.println("CONVERSOR DE UNIDADES");

        System.out.println("1. Longitud");
        System.out.println("2. Peso");
        System.out.println("3. Temperatura");

        System.out.print("Elige tipo: ");
        tipo = entrada.nextInt();

        if (tipo == 1) {

            System.out.println("1. m a km");
            System.out.println("2. km a m");
            System.out.println("3. m a mi");
            System.out.println("4. mi a m");

            System.out.print("Opcion: ");
            opcion = entrada.nextInt();

            System.out.print("Valor: ");
            valor = entrada.nextDouble();

            if (opcion == 1) resultado = valor / 1000;
            else if (opcion == 2) resultado = valor * 1000;
            else if (opcion == 3) resultado = valor * 0.000621371;
            else if (opcion == 4) resultado = valor * 1609.34;
            else {
                System.out.println("Opcion incorrecta");
                return;
            }

            System.out.println("Resultado: " + resultado);
        }

        else if (tipo == 2) {

            System.out.println("1. kg a g");
            System.out.println("2. g a kg");
            System.out.println("3. kg a lb");
            System.out.println("4. lb a kg");

            System.out.print("Opcion: ");
            opcion = entrada.nextInt();

            System.out.print("Valor: ");
            valor = entrada.nextDouble();

            if (opcion == 1) resultado = valor * 1000;
            else if (opcion == 2) resultado = valor / 1000;
            else if (opcion == 3) resultado = valor * 2.20462;
            else if (opcion == 4) resultado = valor * 0.453592;
            else {
                System.out.println("Opcion incorrecta");
                return;
            }

            System.out.println("Resultado: " + resultado);
        }

        else if (tipo == 3) {

            System.out.println("1. C a F");
            System.out.println("2. F a C");
            System.out.println("3. C a K");
            System.out.println("4. K a C");

            System.out.print("Opcion: ");
            opcion = entrada.nextInt();

            System.out.print("Valor: ");
            valor = entrada.nextDouble();

            if (opcion == 1) resultado = valor * 9 / 5 + 32;
            else if (opcion == 2) resultado = (valor - 32) * 5 / 9;
            else if (opcion == 3) resultado = valor + 273.15;
            else if (opcion == 4) resultado = valor - 273.15;
            else {
                System.out.println("Opcion incorrecta");
                return;
            }

            System.out.println("Resultado: " + resultado);
        }

        else {
            System.out.println("Tipo incorrecto");
        }

        entrada.close();
    }
}



