/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp;

/**
 *
 * @author SJorda
 */

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ListaEquipos {
    // Atributos
    private List<Equipo> equipos;
    
    // Metodos
    public ListaEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ListaEquipos() {
        this.equipos = new ArrayList<Equipo>();
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }
    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    // Agregar elementos
    public void addEquipo(Equipo e) {
        this.equipos.add(e);
    }

    // Eliminar elementos
    public void removeEquipo(Equipo e) {
        this.equipos.remove(e);
    }

    @Override
    public String toString() {
        return "ListaEquipos{" + "equipos=" + equipos + '}';
    }
    
    // Metodos Especificos    
    public String listar() {
        String lista = "";
        for (Equipo equipo: equipos) {
            lista += "\n" + equipo;
        }           
        return lista;
    }
}
