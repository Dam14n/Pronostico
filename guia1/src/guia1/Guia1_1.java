/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia1;

/**
 *
 * @author SJorda
 */

import java.util.Scanner;

public class Guia1_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaracion de variables
        float base, altura, area;
        
        // Se utiliza la clase Scanner
        Scanner sc = new Scanner(System.in);

        // Solicita carga de datos
        System.out.print("Ingrese la base: ");
        base = sc.nextFloat();
        
        // Proceso de calcualo de la altura
        // Proceso de calcualo del
        altura = base * base;
        // Muestra el area
        System.out.print("La altura es: " + altura + "\n");

        // Proceso de calcualo del
        area = (base * altura) / 2;
        // Muestra el area
        System.out.print("La area es: " + area + "\n");
    }
}