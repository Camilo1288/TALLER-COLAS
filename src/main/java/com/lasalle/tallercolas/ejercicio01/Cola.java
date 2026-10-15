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

   
    public Iterator<T> obtenerIterador() {
        return elementos.iterator();
    }

    
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

    
    public void concatenar(Cola<T> otraCola) {
        if (otraCola != null && !otraCola.estaVacia()) {
            Iterator<T> it = otraCola.obtenerIterador();
            while (it.hasNext()) {
                this.encolar(it.next());
            }
        }
    }

    
    public static <T> Cola<T> intercalar(Cola<T> cola1, Cola<T> cola2) {
        Cola<T> colaResultado = new Cola<>();
        if (cola1 == null || cola2 == null) return colaResultado;

        Iterator<T> it1 = cola1.obtenerIterador();
        Iterator<T> it2 = cola2.obtenerIterador();

        while (it1.hasNext() || it2.hasNext()) {
            if (it1.hasNext()) {
                colaResultado.encolar(it1.next());
            }
            if (it2.hasNext()) {
                colaResultado.encolar(it2.next());
            }
        }

        return colaResultado;
    }

    
    public static void main(String[] args) {
        Cola<String> c1 = new Cola<>();
        c1.encolar("A");
        c1.encolar("B");
        c1.encolar("C");
        c1.encolar("D");

        System.out.println("Último elemento de c1: " + c1.obtenerUltimo());

        Cola<String> c1Invertida = c1.invertirCola();
        System.out.println("Cola invertida correctamente.");

        Cola<String> c2 = new Cola<>();
        c2.encolar("X");
        c2.encolar("Y");

        c1.concatenar(c2);
        System.out.println("Colas concatenadas con éxito.");
    }
}
