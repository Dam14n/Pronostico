/*
Clase Alumno para el ejercicio 6_1 y 6_2
 */
package clase6;

public class Alumno extends Persona {
    private int legajo;
    private float promedio;

    public Alumno(int legajo, float promedio, long dni, String nombre, String telefono) {
        super(dni, nombre, telefono);
        this.legajo = legajo;
        this.promedio = promedio;
    }

    public Alumno() {
        super();
        this.legajo = 0;
        this.promedio = 0f;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Alumno{" + "dni=" + super.dni + ", nombre=" + super.nombre + 
                ", telefono=" + super.telefono + " legajo=" + legajo + 
                ", promedio=" + promedio + '}';
//        return "Alumno{" + super.toString()+ " legajo=" + legajo + ", promedio=" + promedio + '}';
    }   
}
