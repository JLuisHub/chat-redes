package cliente.udp;

import servidor.udp.ServidorEscuchaUDP;

import javax.swing.*;
import java.net.*;
import java.io.*;
 
//declaramos la clase udp escucha
public class ClienteEscuchaUDP extends Thread{
    //Definimos el sockets, número de bytes del buffer, y mensaje.
    protected final int MAX_BUFFER=256;
    protected final int PUERTO_CLIENTE;
    protected DatagramSocket socket;
    protected InetAddress address;
    protected DatagramPacket servPaquete;
    //protected String SERVER;

    private static JLabel label;

    public  ClienteEscuchaUDP(DatagramSocket socketNuevo){
        socket=socketNuevo;
        //SERVER=servidor;
        PUERTO_CLIENTE=socket.getLocalPort();
    }

    public static void setLabel(JLabel label) {
        ClienteEscuchaUDP.label = label;
    }
    public void run() {
        byte[] mensaje_bytes;
        String mensaje="";
        mensaje_bytes=mensaje.getBytes();
        
        String cadenaMensaje="";

        byte[] recogerServidor_bytes;

        try {
            do {
                recogerServidor_bytes = new byte[MAX_BUFFER];

                //Esperamos a recibir un paquete
                servPaquete = new DatagramPacket(recogerServidor_bytes,MAX_BUFFER);
                socket.receive(servPaquete);

                //Convertimos el mensaje recibido en un string
                cadenaMensaje = new String(recogerServidor_bytes).trim();

                //Imprimimos el paquete recibido
                //System.out.println("Mensaje recibido CEUDP\""+cadenaMensaje +"\" de "+
                //        servPaquete.getAddress()+"#"+servPaquete.getPort());

                //Lo mostramos en la interfaz grafica
                this.label.setText("Mensaje Cli\n:"+mensaje);

            } while (!cadenaMensaje.startsWith("fin"));

            socket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println("Excepcion C: "+e.getMessage());
            System.exit(1);
        }
    }
}
