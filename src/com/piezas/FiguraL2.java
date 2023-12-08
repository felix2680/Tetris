package com.piezas;

import java.awt.Color;

/**
 *
 * @author felix
 */
public class FiguraL2 extends Figura {

    public FiguraL2() {
        super.crearFigura(Color.blue);
    }

    @Override
    public void setXY(int x, int y) {
        bloques[0].posX = x;
        bloques[0].posY = y;
        bloques[1].posX = bloques[0].posX;
        bloques[1].posY = bloques[0].posY - Bloque.TAMANO;
        bloques[2].posX = bloques[0].posX;
        bloques[2].posY = bloques[0].posY + Bloque.TAMANO;
        bloques[3].posX = bloques[0].posX - Bloque.TAMANO;
        bloques[3].posY = bloques[0].posY + Bloque.TAMANO;
    }
}
