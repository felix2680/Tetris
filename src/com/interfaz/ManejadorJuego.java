package com.interfaz;

import com.piezas.Bloque;
import com.piezas.Figura;
import com.piezas.FiguraL1;
import com.piezas.FiguraL2;
import java.awt.BasicStroke;
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
        System.out.println("Liimite: " + limiteDerecho);
        figura = generarFigura();
        figura.setXY(posicionInicialX, posicionInicialY);
    }

    private Figura generarFigura() {
        Figura f = null;
        int random = new Random().nextInt(2);

        switch (random) {
            case 0 ->
                f = new FiguraL1();
            case 1 ->
                f = new FiguraL2();
        }
        return f;
    }

    public void actualizar() {
        figura.mover();
    }

    public void dibujar(Graphics2D g2d) {
        // Área del juego
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(4f));
        g2d.drawRect(limiteIzquierdo - 4, limiteSuperior - 4, ANCHO + 8, ALTO + 8);

        // Dibuja la cuadrícula tenue
        g2d.setColor(new Color(200, 200, 200, 30)); // Color tenue para la cuadrícula
        g2d.setStroke(new BasicStroke(1f)); // Grosor para la cuadrícula

        // Dibuja líneas horizontales
        for (int y = limiteSuperior; y <= limiteSuperior + ALTO; y += Bloque.TAMANO) {
            g2d.drawLine(limiteIzquierdo, y, limiteIzquierdo + ANCHO, y);
        }

        // Dibuja líneas verticales
        for (int x = limiteIzquierdo; x <= limiteIzquierdo + ANCHO; x += Bloque.TAMANO) {
            g2d.drawLine(x, limiteSuperior, x, limiteSuperior + ALTO);
        }

        if (figura != null) {
            figura.dibujar(g2d);
        }
    }
}
