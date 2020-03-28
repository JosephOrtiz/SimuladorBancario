/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlnegocio;

import java.math.BigDecimal;

/**
 *
 * @author User
 */
public class Estructura {
    
    public BigDecimal capital;
    public int apalancamiento;
    
    public BigDecimal financiamiento;
    public BigDecimal fondoDeNegocio;
    
    public String calificacionBancaria;
    
    public int carteras;
    public int porcentajeConsumo;
    public int porcentajeHipotecario;
    public int porcentajeCorporativo;
    
    public int porcentajeInversiones;
    
    public int porcentajeOperaciones;
    
    
    public String apetitoRiesgo;
    
    public String enfoqueDeNegocio;
    
    public Estructura(){
        this.capital = new BigDecimal(0.0);
        this.apalancamiento = 10;
        this.financiamiento = new BigDecimal(0.0);
        this.fondoDeNegocio = new BigDecimal(0.0);
        this.calificacionBancaria = "...";
        this.carteras = 0;
        this.porcentajeConsumo = 0;
        this.porcentajeHipotecario = 0;
        this.porcentajeCorporativo = 0;
        this.porcentajeInversiones = 0;
        this.porcentajeOperaciones = 0;
        this.apetitoRiesgo = "...";
        this.enfoqueDeNegocio = "...";
    }
    
    // primera parte de la pantalla del Excel ...
    public int calcularApalancamiento(int n) {  // antes llamado Apalancamiento

        if (n == 3) {
            this.calificacionBancaria = "AAA";
            return 3;
        } else if (n == 7) {
            this.calificacionBancaria = "BBB";
            return 7;
        } else {
            this.calificacionBancaria = "CCC";
            return 10;
        }
    }
    
    public BigDecimal calcularFinanciamiento(BigDecimal capital, int apalancamiento) {  // antes llamado Financiamiento
        
        //double resultado = calcularApalancamiento(apalancamiento) * capital;
        BigDecimal resultado = new BigDecimal(calcularApalancamiento(apalancamiento)).multiply(capital);
        return resultado;  
    }
    
    public BigDecimal calcularFondoDeNegocio(BigDecimal capital, int apalancamiento) {
        
        //double calculoFinanciamiento = calcularFinanciamiento(capital, apalancamiento) + capital;
        BigDecimal calculoFinanciamiento = calcularFinanciamiento(capital, apalancamiento).add(capital);
        this.fondoDeNegocio = calculoFinanciamiento;
        return this.fondoDeNegocio;

    }
    
    public int calcularCarteras(int consumo, int hipotecario, int corporativo) {

        return consumo + hipotecario + corporativo;
    }
    
    public int calcularPorcentajeOperacionaes(int operaciones) {

        switch (operaciones) {
            case 1:
                operaciones = 5;
                break;
            case 2:
                operaciones = 10;
                break;
            case 3:
                operaciones = 15;
                break;
        }
        return operaciones;
    }
    
    public void establecerApetitoRiesgo(double consumo) {

        if (consumo < 40) {
            this.apetitoRiesgo = "Bajo";
        } else if (consumo >= 40 && consumo < 60) {
            this.apetitoRiesgo = "Medio";
        } else {
            this.apetitoRiesgo = "Alto";
        }
    }
    
    public String calcularEnfoqueNegocio(){//double enfoqueNegocio) {
        
        
       int enfoqueNegocio = this.carteras + this.porcentajeInversiones + this.porcentajeOperaciones;

        if (enfoqueNegocio == 100) {
            return "Correcto"; //"Enfoque de negocio: Correcto";
        } else {
            return "Incorrecto"; //"Enfoque de negocio: Incorrecto";
        }
    }
}
