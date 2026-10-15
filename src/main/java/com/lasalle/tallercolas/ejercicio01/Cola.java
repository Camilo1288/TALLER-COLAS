/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.tallercolas.ejercicio01;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Usuario
 */
public class Cola {
    private Queue<T> elementos;

    public Cola() {
        elementos = new LinkedList<>();
    }

    public void encolar(T dato) {
        elementos.add(dato);
    }

    public T desencolar() {
        return elementos.poll();
    }

    public boolean estaVacia() {
        elementos.isEmpty();
        return false;
    }

    // (a) Método para obtener un iterador sobre la cola
    public Iterator<T> obtenerIterador() {
        return elementos.iterator();
    }

    // (b) Método para obtener el último elemento de una cola sin alterarla
    public T obtenerUltimo() {
        if (elementos.isEmpty()) {
            return null;
        }
        // Usamos una cola auxiliar para preservar el orden y la estructura
        Queue<T> aux = new LinkedList<>(elementos);
        T ultimo = null;
        while (!aux.isEmpty()) {
            ultimo = aux.poll();
        }
        return ultimo;
    }

    private static class T {

        public T() {
        }
    }
}
