package com.piezas;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author felix
 */
public class Figura {

    public Bloque bloques[];
    int contadorDesplazamiento;
    private final int TIEMPO_DESPLAZAMIENTO = 60;

    public Figura() {
        bloques = new Bloque[4];
    }

    public void crearFigura(Color color) {
        bloques[0] = new Bloque(color);
        bloques[1] = new Bloque(color);
        bloques[2] = new Bloque(color);
        bloques[3] = new Bloque(color);
    }

    public void setXY(int x, int y) {
    }

    public void actualizarXY(int direccion) {
    }

    public void mover() {
        contadorDesplazamiento++;
        if (contadorDesplazamiento == TIEMPO_DESPLAZAMIENTO) {
            bloques[0].posY += Bloque.TAMANO;
            bloques[1].posY += Bloque.TAMANO;
            bloques[2].posY += Bloque.TAMANO;
            bloques[3].posY += Bloque.TAMANO;
            contadorDesplazamiento = 0;
        }
    }

    public void dibujar(Graphics2D g2d) {
        int MARGEN = 2;
        g2d.setColor(bloques[0].color);

        g2d.fillRect(bloques[0].posX + MARGEN, bloques[0].posY + MARGEN, Bloque.TAMANO - MARGEN, Bloque.TAMANO - MARGEN);
        g2d.fillRect(bloques[1].posX + MARGEN, bloques[1].posY + MARGEN, Bloque.TAMANO - MARGEN, Bloque.TAMANO - MARGEN);
        g2d.fillRect(bloques[2].posX + MARGEN, bloques[2].posY + MARGEN, Bloque.TAMANO - MARGEN, Bloque.TAMANO - MARGEN);
        g2d.fillRect(bloques[3].posX + MARGEN, bloques[3].posY + MARGEN, Bloque.TAMANO - MARGEN, Bloque.TAMANO - MARGEN);
    }
}
