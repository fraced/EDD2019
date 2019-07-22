package tarea1estructuras;

import java.util.Scanner;

public class Fecha {

    int d = 0;
    int a = 0;
    int m = 0;
    int resultado;
    int A = 0;
    int B = 0;
    int C = 0;
    int D = 0;
    int E = 0;
    /////////////////
    int cuartoD=0;
    int tercerD=0;
    /////////////////
    String unir="";
    ///////////////////
    int valorB=0;
    //////////
    int comprobar=0;
    int comprobar2=0;
    ////////////////////
    boolean condicion = false;
    boolean entrar = false;

    Scanner fecha = new Scanner(System.in);

    public void SeleccionarFecha() {
        do {
            System.out.println("---------------------------------------");
            System.out.println("Ingrese dia");
            try {
                
                d = fecha.nextInt();
                condicion = false;
            } catch (Exception e) {
                condicion = true;
                System.out.println("---------------------------------------");
                System.out.println("Caracter incorrecto, Ingrese un Numero");
                fecha.nextLine();

            }
        } while (condicion);
        condicion = false;
        do {
            System.out.println("---------------------------------------");
            System.out.println("Ingrese Mes");
            try {
                
                m = fecha.nextInt();
                condicion = false;
            } catch (Exception e) {
                System.out.println("---------------------------------------");
                System.out.println("Caracter incorrecto, Ingrese un Numero");
                fecha.nextLine();
                
                condicion = true;
            }
        } while (condicion);

        condicion = false;
        do {
            System.out.println("---------------------------------------");
            System.out.println("Ingrese Año");
            try {
                
                a = fecha.nextInt();
                condicion = false;
            } catch (Exception e) {
                System.out.println("---------------------------------------");
                System.out.println("Caracter incorrecto, Ingrese un Numero");
                fecha.nextLine();
                
                condicion = true;
            }
        } while (condicion);
        condicion = false;
        entrar=false;
        while (entrar == false) {
            if (d >= 1 && d <= 31) {
                //entrar=true;
                if (m >= 1 && m <= 12) {
                    //entrar=true;
                    if (a >= 1700 && a <= 2229) {
                        entrar = true;
                        CalculoFecha();
                    } else {
                        do {
                            try {
                                entrar = false;
                                condicion = false;
                                System.out.println("---------------------------------------");
                                System.out.println("Ingrese año entre rango de 1700 a 2299");
                                a = fecha.nextInt();
                            } catch (Exception e) {
                                System.out.println("---------------------------------------");
                                System.out.println("Caracter incorrecto, Ingrese un Numero");
                                fecha.nextLine();
                                condicion = true;
                            }
                        } while (condicion);
                    }
                } else {
                    do {
                        try {
                            entrar = false;
                            condicion = false;
                            System.out.println("---------------------------------------");
                            System.out.println("Ingrese Mes entre rango de 1 a 12");
                            m = fecha.nextInt();
                        } catch (Exception e) {
                            System.out.println("---------------------------------------");
                            System.out.println("Caracter incorrecto, Ingrese un Numero");
                            fecha.nextLine();
                            condicion = true;
                        }
                    } while (condicion);
                }
            } else {
                do {
                    try {
                        entrar = false;
                        condicion = false;
                        System.out.println("---------------------------------------");
                        System.out.println("Ingrese dia entre rango de 1 a 31");
                        d = fecha.nextInt();
                    } catch (Exception e) {
                        System.out.println("---------------------------------------");
                        System.out.println("Caracter incorrecto, Ingrese un Numero");
                        fecha.nextLine();

                        condicion = true;
                    }
                } while (condicion);

            }

        }

    }

