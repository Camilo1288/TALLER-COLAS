/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.talllercolas.ejercicio08;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 *
 * @author Usuario
 */
public class AlmacenManager {
    private Stack<Consola> almacenConsolas; // Pila: últimas en llegar más cerca de la puerta
    private Queue<SolicitudTienda> colaSolicitudes; // Cola: orden de llegada de pedidos

    public AlmacenManager() {
        this.almacenConsolas = new Stack<>();
        this.colaSolicitudes = new LinkedList<>();
    }

    public void agregarConsolaAlAlmacen(Consola consola) {
        almacenConsolas.push(consola);
    }

    public void agregarSolicitud(SolicitudTienda solicitud) {
        colaSolicitudes.offer(solicitud);
    }

    // Método para procesar y asignar las consolas a las tiendas según las solicitudes
    public void asignarConsolasATiendas() {
        while (!colaSolicitudes.isEmpty() && !almacenConsolas.isEmpty()) {
            SolicitudTienda solicitud = colaSolicitudes.poll();
            System.out.println("Procesando solicitud de: " + solicitud.getNombreTienda() 
                + " (Solicita: " + solicitud.getCantidadSolicitada() + " consolas)");
            
            int asignadas = 0;
            while (asignadas < solicitud.getCantidadSolicitada() && !almacenConsolas.isEmpty()) {
                Consola consolaAsignada = almacenConsolas.pop();
                System.out.println(" -> Consola entregada: " + consolaAsignada.getCodigo() 
                    + " (" + consolaAsignada.getDescripcion() + ")");
                asignadas++;
            }
            
            if (asignadas < solicitud.getCantidadSolicitada()) {
                System.out.println(" -> Aviso: No habian suficientes consolas para cubrir toda la solicitud.");
            }
        }
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        AlmacenManager manager = new AlmacenManager();

        // 1. Ingresar consolas al almacén (se apilan: la última en entrar queda arriba)
        manager.agregarConsolaAlAlmacen(new Consola("C001", "Consola Modelo A"));
        manager.agregarConsolaAlAlmacen(new Consola("C002", "Consola Modelo B"));
        manager.agregarConsolaAlAlmacen(new Consola("C003", "Consola Modelo C"));

        // 2. Registrar las solicitudes de las tiendas (en orden de llegada)
        manager.agregarSolicitud(new SolicitudTienda("Tienda Norte", 2));
        manager.agregarSolicitud(new SolicitudTienda("Tienda Sur", 1));

        // 3. Ejecutar la asignación
        System.out.println("=== INICIANDO ASIGNACION DE CONSOLAS ===");
        manager.asignarConsolasATiendas();
    }
}
