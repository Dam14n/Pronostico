/*
*
*
 */
package tp;

/**
 *
 * @author SJorda
 */
//import Equipo;

public class Partido {
    // Atributos
    private Equipo equipoLocal;
    private Equipo equipoVisistante;
    private Integer golesEquipoLocal;
    private Integer golesEquipoVisitanate;

    // Metodos
    public Partido(Equipo equipoLocal, Equipo equipoVisistante, 
                   Integer golesEquipoLocal, Integer golesEquipoVisitanate) {
        this.equipoLocal = equipoLocal;
        this.equipoVisistante = equipoVisistante;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitanate = golesEquipoVisitanate;
    }

    public Partido() {
        this.equipoLocal = equipoLocal;
        this.equipoVisistante = equipoVisistante;
        this.golesEquipoLocal = 0;
        this.golesEquipoVisitanate = 0;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisistante() {
        return equipoVisistante;
    }

    public void setEquipoVisistante(Equipo equipoVisistante) {
        this.equipoVisistante = equipoVisistante;
    }

    public Integer getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(Integer golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public Integer getGolesEquipoVisitanate() {
        return golesEquipoVisitanate;
    }

    public void setGolesEquipoVisitanate(Integer golesEquipoVisitanate) {
        this.golesEquipoVisitanate = golesEquipoVisitanate;
    }

    @Override
    public String toString() {
        return "Partido{" + "equipoLocal=" + equipoLocal + ", equipoVisistante=" + equipoVisistante + ", golesEquipoLocal=" + golesEquipoLocal + ", golesEquipoVisitanate=" + golesEquipoVisitanate + '}';
    }
}
