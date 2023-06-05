package ventana.eventos;

import cliente.udp.ClienteEnviaUDP;
import servidor.udp.ServidorEscuchaUDP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnviarMensaje implements ActionListener {

    private JTextArea cajaTexto;

    private ServidorEscuchaUDP SEUPD;

    public EnviarMensaje(JTextArea cajaText){
        this.cajaTexto = cajaText;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String texto = cajaTexto.getText();



        System.out.println("Enviar mensaje "+texto);
    }

}
