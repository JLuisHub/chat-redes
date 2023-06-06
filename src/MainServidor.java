
import menu.MenuServidor;
import servidor.tcp.ServidorTCP;
import servidor.udp.ServidorUDP;

public class MainServidor {
    public static void main(String[] args) {

        /*
        System.out.println("INICIO PROGRAMA");

        //Iniciar servidor TCP
        ServidorTCP servidorTCP=new ServidorTCP(60000);

        //Iniciar servirod UDP
        ServidorUDP servidorUDP=new ServidorUDP(50000);

        try {
            servidorTCP.inicia();
            servidorUDP.inicia();
        } catch (Exception e) {
            System.out.println("Error en el servidor");
            System.exit(0);
        }

         */

        MenuServidor menuServidor = new MenuServidor();

        menuServidor.start();
    }
}