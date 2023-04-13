/*
*/
package com.mycompany.mitpmaven;

/**
* @author SJorda
*/
public class DatosArchivo {
    private String nombreArchivo;   // el nombre deberia ser obligatorio
    private String extensionArchivo;    // la extension deberia ser abligatoria
    private String directotioArchivos;  // el directorio de los archivos es el que se indique y se pas deberia ser el directorio don se est ejecutando + Archivos ej (./Archivos/)
    private String archivoDatos;

    public DatosArchivo(String directotioArchivos, String nombreArchivo, String extensionArchivo, String archivoDatos) {
        this.directotioArchivos = directotioArchivos;
        this.nombreArchivo = nombreArchivo;
        this.extensionArchivo = extensionArchivo;
        this.archivoDatos = archivoDatos;
    }

    public DatosArchivo() {
        this.directotioArchivos = "./Archivos/";
        this.nombreArchivo = null;
        this.extensionArchivo = null;
        this.archivoDatos = null;
    }

    public String getDirectotioArchivos() {
        return directotioArchivos;
        // este deberia ser el valor por defecto System.getProperty("user.dir")
    }

    public void setDirectotioArchivos(String directotioArchivos) {
        this.directotioArchivos = directotioArchivos;
        // el directorio de los archivos deberia ser ./Archivos por defecto
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getExtensionArchivo() {
        return extensionArchivo;
    }

    public void setExtensionArchivo(String extensionArchivo) {
        this.extensionArchivo = extensionArchivo;
    }

    public String getArchivoDatos() {
        return archivoDatos;
    }

    public void setArchivoDatos(String archivoDatos) {
        this.archivoDatos = archivoDatos;
    }  
}
