/*
Para entrega 2
 */
package com.mycompany.mitpmaven;

/**
 *
 * @author aguzman
 */
public class PronosticoDeportivo {
    private ListaEquipos equipos;
    private ListaPartidos partidos;
    private ListaParticipantes participantes;
    private ListaPronosticos pronosticos;
//    private String tipoCarga;
    

    public PronosticoDeportivo() {
        equipos = new ListaEquipos();
        partidos = new ListaPartidos();
        participantes = new ListaParticipantes();
        pronosticos = new ListaPronosticos();
//        tipoCarga = null;
    }

//    public String getTipoCarga() {
//        return tipoCarga;
//    }

//    public void setTipoCarga(String tipoCarga) {
//        this.tipoCarga = tipoCarga;
//    }

    public void play(){
//    public void play(String tipoCarga){
        // cargar y listar los equipos
        equipos.cargaDeDatos();
        equipos.cargarDeArchivo();
        System.out.println(equipos.listar());
        
        // cargar y listar los participantes
        participantes.cargarDeArchivo();
        System.out.println(participantes.listar());

        // cargar y listar los participantes
        partidos.cargarDeArchivo(equipos);
        System.out.println(partidos.listar());

        // Una vez cargados los participantes, para cada uno de ellos
        // cargar sus pronósticos
        for (Participante participante : participantes.getParticipantes()) {
            participante.cargarPronosticos(equipos, partidos);
        }
        
        System.out.println(participantes.listar());
        
        // agregar y/o modificar el codigo que quieran
    } 
}
