/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.tallercolas.ejercicio04;

/**
 *
 * @author Usuario
 */

    public class ColaCircular<T> {

    
    private class Nodo {
        T dato;
        Nodo siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = this; 
        }
    }

    private Nodo primerLleno;     
    private Nodo primerDesocupado; 
    private int tamañoMaximo;
    private int elementosActuales;

    public ColaCircular(int capacidad) {
        this.tamañoMaximo = capacidad;
        this.elementosActuales = 0;
        this.primerLleno = null;
        this.primerDesocupado = null;
        
        
        if (capacidad > 0) {
            Nodo primerNodo = new Nodo(null);
            Nodo actual = primerNodo;
            for (int i = 1; i < capacidad; i++) {
                Nodo nuevo = new Nodo(null);
                actual.siguiente = nuevo;
                actual = nuevo;
            }
            actual.siguiente = primerNodo; 
            this.primerDesocupado = primerNodo;
            this.primerLleno = primerNodo;
        }
    }

    public boolean estaVacia() {
        return elementosActuales == 0;
    }
}
