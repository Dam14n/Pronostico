/*
Usando la clase Alumno vista anteriormente, se pide:

1. Crear la clase Alumno que herede de Persona y tenga como atributos: legajo, profesión y sueldo y como métodos: constructores (con y sin argumentos), set/get y toString().
2. Crear una clase Aplicación que realice lo siguiente: 
a. Ingrese n alumnos.
b. Muestre los alumnos.
c. Muestre los alumnos que tienen el promedio menor a 4.

*/
package clase6;

import java.util.List;
import java.util.Scanner;

public class Ejercicio6_2 {
    public static void main(String[] args) {
        Scanner numero = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        int n;
        Alumno alu;
        int leg; long dni; String nom, tel; float prom;
        System.out.print("Ingrese la cantidad de alumnos a cargar: ");
        n = numero.nextInt();
        // no es necesario el tamaño ya que es dinámica
        ListaAlumnos lista = new ListaAlumnos();
        for (int i= 0; i < n; i++) {
            //carga valores para el alumno
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
            // agregar el alumno en el objeto listaAlumno
            lista.addAlumno(alu);
        }       
        // invoca a toString
        System.out.println("Los datos de los alumnos son: "+ lista);
        System.out.println("Los datos de los alumnos con recorrido son: "+ lista.listar());
        System.out.println("Los datos de los alumnos con iterator son: "+ lista.listar2());
        // utiliza los alumnos que tienen promedio menor a 4
        List<Alumno> sinPromedio = lista.getAlumnosSinPromedio();
        System.out.println("Los datos de los alumnos con promedio menor a 4 son : "+ sinPromedio);        
    }
}