    public void CalculoFecha() {
        //// Se mide los rangos del año y respecto al año que sea se le asigna un valor a A
        if (a >= 1700 && a <= 1799) {
            A = +5;
        } else if (a >= 1800 && a <= 1899) {
            A = +3;
        } else if (a >= 1900 && a <= 1999) {
            A = +1;
        } else if (a >= 2000 && a <= 2099) {
            A = 0;
        } else if (a >= 2100 && a <= 2199) {
            A = -2;
        } else if (a >= 2200 && a <= 2299) {
            A = -4;
        }
        ///Se toma los dos ultimos digitos del año 
        cuartoD = a % 10;

        a = a / 10;
        tercerD = a % 10;
        /////////////////////////////////////////
        /////Aqui se enlazan los ultimos dos digitos
        unir = String.valueOf(tercerD) + String.valueOf(cuartoD);
        valorB = Integer.valueOf(unir);
        /////////////////////////////////////
        ///////////Se guarda el valor de B
        B = valorB + (valorB / 4);
        ///////////////////////
        //////////////////se comprueba si el año es bisiesto
        comprobar2 = a % 400;
        comprobar = valorB % 4;

        if ((valorB == 00 && comprobar2 == 0) && ((m == 1) || (m == 2)) && (comprobar == 0)) {
            C = -1;
            System.out.println("---------------------------------------");
            //System.out.println("Entro aqui");
        } else {
            C = 0;
            System.out.println("---------------------------------------");
            //System.out.println("C=-0--");

        }
        ////////////////////////////////
        /////////////////////////
        if (m == 1) {
            D = 6;
        } else if (m == 2) {
            D = 2;
        } else if (m == 3) {
            D = 2;
        } else if (m == 4) {
            D = 5;
        } else if (m == 5) {
            D = 0;
        } else if (m == 6) {
            D = 3;
        } else if (m == 7) {
            D = 5;
        } else if (m == 8) {
            D = 1;
        } else if (m == 9) {
            D = 4;
        } else if (m == 10) {
            D = 6;
        } else if (m == 11) {
            D = 2;
        } else if (m == 12) {
            D = 4;
        }
        ///////////////////////////////////////
        ///////////////////////////////////////
        E = d;
        resultado = A + B + C + D + E;

        while (condicion == false) {
            if (resultado >= 0 && resultado <= 6) {
                condicion = true;

            } else {
                condicion = false;
                resultado = resultado - 7;
            }

        }
        System.out.println("---------------------------------------");
        System.out.println(resultado);
        if (resultado == 0) {
            System.out.println("---------------------------------------");
            System.out.println("El dia es Domingo");
            System.out.println("---------------------------------------");
        } else if (resultado == 1) {
            System.out.println("---------------------------------------");
            System.out.println("El dia es Lunes");
            System.out.println("---------------------------------------");
        } else if (resultado == 2) {
            System.out.println("---------------------------------------");
            System.out.println("El dia es Martes");
            System.out.println("---------------------------------------");
        } else if (resultado == 3) {
            System.out.println("---------------------------------------");
            System.out.println("El dia es Miercoles");
            System.out.println("---------------------------------------");
        } else if (resultado == 4) {
            System.out.println("---------------------------------------");
            System.out.println("El dia es Jueves");
            System.out.println("---------------------------------------");
        } else if (resultado == 5) {
            System.out.println("---------------------------------------");
            System.out.println("El dia es Viernes");
            System.out.println("---------------------------------------");
        } else if (resultado == 6) {
            System.out.println("---------------------------------------");
            System.out.println("El dia es Sabado");
            System.out.println("---------------------------------------");
        } else {
            System.out.println("---------------------------------------");
            System.out.println("No se encontro el dia,rango de año que puede utilizar 1700 a 2299");
        }
        /*
        d = 0;
        a = 0;
        m = 0;
        resultado = 0;
        A = 0;
        B = 0;
        C = 0;
        D = 0;
        E = 0;
        /////////////////
        cuartoD = 0;
        tercerD = 0;
        /////////////////
        unir = "";
        ///////////////////
        valorB = 0;
        //////////
        comprobar = 0;
        comprobar2 = 0;
        ////////////////////
        condicion = false;*/
    }
}
