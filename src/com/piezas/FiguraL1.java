package com.piezas;

import java.awt.Color;

/**
 *
 * @author felix
 */
public class FiguraL1 extends Figura {

    public FiguraL1() {
        super.crearFigura(Color.orange);
    }

    @Override
    public void setXY(int x, int y) {
        bloques[0].posX = x;
        bloques[0].posY = y;
        bloques[1].posX = bloques[0].posX;
        bloques[1].posY = bloques[0].posY + Bloque.TAMANO;
        bloques[2].posX = bloques[0].posX;
        bloques[2].posY = bloques[1].posY + Bloque.TAMANO;
        bloques[3].posX = bloques[0].posX + Bloque.TAMANO;
        bloques[3].posY = bloques[2].posY;
    }
}
