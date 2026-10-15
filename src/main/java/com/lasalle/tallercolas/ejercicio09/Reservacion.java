/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.tallercolas.ejercicio09;

/**
 *
 * @author Usuario
 */
public class Reservacion {
    private String nombrePersona;
    private int numeroComensales;

    public Reservacion(String nombrePersona, int numeroComensales) {
        this.nombrePersona = nombrePersona;
        this.numeroComensales = numeroComensales;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public int getNumeroComensales() {
        return numeroComensales;
    }
}
