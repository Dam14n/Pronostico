/*
*
*
 */
package com.mycompany.mitpmaven.model;

import com.mycompany.mitpmaven.lists.ListaEquipos;
import com.mycompany.mitpmaven.lists.ListaPartidos;
import com.mycompany.mitpmaven.lists.ListaPronosticos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author GRUPO 7
 */

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Participante {

    private int id;
    private String nombre;
    private ListaPronosticos pronosticos;


    public Participante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.pronosticos = new ListaPronosticos();
    }
    
    public Participante() {
        this.id = 0;
        this.nombre = null;
        this.pronosticos = new ListaPronosticos();
    }


    void cargarPronosticos (ListaEquipos equipos, ListaPartidos partidos) {
        this.pronosticos.cargarDeArchivo(this.getId(), equipos, partidos);
    }

    public int getPuntaje() {
        return this.getPronosticos().getPuntaje();
    }
}
