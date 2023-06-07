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
        ClienteEscuchaUDP clienteEnvUDP=new ClienteEscuchaUDP(socket);
        ClienteEnviaUDP clienteEscUDP=new ClienteEnviaUDP(socket, SERVER, PORT_SERVER);

        clienteEnvUDP.start();
        clienteEscUDP.start();
    }

    public void enviarArchivo() throws Exception{
        System.out.println("Dar la ruta del archivo...");
        ClienteEnviaTCP clienteTCP= new ClienteEnviaTCP(SERVER,PORT_SERVER);
        clienteTCP.start();
    }

    public void iniciarVideollamada() throws Exception{
        System.out.println("Estableciendo videollamada...");
        socket = new DatagramSocket();
        WebCamInputStream web = new WebCamInputStream(socket,"192.168.0.2",PORT_SERVER);
        web.start();
    }

    public void start() {
        String eleccion;

        //Opciones
        System.out.println("#1.- Chatear");
        System.out.println("#2.- Enviar archivo");
        System.out.println("#3.- Iniciar videollamada");
        System.out.println("#Cualquier otro numero .- TERMINAR");

        try {
            eleccion = tecaldo.readLine();

            if(eleccion.equals("1"))
                enviarMensaje();
            else if (eleccion.equals("2")) {
                enviarArchivo();
            }else if(eleccion.equals("3"))
                iniciarVideollamada();

        } catch (Exception e){
            eleccion = "0";
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }
}
