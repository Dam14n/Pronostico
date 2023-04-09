/*
prueba de la clase Alumno 
*/
package clase6;

import java.util.Scanner;

public class Ejercicio6_1 {
    public static void main(String[] args) {
        Scanner numero = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        
        // declara un objeto Alumno
        Alumno alu;
        int leg;
        long dni;
        String nom, tel;
        float prom;

        //carga valores para el alumno 2
        System.out.print("Ingrese el legajo del alumno : ");
        leg = numero.nextInt();
        System.out.print("Ingrese el dni del alumno : ");
        dni = numero.nextLong();
        System.out.print("Ingrese el nombre del alumno : ");
        nom = string.nextLine();
        System.out.print("Ingrese el telefono del alumno : ");
        tel = string.nextLine();
        System.out.print("Ingrese el promedio del alumno : ");
        prom = numero.nextFloat();
        alu = new Alumno(leg, prom, dni, nom, tel);	
        System.out.println("Los datos del primer alumno son: "+ alu.toString());
    }
}
