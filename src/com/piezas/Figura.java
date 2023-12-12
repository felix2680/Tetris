package com.piezas;

import com.interfaz.EscuchadorEventos;
import com.interfaz.ManejadorJuego;
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
    private boolean colisionInferior, colisionIzquierda, colisionDerecha;

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

    /**
     * Establece las coordenadas X e Y de la figura.
     *
     * @param x Coordenada X.
     * @param y Coordenada Y.
     */
    public void setXY(int x, int y) {

    }

    /**
     * Gira la figura en la dirección especificada.
     *
     * @param direccion Dirección de giro.
     */
    public void girar(int direccion) {
        this.direccion = direccion;

        // Actualiza las posiciones de los bloques de acuerdo a la dirección de giro.
        bloques[0].posX = bloquesTemp[0].posX;
        bloques[0].posY = bloquesTemp[0].posY;
        bloques[1].posX = bloquesTemp[1].posX;
        bloques[1].posY = bloquesTemp[1].posY;
        bloques[2].posX = bloquesTemp[2].posX;
        bloques[2].posY = bloquesTemp[2].posY;
        bloques[3].posX = bloquesTemp[3].posX;
        bloques[3].posY = bloquesTemp[3].posY;
    }

    // Métodos de dirección.
    public void direccion1() {
    }

    public void direccion2() {
    }

    public void direccion3() {
    }

    public void direccion4() {
    }

    private void detectarColisionMovimiento() {
        colisionDerecha = false;
        colisionInferior = false;
        colisionIzquierda = false;
        //Detecta la colision en el limite izquierdo
        for (Bloque b : bloques) {
            if (b.posX == ManejadorJuego.limiteIzquierdo) {
                colisionIzquierda = true;
            }
        }
        //Detecta la colision en el limite derecho
        for (Bloque b : bloques) {
            if (b.posX + Bloque.TAMANO == ManejadorJuego.limiteDerecho) {
                colisionDerecha = true;
            }
        }
    }

    /**
     * Mueve la figura en la dirección especificada por las teclas presionadas.
     */
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
        detectarColisionMovimiento();

        if (EscuchadorEventos.teclaAbajoPresionada) {
            // Mover la figura hacia abajo
            bloques[0].posY += Bloque.TAMANO;
            bloques[1].posY += Bloque.TAMANO;
            bloques[2].posY += Bloque.TAMANO;
            bloques[3].posY += Bloque.TAMANO;

            contadorDesplazamiento = 0;
            EscuchadorEventos.teclaAbajoPresionada = false;
        }

        if (EscuchadorEventos.teclaDerechaPresionada) {
            // si no existe colision, mueve la figura hacia a la derecha
            if (!colisionDerecha) {
                bloques[0].posX += Bloque.TAMANO;
                bloques[1].posX += Bloque.TAMANO;
                bloques[2].posX += Bloque.TAMANO;
                bloques[3].posX += Bloque.TAMANO;
                System.out.println(bloques[3].posX);
                EscuchadorEventos.teclaDerechaPresionada = false;
            }
        }

        if (EscuchadorEventos.teclaIzquierdaPresionada) {
            // si no existe colision, mueve la figura hacia a la izquierda
            if (!colisionIzquierda) {
                bloques[0].posX -= Bloque.TAMANO;
                bloques[1].posX -= Bloque.TAMANO;
                bloques[2].posX -= Bloque.TAMANO;
                bloques[3].posX -= Bloque.TAMANO;
                EscuchadorEventos.teclaIzquierdaPresionada = false;
            }
        }

        // Realizar un desplazamiento automático hacia abajo después de un tiempo específico
        contadorDesplazamiento++;
        if (contadorDesplazamiento == TIEMPO_DESPLAZAMIENTO) {
            bloques[0].posY += Bloque.TAMANO;
            bloques[1].posY += Bloque.TAMANO;
            bloques[2].posY += Bloque.TAMANO;
            bloques[3].posY += Bloque.TAMANO;
            contadorDesplazamiento = 0;
        }
    }

    /**
     * Dibuja la figura en el lienzo.
     *
     * @param g2d
     */
    public void dibujar(Graphics2D g2d) {
        int TAMANO = Bloque.TAMANO;
        int MARGEN = 2;
        for (Bloque bloque : bloques) {
            // Obtener el color original
            Color colorOriginal = bloque.color;

            // Calcular el tono más oscuro para el margen
            int r = Math.max(0, colorOriginal.getRed() - 50);
            int g = Math.max(0, colorOriginal.getGreen() - 50);
            int b = Math.max(0, colorOriginal.getBlue() - 50);
            Color colorMargen = new Color(r, g, b);

            // Dibujar el margen
            g2d.setColor(colorMargen);
            g2d.fillRect(bloque.posX, bloque.posY, TAMANO, TAMANO);

            // Dibujar el bloque con el color original
            g2d.setColor(colorOriginal);
            g2d.fillRect(bloque.posX + MARGEN, bloque.posY + MARGEN, TAMANO - (2 * MARGEN), TAMANO - (2 * MARGEN));
        }
    }
}
