/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcodefz.ejercicio_pruebainicial.modelo;

/**
 *
 * @author bcortesf-user
 */
public class Ladrones {
    private Integer codigoSecreto;

    public Ladrones() {
    }
    
    
    public String numero_a_letra( Integer numeroPreguntado ) throws ArithmeticException{
        if ( numeroPreguntado>=0 && numeroPreguntado<=20 ) {
            String letras = "";
            if ( (numeroPreguntado/10) > 0 ) {
                //DECENAS
                switch(numeroPreguntado/10) {
                    // 10..19    ó    20
                    case 1:
                        // 10..19
                        switch ( numeroPreguntado%10 ) {
                            //identificar el numero especifico
                            //case 0:  letras = "";  break;
                            case 0:  letras = "DIEZ";  break;
                            case 1:  letras = "ONCE";  break;
                            case 2:  letras = "DOCE";  break;
                            case 3:  letras = "TRECE";  break;
                            case 4:  letras = "CATORCE";  break;
                            case 5:  letras = "QUINCE";  break;
                            default:
                              //16 ...19   
                                letras = "DIECI" + numero_a_letra(numeroPreguntado%10);
                        }
                        break;
                    case 2:
                        // 20
                        letras = "VEINTE";
                        break;
                }
            } else {
                //UNIDADES
                switch ( numeroPreguntado%10 ) {
                            //identificar el numero especifico
                            //case 0:  letras = "";  break;
                            case 0:  letras = "CERO";  break;
                            case 1:  letras = "UNO";  break;
                            case 2:  letras = "DOS";  break;
                            case 3:  letras = "TRES";  break;
                            case 4:  letras = "CUATRO";  break;
                            case 5:  letras = "CINCO";  break;
                            case 6:  letras = "SEIS";  break;
                            case 7:  letras = "SIETE";  break;
                            case 8:  letras = "OCHO";  break;
                            case 9:  letras = "NUEVE";  break;                               
                        }
            }            
            ///////////////////////////////////////////////
            return letras;
        } else {
            throw new ArithmeticException("ACCESO DENEGADO, El numero debe ser de CERO a VEINTE");
        }                       
    }

    public Integer getCodigoSecreto() {
        return codigoSecreto;
    }

    public void setCodigoSecreto(Integer codigoSecreto) {
        this.codigoSecreto = codigoSecreto;
    }
}