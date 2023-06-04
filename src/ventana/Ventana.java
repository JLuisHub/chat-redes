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

    public void colocarTexto(String texto){
        this.elPanel.agregarTextoLabel(texto);
    }

    public void colocarBoton(String texto){
        this.elPanel.agregarBoton(texto);
    }

    public void colocarCajaTexto(int filas, int columnas) {
        this.elPanel.agregarCajaTexto(filas, columnas);
    }

}
