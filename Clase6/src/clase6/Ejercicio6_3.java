/*
3. Usando el enunciado del Trabajo práctico integrador, vamos a hacer 2 clases relacionadas al modelo propuesto:
1- Equipo
2- ListaEquipos

*/
package clase6;

import java.util.Scanner;

public class Ejercicio6_3 {
    public static void main(String[] args) {
        Scanner numero = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        int n;
        Equipo equipo;
        String nom, des;
        System.out.print("Ingrese la cantidad de equipos a cargar: ");
        n = numero.nextInt();
        // no es necesario el tamaño ya que es dinámica
        ListaEquipos lista = new ListaEquipos();
        for (int i= 0; i < n; i++) {
            //carga valores para el equipo
            System.out.print("Ingrese el nombre del equipo : ");
            nom = string.nextLine();
            System.out.print("Ingrese la descripción del equipo : ");
            des = string.nextLine();
            equipo = new Equipo(nom, des);	
            // agregar el alumno en el objeto listaAlumno
            lista.addEquipo(equipo);
        }       
        // invoca a toString
        System.out.println("Los datos de los equipos son: "+ lista);
    }
}

