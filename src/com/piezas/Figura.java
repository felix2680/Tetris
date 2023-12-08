package com.piezas;

import com.interfaz.EscuchadorEventos;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author felix
 */
public class Figura {

    public Bloque bloques[];
    public Bloque bloquesTemp[];
    int contadorDesplazamiento;
    private final int TIEMPO_DESPLAZAMIENTO = 60;
    private int direccion;

    public Figura() {
        bloques = new Bloque[4];
        bloquesTemp = new Bloque[4];
        direccion = 1;
    }

    public void crearFigura(Color color) {
        bloques[0] = new Bloque(color);
        bloques[1] = new Bloque(color);
        bloques[2] = new Bloque(color);
        bloques[3] = new Bloque(color);
        bloquesTemp[0] = new Bloque(color);
        bloquesTemp[1] = new Bloque(color);
        bloquesTemp[2] = new Bloque(color);
        bloquesTemp[3] = new Bloque(color);
    }

    public void setXY(int x, int y) {
    }

    public void girar(int direccion) {

        this.direccion = direccion;

        bloques[0].posX = bloquesTemp[0].posX;
        bloques[0].posY = bloquesTemp[0].posY;
        bloques[1].posX = bloquesTemp[1].posX;
        bloques[1].posY = bloquesTemp[1].posY;
        bloques[2].posX = bloquesTemp[2].posX;
        bloques[2].posY = bloquesTemp[2].posY;
        bloques[3].posX = bloquesTemp[3].posX;
        bloques[3].posY = bloquesTemp[3].posY;
    }

    public void direccion1() {
    }

    public void direccion2() {
    }

    public void direccion3() {
    }

    public void direccion4() {
    }

    public void mover() {
        if (EscuchadorEventos.teclaArribaPresionada) {
            switch (direccion) {
                case 1 ->
                    direccion2();
                case 2 ->
                    direccion3();
                case 3 ->
                    direccion4();
                case 4 ->
                    direccion1();
            }

            EscuchadorEventos.teclaArribaPresionada = false;
        }
        if (EscuchadorEventos.teclaAbajoPresionada) {
            bloques[0].posY += Bloque.TAMANO;
            bloques[1].posY += Bloque.TAMANO;
            bloques[2].posY += Bloque.TAMANO;
            bloques[3].posY += Bloque.TAMANO;

            contadorDesplazamiento = 0;
            EscuchadorEventos.teclaAbajoPresionada = false;
        }

        if (EscuchadorEventos.teclaDerechaPresionada) {
            bloques[0].posX += Bloque.TAMANO;
            bloques[1].posX += Bloque.TAMANO;
            bloques[2].posX += Bloque.TAMANO;
            bloques[3].posX += Bloque.TAMANO;
            EscuchadorEventos.teclaDerechaPresionada = false;
        }

        if (EscuchadorEventos.teclaIzquierdaPresionada) {
            bloques[0].posX -= Bloque.TAMANO;
            bloques[1].posX -= Bloque.TAMANO;
            bloques[2].posX -= Bloque.TAMANO;
            bloques[3].posX -= Bloque.TAMANO;
            EscuchadorEventos.teclaIzquierdaPresionada = false;
        }
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
