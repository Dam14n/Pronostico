/*
Clase Equipo para el ejercicio 6_3
 */
package clase6;

public class Equipo {
    private String nombre;
    private String descripcion;

    public Equipo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }        
}
