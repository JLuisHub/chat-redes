import cliente.tcp.ClienteTCP;
import cliente.udp.ClienteUDP;
import menu.Menu;

public class MainCliente {
    public static void main(String[] args) {

        //Iniciar cliente TCP
        ClienteTCP clienteTCP =new ClienteTCP("127.0.0.1",60000);
        clienteTCP.inicia();

        //Iniciar cliente UDP
        ClienteUDP clienteUDP =new ClienteUDP("127.0.0.1",50000);
        clienteUDP.inicia();

        Menu menuPrincipal = new Menu();

        menuPrincipal.start();

    }
}
