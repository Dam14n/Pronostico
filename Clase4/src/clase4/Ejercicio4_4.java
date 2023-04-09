/*
Se tienen los datos de tres postulantes a un empleo, a los que se les 
realizó un test para conocer el nivel de formación previa de cada uno. 
Por cada postulante, se tienen los siguientes datos: 
 nombre del postulante, cantidad total de preguntas que se le realizaron y 
cantidad de preguntas que contestó correctamente. Se pide confeccionar un 
programa que lea los datos de los tres postulantes, informe el nivel de 
formación previa de cada uno según los criterios de aprobación que se 
indican más abajo, e indique finalmente el nombre del postulante que 
ganó el puesto. Los criterios de aprobación son en función del porcentaje 
de respuestas correctas sobre el total de preguntas realizadas a cada postulante:
     Nivel Superior:       Porcentaje >= 90%
     Nivel Medio:          75% <= Porcentaje < 90%     
     Nivel Regular:        50% <= Porcentaje < 75%
     Fuera de Nivel:       Porcentaje < 50% 
Aclaración: Si ningún postulante superó el 50% se considera que ninguno ganó el
puesto.
*/
package clase4;

import java.util.Scanner;

public class Ejercicio4_4 {
    public static void main(String[] args) {
        //para ingresar solo enteros
        Scanner entero = new Scanner(System.in);
        // para ingresar solo strings
        Scanner string = new Scanner(System.in);
        // variables de entrada
        String nom;
        int totalPreguntas, totalBienRespondidas;
        float porcentaje;
        String nivel, listado = "";
        String postulanteMejor = "";
        float porcentajeMejor = 0;
        // cargar los 3 postulantes
        for (int i = 0 ; i < 3; i++) {
            System.out.println("Postulante "+ (i+1) + "°");
            System.out.print("Ingrese el nombre: ");
            nom = string.nextLine();
            System.out.print("Ingrese el total de preguntas: ");
            totalPreguntas = entero.nextInt();
            System.out.print("Ingrese el total de preguntas bien respondidas: ");
            totalBienRespondidas = entero.nextInt();
            System.out.println();
            
            // llama a la función que calcula el porcentaje .
            porcentaje = calcularPorcentaje(totalPreguntas, totalBienRespondidas);
            // llama a la función que calcula el nivel
            nivel = calcularNivel(porcentaje);
            
            listado += "\n Postulante " + (i+1) + ": Nombre: " + nom + "- Nivel: " +
                    nivel+ "- Porc.: "+ porcentaje+ "%";  
            // determinación del aspirante con mayor porcentaje...
            if (porcentaje > porcentajeMejor) {
                postulanteMejor = nom;
                porcentajeMejor = porcentaje;
            }          
        } // fin del ciclo
        // resultados
        System.out.println("Los postulantes : " + listado);
        if (porcentajeMejor > 50)
            System.out.println("Ganador:" + postulanteMejor + "- con porcentaje de:"+ porcentajeMejor + "%");
        else
            System.out.println("No hay ganador: todos tienen porcentaje menor al 50%");
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
    
    // calcula el nivel.
    public static String calcularNivel(float porcentaje) {
        String nivel;
        
        if (porcentaje >= 90)
            nivel = "Superior";
        else
            if (porcentaje >= 75)
                nivel = "Medio";
            else
                if (porcentaje >= 50)
                    nivel = "Regular";
                else
                    nivel = "Fuera de Nivel"; 
        
        return nivel;
    }
}
