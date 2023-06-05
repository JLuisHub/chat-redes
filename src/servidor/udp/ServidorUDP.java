package servidor.udp;

import cliente.udp.ClienteEnviaUDP;

import java.net.DatagramSocket;

public class ServidorUDP{
    public final int PUERTO_SERVER;
    
    public ServidorUDP(int puertoS){
        PUERTO_SERVER=puertoS;
    }
    public void inicia()throws Exception{
        //DatagramSocket socket = new DatagramSocket(PUERTO_SERVER);
        ServidorEscuchaUDP servidorEnvUDP=new ServidorEscuchaUDP(PUERTO_SERVER);
        //ServidorEnviaUDP servidorEscUDP=new ServidorEnviaUDP(PUERTO_SERVER,socket);


        servidorEnvUDP.start();
        //servidorEscUDP.start();
    }
}
