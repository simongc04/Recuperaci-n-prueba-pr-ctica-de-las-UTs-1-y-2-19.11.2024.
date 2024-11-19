/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aparcamientocoches;


/**
 *
 * @author simon
 */

public class BuscarAparcamiento implements Runnable{
    
    private boolean aparcamiento1 = true;     
    private boolean aparcamiento2 = true; 
    private boolean aparcamiento3 = true;  
    private boolean aparcamiento4 = true;      


    public synchronized boolean solicitarAparcamiento(boolean SolicitoAparcamiento1, boolean SolicitoAparcamiento2, boolean SolicitoAparcamiento3, boolean SolicitoAparcamiento4) {
        System.out.println(Thread.currentThread().getName() + " solicita comenzar la busqueda de aparcamiento: " +
                (SolicitoAparcamiento1 ? " LZ1 " : "") +
                (SolicitoAparcamiento2 ? " LZ2 " : "") +
                (SolicitoAparcamiento3 ? " LZ3 " : "") +
                (SolicitoAparcamiento4 ? "LZ4 " : ""));
        
        while ((SolicitoAparcamiento1 && !aparcamiento1) || 
               (SolicitoAparcamiento2 && !aparcamiento2) || 
               (SolicitoAparcamiento3 && !aparcamiento3) || 
               (SolicitoAparcamiento4 && !aparcamiento4)) {
{
            try {
                System.out.println(Thread.currentThread().getName() + " esperando aparcamiento...");
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (SolicitoAparcamiento1) aparcamiento1 = false;
        if (SolicitoAparcamiento2) aparcamiento2 = false;
        if (SolicitoAparcamiento3) aparcamiento3 = false;
        

        System.out.println(Thread.currentThread().getName() + " se ha ocupado el aparciento, ");

        return true;
    }

    public synchronized void liberarAparcamiento(boolean SolicitoAparcamiento1, boolean SolicitoAparcamiento2, boolean SolicitoAparcamiento3) {
        if (SolicitoAparcamiento1) aparcamiento1 = true;
        if (SolicitoAparcamiento2) aparcamiento2 = true;
        if (SolicitoAparcamiento3) aparcamiento3 = true;

        notifyAll();
        
        System.out.println(Thread.currentThread().getName() + " se ha ido el vehiculo estacionado, aparcamiento libre");
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

