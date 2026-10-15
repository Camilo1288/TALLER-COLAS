/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.tallercolas.ejercicio09;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 *
 * @author Usuario
 */
public class RestauranteManager {
  private List<Mesa> mesas;
    private Queue<Reservacion> colaEspera;

    public RestauranteManager() {
        this.mesas = new ArrayList<>();
        this.colaEspera = new LinkedList<>();
    }

    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public void agregarReservacion(Reservacion reservacion) {
        colaEspera.offer(reservacion);
    }

    
    public void reiniciarMesas() {
        for (Mesa m : mesas) {
            m.setOcupada(false);
        }
    }

    
    public void asignarMesasPrimeraDisponible() {
        System.out.println("=== VERSION 1: PRIMERA MESA DISPONIBLE ===");
        reiniciarMesas();
        Queue<Reservacion> colaAuxiliar = new LinkedList<>(colaEspera);

        while (!colaAuxiliar.isEmpty()) {
            Reservacion r = colaAuxiliar.poll();
            boolean asignada = false;

            for (Mesa m : mesas) {
                if (!m.isOcupada() && m.getCapacidad() >= r.getNumeroComensales()) {
                    m.setOcupada(true);
                    System.out.println("-> Mesa " + m.getCodigo() + " (Cap: " + m.getCapacidad() 
                        + ") asignada a " + r.getNombrePersona() + " (" + r.getNumeroComensales() + " comensales)");
                    asignada = true;
                    break;
                }
            }

            if (!asignada) {
                System.out.println("-> No hay mesa disponible para " + r.getNombrePersona() + " (" + r.getNumeroComensales() + " comensales)");
            }
        }
    }

    
    public void asignarMesasOptimizado() {
        System.out.println("\n=== VERSION 2: OPTIMIZANDO OCUPACION DE MESAS ===");
        reiniciarMesas();
        Queue<Reservacion> colaAuxiliar = new LinkedList<>(colaEspera);

        while (!colaAuxiliar.isEmpty()) {
            Reservacion r = colaAuxiliar.poll();
            Mesa mejorMesa = null;
            int menorDiferencia = Integer.MAX_VALUE;

            
            for (Mesa m : mesas) {
                if (!m.isOcupada() && m.getCapacidad() >= r.getNumeroComensales()) {
                    int diferencia = m.getCapacidad() - r.getNumeroComensales();
                    if (diferencia < menorDiferencia) {
                        menorDiferencia = diferencia;
                        mejorMesa = m;
                    }
                }
            }

            if (mejorMesa != null) {
                mejorMesa.setOcupada(true);
                System.out.println("-> Mesa óptima " + mejorMesa.getCodigo() + " (Cap: " + mejorMesa.getCapacidad() 
                    + ") asignada a " + r.getNombrePersona() + " (" + r.getNumeroComensales() + " comensales)");
            } else {
                System.out.println("-> No hay mesa disponible para " + r.getNombrePersona() + " (" + r.getNumeroComensales() + " comensales)");
            }
        }
    }

    
    public static void main(String[] args) {
        RestauranteManager rm = new RestauranteManager();

        
        rm.agregarMesa(new Mesa("M1", 2));
        rm.agregarMesa(new Mesa("M2", 4));
        rm.agregarMesa(new Mesa("M3", 6));
        rm.agregarMesa(new Mesa("M4", 4));

        
        rm.agregarReservacion(new Reservacion("Ana", 4));
        rm.agregarReservacion(new Reservacion("Carlos", 2));
        rm.agregarReservacion(new Reservacion("Beatriz", 4));

       
        rm.asignarMesasPrimeraDisponible();
        rm.asignarMesasOptimizado();
    }
}
