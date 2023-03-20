
package integrador;


public class Integrador {

    public static PronosticoDeportivo PRODE;
    
    
    public static void main(String[] args) {
        
        PRODE = new PronosticoDeportivo();
        PRODE.cargarEquipos();   
        System.out.println ("=== EQUIPOS ===");
        System.out.println (PRODE.listarEquipos());
        
       System.out.println("**********************************************************");

        PRODE.cargarParticipantes();   
        System.out.println ("=== PARTICIPANTES ===");
        System.out.println (PRODE.listarParticipantes());
        
      System.out.println("**********************************************************");

        PRODE.cargarPartidos();   
        System.out.println ("=== PARTIDOS ===");
        System.out.println (PRODE.listarPartidos());
        
    System.out.println("**********************************************************");

        PRODE.cargarPronosticos();   
        System.out.println ("=== PRONOSTICO ===");
        System.out.println (PRODE.listarPronosticos());
        
    }
}
