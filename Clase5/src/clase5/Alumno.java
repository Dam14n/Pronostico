/**
Clase que representa un alumno, 
Atributos: legajo, nombre nota1, nota2

Métodos: 
    generales: constructores, setters, getters, toString
    especificos: getPromedio
*/
package clase5;


public class Alumno {
    // atributos
    private int legajo;
    private String nombre;
    private int nota1;
    private int nota2;
    
    // métodos
    public Alumno(int legajo, String nombre, int nota1, int nota2) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public Alumno() {
        this.legajo = 0;
        this.nombre = "";
        this.nota1 = 0;
        this.nota2 = 0;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    @Override
    public String toString() {
        return "Alumno{" + "legajo=" + legajo + ", nombre=" + nombre + ", nota1=" + nota1 + ", nota2=" + nota2 + '}';
    }

    //retorna el promedio del alumno
    public float getPromedio() {
        return (nota1 + nota2) / 2f;
    }
    
}
