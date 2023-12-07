package com.interfaz;

import com.piezas.Figura;
import com.piezas.FiguraL1;
import java.awt.Graphics2D;

/**
 *
 * @author felix
 */
public class ManejadorJuego {

    private final Figura figura;

    public ManejadorJuego() {
        figura = new FiguraL1();
        figura.setXY(200, 20);
    }

    public void actualizar() {
        figura.mover();
    }

    public void dibujar(Graphics2D g2d) {
        if (figura != null) {
            figura.dibujar(g2d);
        }
    }
}
