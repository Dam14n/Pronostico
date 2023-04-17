/*
*/
package com.mycompany.mitpmaven;

/**
 * @author GRUPO 7
 */

public class Equipo {
    // Atributos
    // TODO Esto se tendria que llamar solo id
    private int idEquipo;
    private String nombre;
    private String descripcion;
    
    // Metodos
    public Equipo(int idEquipo, String nombre, String descripcion) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    // TODO Si el constructor vacio no se usa hay que borrarlo, y si se usa ningun valor es necesario de los que se estan inicializando
    public Equipo() {
        this.idEquipo = 0;
        this.nombre = null;
        this.descripcion = null;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // TODO Mal escrito el nombre del archivo
    public String getDescriopcion() {
        return descripcion;
    }

    public void setDescriopcion(String descriopcion) {
        this.descripcion = descriopcion;
    }

    // TODO Usar System.lineSeparator() en vez de \t
    @Override
    public String toString() {
        return this.idEquipo + "\t" + this.nombre + "\t" +
               this.descripcion + "\t";
    }
    
    // Metodos Especificos
}
