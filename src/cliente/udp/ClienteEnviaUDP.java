package cliente.udp;

import java.net.*;
import java.io.*;
 
//declaramos la clase udp envia
public class ClienteEnviaUDP extends Thread{
    protected BufferedReader in;
    //Definimos el sockets, número de bytes del buffer, y mensaje.
    protected final int MAX_BUFFER=256;
    protected final int PUERTO_SERVER;
    protected DatagramSocket socket;
    protected InetAddress address;
    protected DatagramPacket paquete;
    protected final String SERVER;
    
    public ClienteEnviaUDP(DatagramSocket nuevoSocket, String servidor, int puertoServidor){
        socket = nuevoSocket;
        SERVER=servidor;
        PUERTO_SERVER=puertoServidor;
    }
    
    public void run() {
        in = new BufferedReader(new InputStreamReader(System.in));
        String mensaje="";


        try {
            address=InetAddress.getByName(SERVER);
            System.out.println("Conectando...");
            sendPacket("hola");
            do {
                mensaje = in.readLine();
                sendPacket(mensaje);

                System.out.println("Mensaje \""+ mensaje );
            } while (!mensaje.startsWith("fin"));
            in.close();
            socket.close();
        }
        catch (Exception e) {
            System.err.println("Exception "+e.getMessage());
            System.exit(1);
        }
    }

    private void sendPacket(String message)throws Exception{
        byte[] mensaje_bytes = message.getBytes();
        paquete = new DatagramPacket(mensaje_bytes,message.length(),address,PUERTO_SERVER);
        socket.send(paquete);
        System.out.println("paquete enviado");
    }

}
