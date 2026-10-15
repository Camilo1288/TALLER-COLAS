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

    // (a) Crear una cola vacía
    public ColaCine() {
        this.clientesAsiduos = new LinkedList<>();
        this.clientesOcasionales = new LinkedList<>();
    }

    // (g) Consultar si una cola está vacía o no está vacía
    public boolean estaVacia() {
        return clientesAsiduos.isEmpty() && clientesOcasionales.isEmpty();
    }

    // (b) Añadir un elemento nuevo a una cola
    public void anadir(T elemento, boolean esAsiduo) {
        if (esAsiduo) {
            clientesAsiduos.offer(elemento);
        } else {
            clientesOcasionales.offer(elemento);
        }
    }

    // (c) Consultar el primer elemento de una cola
    public T consultarPrimero() {
        if (estaVacia()) {
            return null;
        }
        if (!clientesAsiduos.isEmpty()) {
            return clientesAsiduos.peek();
        }
        return clientesOcasionales.peek();
    }

    // (d) Eliminar el primer elemento de una cola
    public T eliminarPrimero() {
        if (estaVacia()) {
            return null;
        }
        if (!clientesAsiduos.isEmpty()) {
            return clientesAsiduos.poll();
        }
        return clientesOcasionales.poll();
    }

    // (e) Consultar el número de clientes ocasionales en una cola
    public int contarOcasionales() {
        return clientesOcasionales.size();
    }

    // (f) Consultar el número de clientes asiduos en una cola
    public int contarAsiduos() {
        return clientesAsiduos.size();
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        ColaCine<String> filaCine = new ColaCine<>();

        filaCine.anadir("Cliente Ocasional 1", false);
        filaCine.anadir("Cliente Asiduo 1", true);
        filaCine.anadir("Cliente Ocasional 2", false);
        filaCine.anadir("Cliente Asiduo 2", true);

        System.out.println("Clientes asiduos en fila: " + filaCine.contarAsiduos());
        System.out.println("Clientes ocasionales en fila: " + filaCine.contarOcasionales());

        System.out.println("Atendiendo a (debe ser asiduo): " + filaCine.eliminarPrimero());
        System.out.println("Siguiente en ser atendido: " + filaCine.consultarPrimero());
    }
}
