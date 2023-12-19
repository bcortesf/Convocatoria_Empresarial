/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcodefz.ejercicio_pruebainicial.vista;


import com.bcodefz.ejercicio_pruebainicial.controlador.Controlar_ladrones;
import javax.swing.JOptionPane;

/**
 *
 * @author bcortesf-user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        Controlar_ladrones bandaLadrones = new Controlar_ladrones();
        String preguntarCodigoSecreto =  JOptionPane.showInputDialog(null, "Ingresar numero para obtener el codigo?");
        String respuestaCodigoSecreto = bandaLadrones.getCodigoSecreto( preguntarCodigoSecreto  );
        
        System.out.println( "EL CODIGO DE ["+preguntarCodigoSecreto+"] ES:  " + respuestaCodigoSecreto );
    }
    
}
