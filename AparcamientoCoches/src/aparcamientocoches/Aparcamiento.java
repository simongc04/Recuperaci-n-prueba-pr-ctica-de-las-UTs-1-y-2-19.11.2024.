/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aparcamientocoches;

import java.util.Random;

/**
 *
 * @author simon
 */
public class Aparcamiento implements Runnable{


    
    private final String nombre;
    private final boolean aparcamiento1;
    private final boolean aparcamiento2;
    private final boolean aparcamiento3;
    private final boolean aparcamiento4;
    private final Aparcamiento aparcamiento;

    public Aparcamiento(String nombre, boolean aparcamiento1, boolean aparcamiento2, boolean aparcamiento3, boolean aparcamiento4, Aparcamiento aparcamiento) {
        this.nombre = nombre;
        this.aparcamiento1 = aparcamiento1;
        this.aparcamiento2 = aparcamiento2;
        this.aparcamiento3 = aparcamiento3;
        this.aparcamiento4 = aparcamiento4;
        this.aparcamiento = aparcamiento;
    }


    public String getNombre() {
        return nombre;
    }

    public boolean SolicitoAparcamiento1() {
        return aparcamiento1;
    }

    public boolean SolicitoAparcamiento2() {
        return aparcamiento2;
    }

    public boolean SolicitoAparcamiento3() {
        return aparcamiento3;
    }
    
    public boolean SolicitoAparcamiento4() {
        return aparcamiento4;
    }

    @Override
    public void run() {
        while (true) { 
            System.out.println(getNombre() + 1 + " intenta buscar el aparcamiento");

            boolean AparcamientoOcupados = aparcamiento.solicitarAparcamiento(SolicitoAparcamiento1(), SolicitoAparcamiento2(), SolicitoAparcamiento3(), SolicitoAparcamiento4());
            
            if (AparcamientoOcupados) {
                try {
                    int tiempoActividad = 50 + new Random().nextInt(151);
                    Thread.sleep(tiempoActividad); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                aparcamiento.liberarAparcamiento(SolicitoAparcamiento1(), SolicitoAparcamiento2(), SolicitoAparcamiento3(), SolicitoAparcamiento4());
            }

            try {
                int tiempoDescanso = 100 + new Random().nextInt(101);
                Thread.sleep(tiempoDescanso);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

  
}