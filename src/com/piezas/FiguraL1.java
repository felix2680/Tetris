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
        bloques[1].posY = bloques[0].posY - Bloque.TAMANO;
        bloques[2].posX = bloques[0].posX;
        bloques[2].posY = bloques[0].posY + Bloque.TAMANO;
        bloques[3].posX = bloques[0].posX + Bloque.TAMANO;
        bloques[3].posY = bloques[0].posY + Bloque.TAMANO;
    }
    
    @Override
    public void direccion1() {
        bloquesTemp[0].posX = bloques[0].posX;
        bloquesTemp[0].posY = bloques[0].posY;
        bloquesTemp[1].posX = bloques[0].posX;
        bloquesTemp[1].posY = bloques[0].posY + Bloque.TAMANO;
        bloquesTemp[2].posX = bloques[0].posX;
        bloquesTemp[2].posY = bloques[1].posY + Bloque.TAMANO;
        bloquesTemp[3].posX = bloques[0].posX + Bloque.TAMANO;
        bloquesTemp[3].posY = bloques[2].posY;
        
        girar(1);
    }
    
    @Override
    public void direccion2() {
        bloquesTemp[0].posX = bloques[0].posX;
        bloquesTemp[0].posY = bloques[0].posY;
        bloquesTemp[1].posX = bloques[0].posX + Bloque.TAMANO;
        bloquesTemp[1].posY = bloques[0].posY;
        bloquesTemp[2].posX = bloques[0].posX - Bloque.TAMANO;
        bloquesTemp[2].posY = bloques[0].posY;
        bloquesTemp[3].posX = bloques[0].posX - Bloque.TAMANO;
        bloquesTemp[3].posY = bloques[0].posY + Bloque.TAMANO;
        
        girar(2);
    }
    
    @Override
    public void direccion3() {
        
    }
    
    @Override
    public void direccion4() {
    }
}
