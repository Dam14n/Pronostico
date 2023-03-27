/*
*
*
 */
package tp;

/**
 *
 * @author GUPO 7
 */
//import Equipo;

public class Partido {
    // Atributos
    private int idPartido;
    private Equipo equipo1;
    private Equipo equipo2;
    private Integer golesEquipo1;
    private Integer golesEquipo2;

    // Metodos
    public Partido(int idPartido, Equipo equipo1, Equipo equipo2, Integer golesEquipo1, Integer golesEquipo2) {
        this.idPartido = idPartido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public Partido() {
        this.idPartido = 0;
        this.equipo1 = null;
        this.equipo2 = null;
        this.golesEquipo1 = 0;
        this.golesEquipo2 = 0;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipoLocal) {
        this.equipo1 = equipoLocal;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipoVisitante) {
        this.equipo2 = equipoVisitante;
    }

    public Integer getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(Integer golesEquipoLocal) {
        this.golesEquipo1 = golesEquipoLocal;
    }

    public Integer getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(Integer golesEquipoVisitanate) {
        this.golesEquipo2 = golesEquipoVisitanate;
    }

    @Override
    public String toString() {
        return "Partido{" + "equipoLocal=" + equipo1 + ", equipoVisistante=" + equipo2 + ", "
                + "golesEquipoLocal=" + golesEquipo1 + ", golesEquipoVisitanate=" + golesEquipo2 + '}';
    }
    
    // Metodos Especificos
}
