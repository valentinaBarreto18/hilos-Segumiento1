package org.Hospital.modelo;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Paciente {
    private String nombre;

    private static ConcurrentLinkedQueue<Paciente> colaPacientes = new ConcurrentLinkedQueue<>();

    public Paciente(String nombre) {
        this.nombre = nombre;
        colaPacientes.add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public static Paciente atenderPaciente() {
        return colaPacientes.poll();
    }
}



