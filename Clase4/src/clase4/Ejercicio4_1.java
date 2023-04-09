package clase4;
import java.util.Scanner;

/** 1. Ingresar la cantidad de estudiantes de un curso y la cantidad de
 * estudiantes que aprobaron el mismo, calcular y mostrar el porcentaje que 
 * representan estos últimos respecto del total de estudiantes.
*/

public class Ejercicio4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // variables de entrada
        int cantTotal, cantAprobados;
        float porcentaje;           //porcentaje = parcial * 100 / total
        
        System.out.print("Ingrese la cantidad total de estudiantes: ");
        cantTotal = sc.nextInt();

        System.out.print("Ingrese la cantidad de aprobados: ");
        cantAprobados = sc.nextInt();

        // llama a la función que carga el porcentaje .
        porcentaje = calcularPorcentaje(cantTotal, cantAprobados);
        System.out.println("El porcentaje de aprobados es: " + porcentaje);        
    }

    // calcula el porcentaje .
    public static float calcularPorcentaje(int total, int parcial) {
        //porcentaje = parcial * 100 / total
        float porcentaje = 0;
        
        // calculo el porcentaje
        if (total != 0)
            porcentaje = parcial * 100 / total;
        
        return porcentaje;
    }
        
}
