package ventana.eventos;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnviarMensaje implements ActionListener {

    private JTextArea cajaTexto;
    private static BlockingQueue<String> messageQueue; // Cola de mensajes compartida
    private static Object lock = new Object(); // Objeto de bloqueo

    public EnviarMensaje(JTextArea cajaText){
        this.cajaTexto = cajaText;
        if (messageQueue == null) {
            messageQueue = new LinkedBlockingQueue<>();
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String texto = cajaTexto.getText();

        // Agregar el texto a la cola de mensajes
        messageQueue.offer(texto);

        synchronized (lock) {
            lock.notify();
        }
        System.out.println("Enviar mensaje "+texto);
    }

    public static BlockingQueue<String> getMessageQueue() {
        return messageQueue;
    }

    public static Object getLock() {
        return lock;
    }

}
