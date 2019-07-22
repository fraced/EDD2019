
package tarea1estructuras;

import java.util.Scanner;


public class Criba {
    
    Scanner numero = new Scanner(System.in);
    int n=0;
    boolean condicion = false;
    
    public void Npares(){
        do {
            System.out.println("---------------------------------------");
            System.out.println("Ingrese numero");
            try {
                n = numero.nextInt();
                condicion = false;
            } catch (Exception e) {
                condicion = true;
                System.out.println("---------------------------------------");
                System.out.println("Caracter incorrecto, Ingrese un Numero");
                numero.nextLine();

            }
        } while (condicion);

        System.out.println("Los numeros primos de 0 a "+n+" son");
        int nprimo []= new int[n+1];
        
        for (int i = 0; i < n; i++) {
            nprimo[i]=i;
        }
        
        for (int i = 2; i <= n; i++) {
            if (nprimo[i]>=1 && nprimo[i]<=n) {
                for(int j = i*2;j<=n;j+=i){
                    nprimo[j]=0;
                }
            }
            
        }
        for (int i = 2; i <= n; i++) {
            if(nprimo[i]>0&& nprimo[i]<=n){
                
                System.out.print(i+"  "); 
            }
        }
        System.out.println("");
    }
    
}
