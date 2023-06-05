package ventana;

import javax.swing.*;

public class Ventana extends JFrame {

    private Panel elPanel;

    public Ventana(String titulo, int alto, int ancho, int closeOperation) {
        this.setSize(ancho,alto);
        this.setLocationRelativeTo(null);
        this.setTitle(titulo);

        this.elPanel = new Panel();
        this.getContentPane().add(this.elPanel);

        this.setDefaultCloseOperation(closeOperation);
    }

    public int colocarTexto(String texto){
        return this.elPanel.agregarTextoLabel(texto);
    }

    public int colocarBoton(String texto){
        return this.elPanel.agregarBoton(texto);
    }

    public int colocarCajaTexto(int filas, int columnas) {
        return this.elPanel.agregarCajaTexto(filas, columnas);
    }

    public boolean asignarAccionEnvio(int idBoton, int idCajaText) {
        return this.elPanel.accionEnvioMensaje(idBoton, idCajaText);
    }

}
