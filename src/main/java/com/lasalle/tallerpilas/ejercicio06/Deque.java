/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.tallerpilas.ejercicio06;
import java.util.LinkedList;
/**
 *
 * @author Usuario
 */
public class Deque<T> {
    private LinkedList<T> elementos;

    public Deque() {
        elementos = new LinkedList<>();
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public void encolar(T elem) {
        elementos.addLast(elem);
    }

    public T desencolar() {
        return elementos.pollFirst();
    }

    
    public void agregarPrimero(T elem) {
        elementos.addFirst(elem);
    }
    public T eliminarUltimo() {
        if (estaVacia()) {
            return null;
        }
        return elementos.pollLast();
    }

    // Método 3: obtener el último elemento de la cola sin eliminarlo
    public T ultimoElemento() {
        if (estaVacia()) {
            return null;
        }
        return elementos.peekLast();
    }
}
