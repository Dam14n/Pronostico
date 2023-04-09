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
package clase5;

import java.util.Scanner;

public class Ejercicio5_2 {
    public static void main(String[] args) {
        //para ingresar solo enteros
        Scanner entero = new Scanner(System.in);
        // para ingresar solo strings
        Scanner string = new Scanner(System.in);
        // variables de entrada
        String nom;
        int totalPreguntas, totalBienRespondidas;
        //salida
        float porcentaje;
        String nivel, listado = "";
        // buscar el mejor postulante
        String postulanteMejor = "";
        float porcentajeMejor = 0;
        
        // Define el objeto postulante
        Postulante postulante;
        
        // cargar los 3 postulantes
        for (int i = 0 ; i < 3; i++) {
            // carga los datos por teclado
            System.out.println("Postulante "+ (i+1) + "°");
            System.out.print("Ingrese el nombre: ");
            nom = string.nextLine();
            System.out.print("Ingrese el total de preguntas: ");
            totalPreguntas = entero.nextInt();
            System.out.print("Ingrese el total de preguntas bien respondidas: ");
            totalBienRespondidas = entero.nextInt();
            System.out.println();
            
            // crea un objeto con los datos ingresados
            postulante = new Postulante(nom, totalPreguntas, totalBienRespondidas);
            
            // llama al método getPorcentaje de alumno.
            porcentaje = postulante.getPorcentaje();
            // llama a la función que calcula el nivel
            nivel = postulante.getNivel();
            
            listado += "\n"+postulante;  
            // determinación del aspirante con mayor porcentaje...
            if (porcentaje > porcentajeMejor) {
                postulanteMejor = postulante.getNombre();
                porcentajeMejor = postulante.getPorcentaje();
            }          
        } // fin del ciclo
        // resultados
        System.out.println("Los postulantes : " + listado);
        if (porcentajeMejor > 50)
            System.out.println("Ganador:" + postulanteMejor + "- con porcentaje de:"+ porcentajeMejor + "%");
        else
            System.out.println("No hay ganador: todos tienen porcentaje menor al 50%");
    }    
}
