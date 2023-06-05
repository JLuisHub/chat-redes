import servidor.tcp.ServidorTCP;
import servidor.udp.ServidorUDP;

public class MainServidor {
    public static void main(String[] args) {

        System.out.println("INICIO PROGRAMA");

        //Iniciar servidor TCP
        ServidorTCP servidorTCP=new ServidorTCP(60000);
        servidorTCP.inicia();

        //Iniciar servirod UDP
        ServidorUDP servidorUDP=new ServidorUDP(50000);
        servidorUDP.inicia();



    }
}