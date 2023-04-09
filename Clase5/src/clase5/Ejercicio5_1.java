/*
prueba de la clase Alumno 
*/
package clase5;

public class Ejercicio5_1 {
    public static void main(String[] args) {
    // declara un objeto Alumno
    Alumno alu;
    //crea el objeto pasando datos iniciales
    alu = new Alumno(10, "Juan Perez", 10, 8);
    
    // prueba algunos métodos
    // se se ha implementado el método toString no es necesario invocarlo
    System.out.println(alu);
    System.out.println("El promedio del alumno es: " + alu.getPromedio());
    }
}
