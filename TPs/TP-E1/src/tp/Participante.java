/*
*
*
 */
package tp;

/**
 *
 * @author GUPO 7
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
        this.pronosticos = new Pronostico[] {};
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
        // Return generado de forma automatica por NetBeans
        return "Participante{" + "nombre=" + nombre + ", pronosticos=" + pronosticos + '}';
        
        // Este return utiliza un metodo listarPronostico generado para listar todos los pronosticos del participante
        // este metodo duplicaria la informacion de los pronosticos
        //return "Participante{" + "nombre=" + nombre + ", pronosticos=" + this.listarPronosticos() + '}';

        // Esta return se lo crea para reemplazar al anterior debido a que no es necesario el pronostico aca
        // pero este es el que yo utilizia si metodo de listraPronosticos de PronosticoDeportivo es el que se debe usar
        //return "Participante{" + "nombre=" + nombre + '}';
    }
    
    private String listarPronosticos() {
        String res = "";
            for (Pronostico pron : this.getPronosticos()) {
                res += pron.toString()+ System.lineSeparator();
            }
            res += "- - - - - - - - - - - - - - - - - -"+ System.lineSeparator();

        return res;
    }
        
    // Metodos Especificos

}
