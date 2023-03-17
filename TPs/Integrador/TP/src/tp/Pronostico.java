/*
*
*
*/
package tp;

/**
 *
 * @author Silvio Jorda
 */
public class Pronostico {
    // Atributos
    private Equipo equipo;
    private Partido partido;
    private char resultado;
    
    // Metodos

    public Pronostico(Equipo equipo, Partido partido, char resultado) {
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }

    public Pronostico() {
        this.equipo = null;
        this.partido = null;
        this.resultado = ' ';
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Pronostico{" + "equipo=" + equipo + ", partido=" + partido + ", resultado=" + resultado + '}';
    }
    
    // Metodos Especificos
}
