/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase1;

import java.util.Scanner;

/**
 *
 * @author  Silvio Jorda
 */

public class Ejercicio1_2 {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        // Declaracion de variables
        float ladoA, ladoB, ladoC;
        float perimetro;
        
        // Se utiliza la clase Scanner
        Scanner sc = new Scanner(System.in);

        // Solicita cargar el lado A
        System.out.print("Ingrese la longitud del Lado A: ");
        ladoA = sc.nextFloat();
        
        // Solicita cargar el lado B
        System.out.print("Ingrese la longitud del Lado B: ");
        ladoB = sc.nextFloat();

        // Solicita cargar el lado B
        System.out.print("Ingrese la longitud del Lado C: ");
        ladoC = sc.nextFloat();
        
        // Proceso
        perimetro = ladoA + ladoB + ladoC; 
        
        // Muestra el resultado
        System.out.print("El perimetro es de: " + perimetro + "\n");
    }
}
