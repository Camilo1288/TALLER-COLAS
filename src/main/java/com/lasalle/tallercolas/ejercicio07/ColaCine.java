/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.tallercolas.ejercicio07;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Usuario
 */
public class ColaCine<T> {
    private Queue<T> clientesAsiduos;
    private Queue<T> clientesOcasionales;

    
    public ColaCine() {
        this.clientesAsiduos = new LinkedList<>();
        this.clientesOcasionales = new LinkedList<>();
    }

    
    public boolean estaVacia() {
        return clientesAsiduos.isEmpty() && clientesOcasionales.isEmpty();
    }
}
