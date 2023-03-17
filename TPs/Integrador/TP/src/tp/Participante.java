/*
*
*
 */
package tp;

/**
 *
 * @author Silvio Jorda
 */

public class Participante {
    // Atributos
    private String nombre;
    private Pronostico[] pronosticos;

    // Metodos
    public Participante(String nombre, Pronostico[] pronosticos) {
        this.nombre = nombre;
        this.pronosticos = pronosticos;
    }
    
    public Participante() {
        this.nombre = null;
        this.pronosticos = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pronostico[] getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(Pronostico[] pronosticos) {
        this.pronosticos = pronosticos;
    }


    @Override
    public String toString() {
        return "Participante{" + "nombre=" + nombre + ", pronosticos=" + pronosticos + '}';
    }
    
    // Metodos Especificos

}
