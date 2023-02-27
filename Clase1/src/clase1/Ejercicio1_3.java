/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase1;
/**
 *
 * @author  Silvio Jorda
 */

import java.util.Scanner;

public class Ejercicio1_3 {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        // Declaracion de variables
        int temp1, temp2, temp3, suma;
        float promedio;
        
        // Se utiliza la clase Scanner
        Scanner sc = new Scanner(System.in);

        // Solicita carga de datos
        System.out.print("Ingrese la temperatura 1: ");
        temp1 = sc.nextInt();
        System.out.print("Ingrese la temperatura 2: ");
        temp2 = sc.nextInt();
        System.out.print("Ingrese la temperatura 3: ");
        temp3 = sc.nextInt();
        
        // Proceso suma
        suma = temp1 + temp2 + temp3;
        // Muestra el resultado de la suma
        System.out.print("La suma es: " + suma + "\n");

        // Proceso promedio
        promedio = suma / 3;
        // Muestra el resultado del promedio
        System.out.print("El promedio es: " + promedio + "\n");
    }
}
