package ventana;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.*; //Color


public class Panel extends JPanel {

    private ArrayList<Component> componentes;

    public Panel() {
        componentes = new ArrayList<Component>();
        this.setBackground(Color.ORANGE);
    }

    public void agregarTextoLabel(String texto) {
        JLabel nuevaEtiqueta = new JLabel(texto);
        //nuevaEtiqueta.setLocation(x,y);
        this.componentes.add(nuevaEtiqueta);
        this.add(nuevaEtiqueta);
    }

    public void agregarCajaTexto(int rows, int columnas) {
        JTextArea nuevaCajaTexto = new JTextArea(rows,columnas);
        //nuevaCajaTexto.setLocation(x,y);
        nuevaCajaTexto.setLineWrap(true);
        this.componentes.add(nuevaCajaTexto);
        this.add(nuevaCajaTexto);
    }

    public void agregarBoton(String texto) {
        JButton nuevoBoton = new JButton(texto);
        //Agregar accion al boton
        nuevoBoton.addActionListener(agregarEvento());
        //TODO

        this.componentes.add(nuevoBoton);
        this.add(nuevoBoton);
    }

    public Eventos agregarEvento() {
        return new Eventos();
    }

}
