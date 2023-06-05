package ventana.eventos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnviarMensaje implements ActionListener {

    private JTextArea cajaTexto;

    public EnviarMensaje(JTextArea cajaText){
        this.cajaTexto = cajaText;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Texto caja " + cajaTexto.getText());
    }

}
