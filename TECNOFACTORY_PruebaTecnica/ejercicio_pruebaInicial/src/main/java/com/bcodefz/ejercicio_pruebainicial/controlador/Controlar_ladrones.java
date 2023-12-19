/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcodefz.ejercicio_pruebainicial.controlador;

import com.bcodefz.ejercicio_pruebainicial.modelo.Ladrones;


/**
 *
 * @author bcortesf-user
 */
public class Controlar_ladrones {

    private final Ladrones ladronCodigo;
    
    public Controlar_ladrones() {
        ladronCodigo = new Ladrones();
    }
        
    private String responderNumero(String numeroPreguntado ) {        
        String respuesta;
        try {
            Integer num = Integer.parseInt(numeroPreguntado);  
            String letras = ladronCodigo.numero_a_letra(num); 
            ladronCodigo.setCodigoSecreto( letras.length() );            
            respuesta = String.valueOf( ladronCodigo.getCodigoSecreto() );
        } catch (NumberFormatException| ArithmeticException e) {
            respuesta = "ERROR: " + e.getMessage();
        }
        return respuesta;
    } 
    
    public String getCodigoSecreto(String numeroPreguntado){               
        return responderNumero(numeroPreguntado);
    }    
}