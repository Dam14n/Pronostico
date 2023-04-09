/*
Clase que representa un postulante, 
Atributos: nombre del postulante, cantidad total de preguntas que se le realizaron y 
cantidad de preguntas que contestó correctamente

Métodos: 
    generales: constructores, setters, getters, toString
    especificos: getPorcentaje, getNivel
*/
package clase5;

public class Postulante {
    private String nombre;
    private int totalPreguntas;
    private int totalBienRespondidas;

    public Postulante(String nombre, int totalPreguntas, int totalBienRespondidas) {
        this.nombre = nombre;
        this.totalPreguntas = totalPreguntas;
        this.totalBienRespondidas = totalBienRespondidas;
    }

    public Postulante() {
        this.nombre = "";
        this.totalPreguntas = 0;
        this.totalBienRespondidas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalPreguntas() {
        return totalPreguntas;
    }

    public void setTotalPreguntas(int totalPreguntas) {
        this.totalPreguntas = totalPreguntas;
    }

    public int getTotalBienRespondidas() {
        return totalBienRespondidas;
    }

    public void setTotalBienRespondidas(int totalBienRespondidas) {
        this.totalBienRespondidas = totalBienRespondidas;
    }

    @Override
    public String toString() {
        return "Postulante{" + "nombre=" + nombre + ", totalPreguntas=" + totalPreguntas + ", totalBienRespondidas=" + totalBienRespondidas + '}';
    }

    public float getPorcentaje() {
        float porcentaje = 0;
        
        // calculo el porcentaje
        if (totalPreguntas != 0)
            porcentaje = totalBienRespondidas * 100 / totalPreguntas;
        
        return porcentaje;
    }

     // calcula el nivel.
    public String getNivel() {
        String nivel;
        float porcentaje = this.getPorcentaje();
        
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
