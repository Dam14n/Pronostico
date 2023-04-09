/*
 * 2. Dado un vector de números enteros, retornar el promedio de los números. 
 */
package clase4;

public class Ejercicio4_2 {
    public static void main(String[] args) {
        int numeros[] = new int[] { 1, 37, 16 };
        int suma = sumatoria(numeros);
        int promedio;
     
        promedio = suma / numeros.length;
        
        System.out.println("El promedio de los números es: " + promedio);
    }

    private static int sumatoria(int[] numeros) {
        int suma = 0;
        
        for (int numero : numeros) {
        suma = suma + numero;
        }
        
        return suma;
    }
}
