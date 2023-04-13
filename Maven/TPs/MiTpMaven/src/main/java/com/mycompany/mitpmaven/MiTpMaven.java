/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mitpmaven;

import static com.mycompany.mitpmaven.TP.PRODE;

/**
 *
 * @author DIALER
 */
public class MiTpMaven {

    public static PronosticoDeportivo PRODE;
    //private static String tipoCarga;

    public static void main(String[] args) {
//    public static void main(String[] args, String tipoCarga) {
        System.out.println ("Sistema de simulación de pronósticos deportivos.");
        System.out.println ("Ejecutándose desde:" + System.getProperty("user.dir"));
        System.out.println ();
        
        PRODE = new PronosticoDeportivo();

        PRODE.play();
        
        //PRODE.play(tipoCarga);
    }
}
