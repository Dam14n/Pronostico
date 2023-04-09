/*
para el ejercicio 6_2
 */
package clase6;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaAlumnos {
    // atributo
    private List<Alumno> alumnos;

    // constructores
    public ListaAlumnos(List<Alumno> alumnos) {
        // recibe la colección de alumnos ya creada
        this.alumnos = alumnos;
    }

    public ListaAlumnos() {
        // crea la coleccion en el constructor vacio
        this.alumnos = new ArrayList<Alumno>();
    }
    // get y set de alumnos, reciben y retornan toda la colección
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    // métodos básicos para agregar o quitar un elemento de la colección
    public void addAlumno(Alumno a) {
        this.alumnos.add(a);
    }
    public void removeAlumno(Alumno a) {
        this.alumnos.remove(a);
    }

    @Override
    public String toString() {
        return "ListaAlumnos{" + "alumnos=" + alumnos + '}';
    }
    // metodo que retorna los datos de todos los alumno en un String
    public String listar() {
        String lista = "";
        for (Alumno alumno: alumnos) {
            lista += "\n" + alumno;
        }           
        return lista;
    }
    
    // metodo que usa iterator para correr los datos de todos los alumno 
    //y generar un String
    public String listar2() {
        String lista = "";
        Iterator<Alumno> iterator = this.alumnos.iterator();
        while (iterator.hasNext()){
            Alumno alumno = iterator.next();
            lista += "\n" + alumno;
        }
        return lista;
    }
    
    // Retorna los alumnos que tienen el promedio menor a 4.
    public List<Alumno> getAlumnosSinPromedio() {
        // crea una colecccion con solo los alumnos con promedio menor a 4
        List<Alumno> resAlumnos = new ArrayList<>();
        for (Alumno alumno: alumnos) {
            if (alumno.getPromedio() < 4)
                // si cumple la condicion agrega en la colección
                resAlumnos.add(alumno);
        }           
        return resAlumnos;
    }

}
