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
        if (EscuchadorEventos.teclaEspacioPrecionada) {
            // Calcular y aplicar el desplazamiento hacia abajo de la figura
            int espacioDisponible = ManejadorJuego.limiteInferior - bloques[2].posY - Bloque.TAMANO;
            int desplazamientoDeseado = ManejadorJuego.limiteInferior;
            int desplazamientoReal = Math.min(desplazamientoDeseado, espacioDisponible);
            bloques[0].posY += desplazamientoReal;
            bloques[1].posY += desplazamientoReal;
            bloques[2].posY += desplazamientoReal;
            bloques[3].posY += desplazamientoReal;
            contadorDesplazamiento = 0;
            EscuchadorEventos.teclaEspacioPrecionada = false;
        }

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
            // Mover la figura hacia la derecha
            bloques[0].posX += Bloque.TAMANO;
            bloques[1].posX += Bloque.TAMANO;
            bloques[2].posX += Bloque.TAMANO;
            bloques[3].posX += Bloque.TAMANO;
            EscuchadorEventos.teclaDerechaPresionada = false;
        }

        if (EscuchadorEventos.teclaIzquierdaPresionada) {
            // Mover la figura hacia la izquierda
            bloques[0].posX -= Bloque.TAMANO;
            bloques[1].posX -= Bloque.TAMANO;
            bloques[2].posX -= Bloque.TAMANO;
            bloques[3].posX -= Bloque.TAMANO;
            EscuchadorEventos.teclaIzquierdaPresionada = false;
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
     * @param g2d Objeto Graphics2D para dibujar la figura.
     */
    public void dibujar(Graphics2D g2d) {
        int MARGEN = 2;
        g2d.setColor(bloques[0].color);

        // Dibujar cada bloque de la figura
        g2d.fillRect(bloques[0].posX + MARGEN, bloques[0].posY + MARGEN, Bloque.TAMANO - MARGEN, Bloque.TAMANO - MARGEN);
        g2d.fillRect(bloques[1].posX + MARGEN, bloques[1].posY + MARGEN, Bloque.TAMANO - MARGEN, Bloque.TAMANO - MARGEN);
        g2d.fillRect(bloques[2].posX + MARGEN, bloques[2].posY + MARGEN, Bloque.TAMANO - MARGEN, Bloque.TAMANO - MARGEN);
        g2d.fillRect(bloques[3].posX + MARGEN, bloques[3].posY + MARGEN, Bloque.TAMANO - MARGEN, Bloque.TAMANO - MARGEN);
    }
}
