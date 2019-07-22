package tarea1estructuras;

import java.util.Scanner;

public class MenuCalendario {

    Scanner scanner = new Scanner(System.in);
    Fecha fecha = new Fecha();
    Criba criba = new Criba();
    boolean condicion = false;

    public MenuCalendario() {

        System.out.println("");
        System.out.println("");
        System.out.println("***--------------BIENVENIDO----------------***");
        System.out.println(" **----------------Tarea 1----------------**");
        System.out.println("");
        System.out.println("");
        do {
            try {
                condicion = false;
                System.out.println(menuPrincipal());
                validador(scanner.nextInt());
                condicion = true;
            } catch (Exception e) {
                System.out.println("Caracter invalido");
                scanner.nextLine();
                condicion = true;
            }
        } while (condicion);
    }

    private void validador(int opcion) {
        //Scanner scanner = new Scanner(System.in);

        switch (opcion) {
            case 1:
                System.out.println("------------------------------------------");
                fecha.SeleccionarFecha();
                System.out.println(menuPrincipal());
                validador(scanner.nextInt());

                break;

            case 2:
                System.out.println("------------------------------------------");
                criba.Npares();
                System.out.println(menuPrincipal());
                validador(scanner.nextInt());
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("------------------------------------------");
                System.out.println("Por favor ingrese un numero de 1 a 3");
                System.out.println(menuPrincipal());
                validador(scanner.nextInt());
                break;
        }

    }

   

    public String menuPrincipal() {
        return String.format("[1] Ingresar Fecha%n"
                + "[2] Criba de Eratóstenes%n"
                + "[3] Salir%n"
                + "Seleccionar:");

    }
  
}
