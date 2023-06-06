package cliente.udp;

import java.net.*;

import webcam.WebCamInputStream;

import java.io.*;
 
//declaramos la clase udp
public class ClienteUDP{
    protected final int PUERTO_SERVER;
    protected final String SERVER;
    
    public ClienteUDP(String servidor, int puertoS){
        PUERTO_SERVER=puertoS;
        SERVER=servidor;
    }
    
    public void inicia()throws Exception{
        DatagramSocket socket=new DatagramSocket();

        WebCamInputStream web = new WebCamInputStream(socket, SERVER, PUERTO_SERVER);

        web.start();
        
        /* 
        ClienteEscuchaUDP clienteEnvUDP=new ClienteEscuchaUDP(socket);
        ClienteEnviaUDP clienteEscUDP=new ClienteEnviaUDP(socket, SERVER, PUERTO_SERVER);
        
        clienteEnvUDP.start();
        clienteEscUDP.start();
        */
    }
}
