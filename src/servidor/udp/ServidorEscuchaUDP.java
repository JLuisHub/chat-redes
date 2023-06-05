package servidor.udp;

import java.net.*;
import java.io.*;
import java.rmi.server.ExportException;
import java.util.ArrayList;

public class ServidorEscuchaUDP extends Thread{
    protected DatagramSocket socket;
    protected final int PUERTO_SERVER;
    protected int puertoCliente=0;
    
    protected InetAddress addressCliente;
    protected byte[] mensaje2_bytes;
    protected final int MAX_BUFFER=256;
    protected DatagramPacket paquete;
    protected byte[] mensaje_bytes;
    protected DatagramPacket envPaquete;

    protected ArrayList< InetAddress > addresses;
    
    public ServidorEscuchaUDP(int puertoS) throws Exception{
        //Creamos el socket
        PUERTO_SERVER = puertoS;
        socket = new DatagramSocket(puertoS);

        addresses = new ArrayList<InetAddress>();
    }
    public void run() {
        try {
            mensaje_bytes=new byte[MAX_BUFFER];

            clientesConectados();

            String mensaje;
            //Iniciamos el bucle
            do {
                // Recibimos el paquete
                paquete = new DatagramPacket(mensaje_bytes,MAX_BUFFER);
                socket.receive(paquete);

                // Enviamos al paquete al receptor correspondiente
                sendPacket(paquete);

                // Lo formateamos
                mensaje_bytes=new byte[paquete.getLength()];
                mensaje_bytes=paquete.getData();
                mensaje = new String(mensaje_bytes,0,paquete.getLength()).trim();

            } while (!mensaje.startsWith("fin"));
            socket.close();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private void sendPacket(DatagramPacket packet)throws Exception{
        // Obtenemos el address del emisor
        addressCliente = packet.getAddress();
        puertoCliente = packet.getPort();

        // Obtenemos el address del receptor
        if( addresses.indexOf(addressCliente) == 1 )
            addressCliente = addresses.get(2);

        // Obtenemos el paquete el emisor
        mensaje2_bytes = packet.getData();

        //Preparamos el paquete que queremos enviar al receptor
        envPaquete = new DatagramPacket(mensaje2_bytes,mensaje2_bytes.length,addressCliente,puertoCliente);

        // realizamos el envio
        socket.send(envPaquete);
    }

    private void clientesConectados()throws Exception {
        DatagramPacket paqueteCliente;
        System.out.println("Clientes conectaods:");
        while(addresses.size()<2){ // clientes ya estan conectados
            paqueteCliente = new DatagramPacket(mensaje_bytes,MAX_BUFFER);
            socket.receive(paqueteCliente);
            addressCliente = paqueteCliente.getAddress();

            System.out.println("Cliente "+addressCliente);

            addresses.add(addressCliente);
        }
        System.out.println("Hay 2 clientec conetados...");
    }
}
