//Importaciones necesarias para la ejecución del programa

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;



public class sorteo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("BIENVENIDO AL SORTEO");
        String respuestaUsuario;
        
        // Preguntaremos al usuario hasta que nos responda correctamente
        while (true) {
            System.out.print("Desea participar? (si/no): ");
            respuestaUsuario = scanner.nextLine();
            if (respuestaUsuario.equalsIgnoreCase("si") || respuestaUsuario.equalsIgnoreCase("no")) {
                break; 
            }
            System.out.println("Respuesta no valida. Por favor, ingrese 'si' o 'no'.");
        }

        if (respuestaUsuario.equalsIgnoreCase("no")) {
            System.out.println("Programa finalizado.");
            return;
        }
        
        boolean repetir = true;
        while (repetir) {
            int boletos = 0;

            //Opciones de los boletos y su sorteo
            System.out.println("Opciones disponibles:");
            System.out.println("1 boleto --> (1-10)");
            System.out.println("2 boletos --> (1-20)");
            System.out.println("3 boletos --> (1-30)");
            System.out.println("4 boletos --> (1-40)");
            System.out.println("5 boletos --> (1-50)");

            // Seleccionar el numero de boletos con excepciones
            while (true) {

                System.out.print("Cuantos boletos quiere (1 a 5)? ");

                try {
                    boletos = scanner.nextInt();
                    if (boletos >= 1 && boletos <= 5) {
                        break;
                    } else {
                        System.out.println("Por favor, ingrese un numero entre 1 y 5.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Escriba un valor numerico");
                    scanner.next();
                }
            }

            //Especificamos en rango
            int rangoMaximo;

            switch (boletos) {
                case 1: rangoMaximo = 10; break;
                case 2: rangoMaximo = 20; break;
                case 3: rangoMaximo = 30; break;
                case 4: rangoMaximo = 40; break;
                case 5: rangoMaximo = 50; break;
                
                default:
                    System.out.println("Cantidad invalida de boletos. Intente de nuevo.");
                    continue;
            }

            // Genera el numero ganador
            int numeroGanador = random.nextInt(rangoMaximo) + 1;
            boolean acierto = false;

            // Pedimos los numero al usaurio
            for (int i = 1; i <= boletos; i++) {
                int numeroUsuario = 0;

                while (true) {
                    System.out.print("Inserta el " + i + " numero entre 1 y " + rangoMaximo + ": ");

                    try {
                        numeroUsuario = scanner.nextInt();
                        //  Se verifica si el numero ingresado esta dentro del rango
                        if (numeroUsuario < 1 || numeroUsuario > rangoMaximo) {
                            System.out.println("Numero fuera de rango. Intente de nuevo.");
                            continue;
                        }
                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Entrada no valida. Por favor, ingrese un numero.");
                        scanner.next(); 
                        
                    }
                }

                // Se verificar si acierta
                if (numeroUsuario == numeroGanador) {
                    acierto = true;
                }
            }
            
            // Resultado final
            if (acierto) {
                System.out.println("¡FELICITACIONES! Has adivinado el numero ganador: " + numeroGanador);
            } else {
                System.out.println("JAJAJA ERES EL PERDEDOR otro dia sera , el numero ganador era: " + numeroGanador );
            }
            
            // Preguntar si quiere repetir

            System.out.print("Quiere repetir el sorteo? (si/no): ");
            scanner.nextLine();  // Limpiar el buffer
            String repetirSorteo = scanner.nextLine();
            if (!repetirSorteo.equalsIgnoreCase("si")) {
                repetir = false;
            }
        }
        
        //Salimos del programa
        System.out.println("SALIENDO DEL PROGRAMA HASTA LUEGO");
    }
}