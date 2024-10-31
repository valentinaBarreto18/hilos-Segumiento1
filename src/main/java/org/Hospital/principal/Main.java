package org.Hospital.principal;

import org.Hospital.hilo.Doctor;
import org.Hospital.modelo.Paciente;

public class Main {
    public static void main(String[] args) {

        new Paciente("nicolas");
        new Paciente("Mariana");
        new Paciente("Carlos");
        new Paciente("xiomara");
        new Paciente("Sofia");


        Doctor doctor1 = new Doctor("Dr. Alejandro");
        Doctor doctor2 = new Doctor("Dr. Hernandez");
        doctor1.start();
        doctor2.start();


        try {
            doctor1.join();
            doctor2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
