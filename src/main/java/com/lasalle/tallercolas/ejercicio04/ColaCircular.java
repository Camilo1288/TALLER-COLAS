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

    public void insertar(T dato) {
        if (elementosActuales > 0 && primerDesocupado == primerLleno) {
            Nodo nuevoNodo = new Nodo(dato);
            nuevoNodo.siguiente = primerDesocupado.siguiente;
            primerDesocupado.siguiente = nuevoNodo;
            primerDesocupado = nuevoNodo;
        } else {
            primerDesocupado.dato = dato;
            primerDesocupado = primerDesocupado.siguiente;
        }
        elementosActuales++;
    }

    // Método para remover un elemento de la cola circular
    public T remover() {
        // Si se intenta remover de una cola vacía se dispara una excepción
        if (estaVacia()) {
            throw new IllegalStateException("La cola circular está vacía, no se puede remover.");
        }

        T datoRemovido = primerLleno.dato;
        primerLleno.dato = null; // Limpiamos el dato
        primerLleno = primerLleno.siguiente; // Avanza el primer lleno
        elementosActuales--;

        return datoRemovido;
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        ColaCircular<String> cola = new ColaCircular<>(3);
        
        cola.insertar("Elemento 1");
        cola.insertar("Elemento 2");
        cola.insertar("Elemento 3");
        
        // Al insertar un cuarto elemento, como está llena, se expande automáticamente
        cola.insertar("Elemento 4 (Extra)");

        System.out.println("Removido: " + cola.remover());
        System.out.println("Removido: " + cola.remover());
        
        System.out.println("Pruebas de Cola Circular ejecutadas con éxito.");
    }
}
