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
    public void anadir(T elemento, boolean esAsiduo) {
        if (esAsiduo) {
            clientesAsiduos.offer(elemento);
        } else {
            clientesOcasionales.offer(elemento);
        }
    }

    // (c) Consultar el primer elemento de una cola (prioridad a asiduos)
    public T consultarPrimero() {
        if (estaVacia()) {
            return null;
        }
        if (!clientesAsiduos.isEmpty()) {
            return clientesAsiduos.peek();
        }
        return clientesOcasionales.peek();
    }

    // (d) Eliminar el primer elemento de una cola (prioridad a asiduos)
    public T eliminarPrimero() {
        if (estaVacia()) {
            return null;
        }
        if (!clientesAsiduos.isEmpty()) {
            return clientesAsiduos.poll();
        }
        return clientesOcasionales.poll();
    }
}
