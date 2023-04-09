/* 
Clase Persona para el ejercicio 6_1
*/
package clase6;


public class Persona {
    // atributos
    protected long dni;
    protected String nombre;
    protected String telefono;
    
    //metodos

    public Persona(long dni, String nombre, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public Persona() {
        this.dni = 0;
        this.nombre = null;
        this.telefono = null;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono;
    }
}
