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
        int MARGEN = 2;
        // Obtener el color original
        Color colorOriginal = color;

        // Calcular el tono más oscuro para el margen
        int r = Math.max(0, colorOriginal.getRed() - 50);
        int g = Math.max(0, colorOriginal.getGreen() - 50);
        int b = Math.max(0, colorOriginal.getBlue() - 50);
        Color colorMargen = new Color(r, g, b);

        // Dibujar el margen
        g2d.setColor(colorMargen);
        g2d.fillRect(posX, posY, TAMANO, TAMANO);

        // Dibujar el bloque con el color original
        g2d.setColor(colorOriginal);
        g2d.fillRect(posX + MARGEN, posY + MARGEN, TAMANO - (2 * MARGEN), TAMANO - (2 * MARGEN));

    }
}
