/*
Clase ListaEquipos para el ejercicio 6_3
 */
package clase6;

import java.util.ArrayList;
import java.util.List;

public class ListaEquipos {
    // atributo
    private List<Equipo> equipos;

    // constructores
    public ListaEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
    public ListaEquipos() {
        this.equipos = new ArrayList<Equipo>();
    }
    
    //set y get
    public List<Equipo> getEquipos() {
        return equipos;
    }
    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    // add y remove elementos
    public void addEquipo(Equipo e) {
        this.equipos.add(e);
    }
    public void removeEquipo(Equipo e) {
        this.equipos.remove(e);
    }

    @Override
    public String toString() {
        return "ListaEquipos{" + "equipos=" + equipos + '}';
    }

    public String listar() {
        String lista = "";
        for (Equipo equipo: equipos) {
            lista += "\n" + equipo;
        }           
        return lista;
    }
}
