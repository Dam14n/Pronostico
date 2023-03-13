/*
*
*
 */
package pronosticosdeportivos;

/**
 *
 * @author Silvio Jorda
 */
public class Equipo {
    // Atributos
    private String nombre;
    private String descripcion;
    
    // Metodos
    public Equipo(String nombre, String descriopcion) {
        this.nombre = nombre;
        this.descripcion = descriopcion;
    }
    
    public Equipo() {
        this.nombre = "";
        this.descripcion = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescriopcion() {
        return descripcion;
    }

    public void setDescriopcion(String descriopcion) {
        this.descripcion = descriopcion;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", descriopcion=" + descripcion + '}';
    }
}
