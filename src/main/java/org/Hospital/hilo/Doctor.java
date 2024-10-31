package org.Hospital.hilo;

import org.Hospital.modelo.Paciente;
import org.Hospital.persistenciaBase.DataBaseManager;

public class Doctor extends Thread {
        private String nombre;
        private int pacientesAtendidos;

        public Doctor(String nombre) {
            this.nombre = nombre;
            this.pacientesAtendidos = 0;
        }

        @Override
        public void run() {
            while (true) {
                Paciente paciente = Paciente.atenderPaciente();
                if (paciente == null) break;

                try {

                    int tiempoAtencion = (int) (Math.random() * 5000 + 1000);
                    Thread.sleep(tiempoAtencion);
                    System.out.println(nombre + " ha atendido a " + paciente.getNombre());
                    pacientesAtendidos++;


                    DataBaseManager.guardarAtencion(paciente, nombre);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(nombre + " ha atendido un total de " + pacientesAtendidos + " pacientes.");
        }
    }


