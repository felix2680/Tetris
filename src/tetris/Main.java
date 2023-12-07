package tetris;

import com.interfaz.PanelJuego;
import javax.swing.JFrame;

/**
 *
 * @author felix
 */
public class Main {

    public static void main(String[] args) {
        JFrame ventanaJuego = new JFrame("Tetris");
        PanelJuego panel = new PanelJuego();

        //Añadimos el panel del juego a la ventana
        ventanaJuego.add(panel);
        ventanaJuego.pack();

        ventanaJuego.setLocationRelativeTo(null);
        ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaJuego.setVisible(true);
        panel.empezarJuego();
    }

}
