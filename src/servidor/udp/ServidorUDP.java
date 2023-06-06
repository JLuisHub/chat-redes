package servidor.udp;

import servidor.udp.ServidorEscuchaUDP;
import webcam.WebCamOutputStream;
import cliente.udp.ClienteEnviaUDP;

import java.net.DatagramSocket;


public class ServidorUDP{
    public final int PUERTO_SERVER;
    
    public ServidorUDP(int puertoS){
        PUERTO_SERVER=puertoS;
    }
    public void inicia()throws Exception{
        //ServidorEscuchaUDP servidorUDP=new ServidorEscuchaUDP(PUERTO_SERVER);

        WebCamOutputStream web = new WebCamOutputStream( PUERTO_SERVER );

        web.run();
        
        //servidorUDP.start();
      
              //DatagramSocket socket = new DatagramSocket(PUERTO_SERVER);
        ServidorEscuchaUDP servidorEnvUDP=new ServidorEscuchaUDP(PUERTO_SERVER);
        //ServidorEnviaUDP servidorEscUDP=new ServidorEnviaUDP(PUERTO_SERVER,socket);


        servidorEnvUDP.start();
        //servidorEscUDP.start();
    }
}
