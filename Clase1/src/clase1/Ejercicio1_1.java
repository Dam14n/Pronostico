/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase1;
/**
 *
 * @author Silvio Jorda
 */

import java.util.Scanner;

public class Ejercicio1_1 {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        // Solicita cargar un nombre
        System.out.print("Ingrese su nombre: ");
        
        // Entrada de una cadena
        String nombre = sc.nextLine();
        
        // Muestra el Hola + el nombre ingresado
        System.out.print("Hola " + nombre);        
    }
}
