/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.talllercolas.ejercicio08;

/**
 *
 * @author Usuario
 */
public class SolicitudTienda {
    private String nombreTienda;
    private int cantidadSolicitada;

    public SolicitudTienda(String nombreTienda, int cantidadSolicitada) {
        this.nombreTienda = nombreTienda;
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }
}
