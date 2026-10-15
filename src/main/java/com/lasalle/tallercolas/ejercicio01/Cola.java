/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.tallercolas.ejercicio01;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 *
 * @author Usuario
 */
    public class Cola<T> {
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
        return elementos.isEmpty();
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
        Queue<T> aux = new LinkedList<>(elementos);
        T ultimo = null;
        while (!aux.isEmpty()) {
            ultimo = aux.poll();
        }
        return ultimo;
    }

    // (c) Método para producir una cola al revés utilizando una pila
    public Cola<T> invertirCola() {
        Stack<T> pilaAuxiliar = new Stack<>();
        Queue<T> colaOriginalCopia = new LinkedList<>(this.elementos);

        while (!colaOriginalCopia.isEmpty()) {
            pilaAuxiliar.push(colaOriginalCopia.poll());
        }

        Cola<T> colaInvertida = new Cola<>();
        while (!pilaAuxiliar.isEmpty()) {
            colaInvertida.encolar(pilaAuxiliar.pop());
        }

        return colaInvertida;
    }

    // (d) Método para concatenar otra cola al final de la actual
    public void concatenar(Cola<T> otraCola) {
        if (otraCola != null && !otraCola.estaVacia()) {
            Iterator<T> it = otraCola.obtenerIterador();
            while (it.hasNext()) {
                this.encolar(it.next());
            }
        }
    }
}
