import cliente.tcp.ClienteTCP;
import cliente.udp.ClienteUDP;
import menu.MenuCliente;

import java.io.BufferedReader;


public class MainCliente {

    public static void main(String[] args) {

        /*
        //Iniciar cliente TCP
        ClienteTCP clienteTCP =new ClienteTCP("127.0.0.1",60000);

        //Iniciar cliente UDP
        ClienteUDP clienteUDP =new ClienteUDP("127.0.0.1",50000);

        try {
            clienteUDP.inicia();
            clienteTCP.inicia();
        } catch (Exception e) {
            System.out.println("Error en el cliente");
            System.exit(0);
        }

         */

        MenuCliente menuCliente = new MenuCliente();

        menuCliente.start();

    }
}
