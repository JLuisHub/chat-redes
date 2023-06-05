package ventana;

import ventana.eventos.EnviarMensaje;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Component;

public class Panel extends JPanel {

    private ArrayList<Component> componentes;

    public Panel() {
        componentes = new ArrayList<Component>();
        this.setBackground(Color.ORANGE);
    }

    public int agregarTextoLabel(String texto) {
        JLabel nuevaEtiqueta = new JLabel(texto);
        //nuevaEtiqueta.setLocation(x,y);
        this.componentes.add(nuevaEtiqueta);
        this.add(nuevaEtiqueta);
        return this.componentes.size()-1;
    }

    public int agregarCajaTexto(int rows, int columnas) {
        JTextArea nuevaCajaTexto = new JTextArea(rows,columnas);
        //nuevaCajaTexto.setLocation(x,y);
        nuevaCajaTexto.setLineWrap(true);
        this.componentes.add(nuevaCajaTexto);
        this.add(nuevaCajaTexto);
        return this.componentes.size()-1;
    }

    public int agregarBoton(String texto) {
        JButton nuevoBoton = new JButton(texto);
        this.componentes.add(nuevoBoton);
        this.add(nuevoBoton);
        return this.componentes.size()-1;
    }

    public boolean accionEnvioMensaje(int idBoton, int idCajaTexto){
        boolean posibleConvertir = true;
        try {
            JButton boton = (JButton) this.componentes.get(idBoton);
            JTextArea caja = (JTextArea) this.componentes.get(idCajaTexto);
            boton.addActionListener(new EnviarMensaje(caja));
        } catch (Exception e) {
            posibleConvertir = false;
        } finally {
            return posibleConvertir;
        }
    }

    public void accionEnviarArchivo() {
        //TODO
    }

    public void accionLlamada() {
        //TODO
    }

}
