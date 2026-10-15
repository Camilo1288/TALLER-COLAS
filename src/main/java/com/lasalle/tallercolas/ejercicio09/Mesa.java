/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.tallercolas.ejercicio09;

/**
 *
 * @author Usuario
 */
public class Mesa {
    private String codigo;
    private int capacidad;
    private boolean ocupada;

    public Mesa(String codigo, int capacidad) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.ocupada = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
