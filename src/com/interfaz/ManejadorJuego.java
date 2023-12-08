package com.interfaz;

import com.piezas.Bloque;
import com.piezas.Figura;
import com.piezas.FiguraL1;
import com.piezas.FiguraL2;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 *
 * @author felix
 */
public class ManejadorJuego {

    private final Figura figura;
    final int ANCHO = 360;
    final int ALTO = 560;

    //Limites para manejar colisiones
    public static int limiteDerecho;
    public static int limiteIzquierdo;
    public static int limiteInferior;
    public static int limiteSuperior;

    // Posición inicial de la figura en el centro del área de juego
    private int posicionInicialX;
    private int posicionInicialY;

    public ManejadorJuego() {
        // Calcular los límites al inicializar el manejador
        limiteIzquierdo = (PanelJuego.ANCHO - this.ANCHO) / 2;
        limiteDerecho = limiteIzquierdo + ANCHO;
        limiteSuperior = 30;
        limiteInferior = limiteSuperior + ALTO;

        // Calcular la posición inicial en el centro del área de juego
        posicionInicialX = (limiteIzquierdo + limiteDerecho) / 2;
        posicionInicialY = limiteSuperior + Bloque.TAMANO;

        figura = generarFigura();
        figura.setXY(posicionInicialX, posicionInicialY);
    }

    private Figura generarFigura() {
        Figura f = null;
        int random = new Random().nextInt(2);

        switch (random) {
            case 0 -> f = new FiguraL1();
            case 1 -> f = new FiguraL2();
        }
        return f;
    }

    public void actualizar() {
        figura.mover();
    }

    public void dibujar(Graphics2D g2d) {
        //Area del juego
        g2d.setColor(Color.white);
        g2d.drawRect(limiteIzquierdo, limiteSuperior, ANCHO, ALTO);
        if (figura != null) {
            figura.dibujar(g2d);
        }
    }
}
