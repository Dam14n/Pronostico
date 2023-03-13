/*
*
*
 */
package pronosticosdeportivos;

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
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }
    
}
