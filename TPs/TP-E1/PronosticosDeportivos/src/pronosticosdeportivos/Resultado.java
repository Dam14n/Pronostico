/*
*/
package pronosticosdeportivos;

/**
 *
 * @author Silvio Jorda
 */
public class Resultado {
    // Atributos
    private char valor;
    private String descripcion;
    
    // Metodos
    public Resultado(char valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public Resultado() {
        //this.valor = "";
        this.descripcion = "";
    }

    public char getValor() {
        return valor;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Resultado{" + "valor=" + valor + ", descripcion=" + descripcion + '}';
    }
}
