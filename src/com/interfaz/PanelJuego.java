package com.interfaz;

import com.piezas.Figura;
import com.piezas.FiguraL1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author felix
 */
public class PanelJuego extends JPanel implements Runnable {

    public final int ANCHO = 1280;
    public final int ALTO = 620;
    //variables para el juego
    private boolean ejecutando;
    private Thread hiloJuego;
    private final Figura figura;

    public PanelJuego() {
        setPreferredSize(new Dimension(ANCHO, ALTO));
        setBackground(Color.black);
        setLayout(null);
        figura = new FiguraL1();
        figura.setXY(200, 20);
    }

    public void actualizar() {
        figura.mover();
    }

    public void empezarJuego() {
        hiloJuego = new Thread(this);
        hiloJuego.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        if (figura != null) {
            figura.dibujar(g2d);
        }
    }

    @Override
    public void run() {
        ejecutando = true;

        while (ejecutando) {
            long tiempoInicio = System.currentTimeMillis();
            actualizar(); //actualiza el juego 
            repaint(); //repinta la pantalla 
            long tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio;

            // Controlar la velocidad del bucle para apuntar a 60 FPS
            long tiempoDeEspera = Math.max(0, 16 - tiempoTranscurrido);

            try {
                Thread.sleep(tiempoDeEspera);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
