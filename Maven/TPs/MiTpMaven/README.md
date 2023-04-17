## TODO

1. Revisar todos los comentarios que continene // TODO
1. Crear paquetes/package para cada grupo de clases. Ahora tenes toda la aplicacion dentro de un solo
   paquete `com.mycompany.mitpmaven`. Por ejemplo

   ```text
   com.mycompany.mitpmaven.database => todos los archivos que tienen acceso a la base de datos
   com.mycompany.mitpmaven.model => tu modelo ej. Equipo, Participante, Partido, etc
   ```

1. Eliminar todos los comentarios innecesarios de cada linea de codigo, es un desastre eso.

   Por ejemplo:

   ```java
       /***
        * Este método devuelve un Equipo (o null) buscandolo por idEquipo
        * @param idEquipo Identificador del equipo deseado
        * @return Objeto Equipo (o null si no se encuentra)
        */
       public Equipo getEquipo (int idEquipo) {
           // Defini un objeto de tipo Equipo en dónde va a ir mi resultado
           // Inicialmente es null, ya que no he encontrado el equipo que 
           // buscaba todavía.
           Equipo encontrado = null;
           // Recorro la lista de equipos que está cargada
           for (Equipo eq : this.getEquipos()) {
               // Para cada equipo obtengo el valor del ID y lo comparo con el que
               // estoy buscando
               if (eq.getIdEquipo() == idEquipo) {
                   // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                   // No hace fata  asignarlo a encontrado podes devolverlo directamente => return eq;
                   encontrado = eq;
                   // Y hago un break para salir del ciclo ya que no hace falta seguir buscando
                   break;
               }
           }
           // Una vez fuera del ciclo retorno el equipo, pueden pasar dos cosas:
           // 1- Lo encontré en el ciclo, entonces encontrado tiene el objeto encontrado
           // 2- No lo encontré en el ciclo, entonces conserva el valor null del principio
           return encontrado;
       }
   ```

   Tiene que ser

   ```java
       /***
        * Este método devuelve un Equipo (o null) buscandolo por idEquipo
        * @param idEquipo Identificador del equipo deseado
        * @return Objeto Equipo (o null si no se encuentra)
        */
       public Equipo getEquipo (int idEquipo) {
           Equipo encontrado = null;
           for (Equipo eq : this.getEquipos()) {
               if (eq.getIdEquipo() == idEquipo) {
                   encontrado = eq;
                   break;
               }
           }
           return encontrado;
       }
   ```

1. Los metodos que se encargan de cargar datos yo los moveria a una clase de carga de datos desde la
   clase `ListaEquipos`. Por ejemplo crear el
   archivo CargaDeEquipos.java y mover los metodos:
    1. `    public void cargaDeDatos(int opcion, ListaEquipos listaequipos)`
    2. `    public void cargarDeArchivo(ListaEquipos listaequipos)`
    3. `    public void cargarDeDb(ListaEquipos listaequipos)`

1. Los metodos que se encargan de listar datos yo los moveria a una clase de carga de datos de la clase `ListaEquipos`.
   Por ejemplo crear el
   archivo ListadorEquipos.java y mover los metodos:
    1. `    public void listar(int opcion)`
    2. `    public void listadoEstandar()`
    3. `    public void listadoTabla()`

1. Las clases `ListaEquipos`,`ListaParticipantes`,`ListaPartidos`,`ListaPronosticos` son practicamente todas iguales, se
   puede eliminar todo el codigo repetido en una clase abstracta. Los cambios mencionados en los 2 puntos anteriores
   tambien se pueden aplicar a estas clases.

1. Hay 2 metodos main, eliminar el que no corresponde:
    1. Uno en la clase `TP.java`
    1. Otro en la clase `MiTpMaven.java`

1. Los archivos no se ponen en una carpeta `Archivos` dentro de la ubicacion `src/main` se crea una carpeta
   llamada `resources` y dentro de esa carpeta se meten todos los archivos