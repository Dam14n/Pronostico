package clase4;
import java.util.Scanner;

/** 2. Cargar por teclado una lista de números positivos, de tamaño n y mostrar:
1. Los números de la lista.
2. La sumatoria de los números.
3. La cantidad de números mayores a 10.
4. El porcentaje de números pares.
5. El promedio de todos los números.
*/

public class Ejercicio4_3 {
    public static void main(String[] args) {
        // definición de variables y entrada de datos
        Scanner sc = new Scanner(System.in);
        // variables de entrada
        int n;
        int vec[]; 
        // variables de salida
        String lista; 
        int suma;
        int sumaMayor10;
        float porcentaje;           //porcentaje = parcial * 100 / total
        float promedio;             // promedio = sumatoria / cantidad
        
        System.out.print("Ingrese el valor de n: ");
        n = sc.nextInt();
        // crea el vector de n elementos
        vec = new int[n];
        
        // llama a las funciones para manejar el vector
        
        // cargar el vector
        cargar(vec);        
        // 1. mostrar el vector
        lista = mostrar(vec);
        System.out.println("Los valores del vector son: "+lista);
        // 2. La sumatoria de los números.
        suma = sumar(vec);       
        System.out.println("La suma es: "+suma);
        // 3. La cantidad de números mayores a 10.
        sumaMayor10 = sumarMayores10(vec);
        System.out.println("La cantidad valores mayores a 10 es: "+sumaMayor10);
        // 4. El porcentaje de números pares.
        porcentaje = calcularPorcentaje(vec);
        System.out.println("El porcentaje de valores pares es: "+porcentaje);
        // 5. El promedio de todos los números.
        //el total es igual a la cantidad de elementos del vector
        promedio = calcularPromedio(suma, vec.length);
        System.out.println("El promedio de valores es: "+promedio);
    }

    // cargar el vector
    // pasa la referencia del vector por eso no retorna, 
    //trabaja con los datos del vector original
    public static void cargar(int[] vec) {
        Scanner sc = new Scanner(System.in);
        int num;
        for (int i = 0; i < vec.length; i++)
        {
            //resultados parciales
            System.out.print("Ingrese el "+ i+ " valor: ");
            num = sc.nextInt();
            // guarda el num en el vector en la posición i
            vec[i] = num;
        }           
    }
        
    // 1. mostrar el vector
    public static String mostrar(int[] vec) {
        String lista = ""; 
        for (int numero : vec)
        {
            // guarda los valores en lista
            lista += "\n"+numero;
        }
        return lista;
    }
    
    // 2. La sumatoria de los números.
    public static int sumar(int[] vec) {        
        int suma = 0;
        for (int numero : vec)
        {
            suma = suma + numero;
            //suma += numero;
        }
        return suma;
    }
    
        
    // 3. La cantidad de números mayores a 10.
    public static int sumarMayores10(int[] vec) {
        int sumaMayor10 = 0;
        for (int numero : vec)
        {
            if (numero > 10)
                sumaMayor10++;
        }
        return sumaMayor10;
    }
        
    // 4. El porcentaje de números pares.
    public static float calcularPorcentaje(int[] vec) {
        int total = 0, parcial= 0;         //porcentaje = parcial * 100 / total
        // el total también se puede inicializar como total = vec.length 
        float porcentaje = 0;
        for (int numero : vec)
        {
            total++;                //cuento todos
            if ((numero % 2) == 0)  //es par?
                parcial++;          // solo cuento los pares    
        }
        // calculo el porcentaje
        if (total != 0)
            porcentaje = parcial * 100 / total;
        
        return porcentaje;
    }
        
    // 5. El promedio de todos los números.
    // promedio = sumatoria / cantidad
    // usamos la variable suma del punto 2 y el total de elementos del porcentaje
    public static float calcularPromedio(int suma, float total) {
        float promedio = 0;
     
        if (total != 0)
            promedio = suma / total;
        
        return promedio;
    }
    
}
