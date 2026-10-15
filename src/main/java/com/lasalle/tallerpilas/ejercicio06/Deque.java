/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.tallerpilas.ejercicio06;
import java.util.Iterator;
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

    // Método 1: agregar un elemento al inicio de la cola (bicola)
    public void agregarPrimero(T elem) {
        elementos.addFirst(elem);
    }

    // Método 2: eliminar el último elemento de la cola
    public T eliminarUltimo() {
        if (estaVacia()) {
            return null;
        }
        return elementos.pollLast();
    }

    // Método 3: obtener el último elemento sin eliminarlo
    public T ultimoElemento() {
        if (estaVacia()) {
            return null;
        }
        return elementos.peekLast();
    }

    // Método 4: obtener un iterador que se desplace sobre la cola de fin a inicio (en reversa)
    public Iterator<T> iteradorEnReversa() {
        return elementos.descendingIterator();
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        
        deque.encolar("Elemento B");
        deque.agregarPrimero("Elemento A");
        deque.encolar("Elemento C");
        
        System.out.println("Último elemento: " + deque.ultimoElemento());
        
        System.out.println("Iterando en reversa:");
        Iterator<String> itRev = deque.iteradorEnReversa();
        while (itRev.hasNext()) {
            System.out.println(itRev.next());
        }
        
        deque.eliminarUltimo();
        System.out.println("Último elemento tras eliminar el último: " + deque.ultimoElemento());
    }
}
