package ventana.eventos;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class EnviarMensaje implements ActionListener {

    private JTextArea cajaTexto;
    private static BlockingQueue<String> messageQueue; // Cola de mensajes compartida
    private static Object lock = new Object(); // Objeto de bloqueo

    public EnviarMensaje(JTextArea cajaText){
        this.cajaTexto = cajaText;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String texto = cajaTexto.getText();

        // Agregar el texto a la cola de mensajes
        messageQueue.offer(texto);

        synchronized (lock) {
            lock.notify();
        }
    }

    public static BlockingQueue<String> getMessageQueue() {
        return messageQueue;
    }

    public static Object getLock() {
        return lock;
    }

}
