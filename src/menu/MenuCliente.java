package menu;

import cliente.tcp.ClienteEnviaTCP;
import cliente.udp.ClienteEnviaUDP;
import cliente.udp.ClienteEscuchaUDP;
import webcam.WebCamInputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramSocket;

public class MenuCliente {
    private BufferedReader tecaldo;

    private String SERVER;
    private int PORT_SERVER;

    private DatagramSocket socket;

    public MenuCliente() {
        this.tecaldo = new BufferedReader(new InputStreamReader(System.in));
        SERVER = "127.0.0.1";
        PORT_SERVER = 55000;
    }

    public void enviarMensaje() throws Exception{
        System.out.println("MENSAJE A ESCRIBIR:\n");

        socket = new DatagramSocket();
        ClienteEnviaUDP clienteEsc = new ClienteEnviaUDP(socket, SERVER,PORT_SERVER);
        ClienteEscuchaUDP clienteEnv = new ClienteEscuchaUDP(socket);

        clienteEnv.run();
        clienteEsc.run();
    }

    public void enviarArchivo() throws Exception{
        ClienteEnviaTCP clienteTCP= new ClienteEnviaTCP(SERVER,55002);
        clienteTCP.start();
    }

    public void iniciarVideollamada() throws Exception{
        socket = new DatagramSocket();
        WebCamInputStream web = new WebCamInputStream(socket,SERVER,55003);
        web.start();
    }

    public void start() {
        String eleccion;

        System.out.println("\n***Chat en red***\n");

        do {
            //Opciones
            System.out.println("#1.- Chatear");
            System.out.println("#2.- Enviar archivo");
            System.out.println("#3.- Iniciar videollamada");
            System.out.println("#Cualquier otro numero .- TERMINAR");

            try {
                eleccion = tecaldo.readLine();


                switch (eleccion) {
                    case "1":
                        // secuencia de sentencias.
                        enviarMensaje();
                        break;
                    case "2":
                        // secuencia de sentencias.
                        enviarArchivo();
                        break;
                    case "3" :
                        // secuencia de sentencias.
                        iniciarVideollamada();
                        break;
                    default:
                        System.out.println("\n### FIN DEL PROGRAMA ###\n");
                }
            } catch (Exception e){
                eleccion = "0";
                System.err.println(e.getMessage());
                System.exit(1);
            }

            //Lectura
        } while ( eleccion.compareTo("0")>0 && eleccion.compareTo("4")<0);
    }
}
