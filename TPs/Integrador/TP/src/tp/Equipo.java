/*
*
*
 */
package tp;

/**
 *
 * @author Silvio Jorda
 */

public class Equipo {
    // Atributos
    private String nombre;
    private String descripcion;
    
    // Metodos
    public Equipo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Equipo() {
        this.nombre = null;
        this.descripcion = null;
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

    /*
    @Override
    public String toString() {
        //  return "Equipo{" + "nombre=" + nombre + ", descriopcion=" + descripcion + '}';
        //  return ("Equipo  -->  " + this.nombre + this.descripcion);
        return ("Equipo {" + "nombre=" + nombre + ", descriopcion=" + this.descripcion + ']');
    }
    */
    
    
    
    // Metodos Especificos

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo{");
        sb.append("nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append('}');
        return sb.toString();
    }
}
