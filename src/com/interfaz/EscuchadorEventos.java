package com.interfaz;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author felix
 */
public class EscuchadorEventos implements KeyListener {

    public static boolean teclaAbajoPresionada, teclaDerechaPresionada, teclaIzquierdaPresionada, teclaArribaPresionada;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S) {
            teclaAbajoPresionada = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            teclaIzquierdaPresionada = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            teclaDerechaPresionada = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            teclaArribaPresionada = true;
            System.out.println("Hola");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
