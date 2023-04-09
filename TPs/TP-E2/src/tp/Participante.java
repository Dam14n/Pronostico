/*
*
*
 */
package tp;

/**
 *
 * @author GRUPO 7
 */

public class Participante {
    // Atributos
    private int idParticipante;
    private String nombre;
    private Pronostico[] pronosticos;

    // Metodos
    public Participante(int idParticipante, String nombre, Pronostico[] pronosticos) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = pronosticos;
    }
    
    public Participante(int idParticipante, String nombre) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.pronosticos = new Pronostico[] {};
    }
    
    public Participante() {
        this.idParticipante = 0;
        this.nombre = null;
        this.pronosticos = new Pronostico[] {};
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pronostico[] getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(Pronostico[] pronosticos) {
        this.pronosticos = pronosticos;
    }

    @Override
    public String toString() {
//        return "Participante  =  " + idParticipante + ",  Nombre  =  " + nombre + ",  pronosticos=" + pronosticos;
        return "Participante  =  " + idParticipante + ",  Nombre  =  " + nombre;
    }
    
    private String listaPronosticos() {
        String res = "";
            for (Pronostico pron : this.getPronosticos()) {
                res += pron.toString()+ System.lineSeparator();
            }
            res += "- - - - - - - - - - - - - - - - - -"+ System.lineSeparator();

        return res;
    }
        
    // Metodos Especificos
}
