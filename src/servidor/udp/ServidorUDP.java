package servidor.udp;

import servidor.udp.ServidorEscuchaUDP;
import webcam.WebCamOutputStream;

import java.net.DatagramSocket;


public class ServidorUDP{
    public final int PUERTO_SERVER;
    
    public ServidorUDP(int puertoS){
        PUERTO_SERVER=puertoS;
    }
    public void inicia()throws Exception{
        WebCamOutputStream web = new WebCamOutputStream( PUERTO_SERVER );
        web.run();


    }
}
