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
    private int elementosActuales;

    public ColaCircular(int capacidad) {
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

    // Método para insertar (encolar) un elemento en la cola circular
    public void insertar(T dato) {
        // Si la cola está llena (el primer desocupado coincide con el primer lleno y hay elementos)
        if (elementosActuales > 0 && primerDesocupado == primerLleno) {
            // Creamos un nuevo nodo y lo insertamos en la estructura circular
            Nodo nuevoNodo = new Nodo(dato);
            nuevoNodo.siguiente = primerDesocupado.siguiente;
            primerDesocupado.siguiente = nuevoNodo;
            
            // Actualizamos referencias
            primerDesocupado = nuevoNodo;
        } else {
            // Si hay espacio disponible en los nodos existentes
            primerDesocupado.dato = dato;
            primerDesocupado = primerDesocupado.siguiente;
        }
        elementosActuales++;
    }
}
