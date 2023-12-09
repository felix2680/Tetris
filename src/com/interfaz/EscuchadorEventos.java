package com.interfaz;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author felix
 */
public class EscuchadorEventos implements KeyListener {

    public static boolean teclaAbajoPresionada, teclaDerechaPresionada, teclaIzquierdaPresionada, teclaArribaPresionada;
    public static boolean teclaEspacioPrecionada;

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
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            teclaEspacioPrecionada = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
