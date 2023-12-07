package com.piezas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author felix
 */
public class Bloque extends Rectangle {

    public static final int TAMANO = 20;
    public int posX;
    public int posY;
    public Color color;

    public Bloque(Color color) {
        this.color = color;
    }

    public void dibujar(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(posX, posY, TAMANO, TAMANO);
    }
}
