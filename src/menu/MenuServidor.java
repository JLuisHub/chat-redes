package menu;

import cliente.tcp.ClienteEnviaTCP;
import cliente.udp.ClienteEnviaUDP;
import cliente.udp.ClienteEscuchaUDP;
import servidor.tcp.ServidorEscuchaTCP;
import servidor.udp.ServidorEscuchaUDP;
import webcam.WebCamInputStream;
import webcam.WebCamOutputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramSocket;

public class MenuServidor {

    private BufferedReader tecaldo;
    private final int SERVER = 55000;

    public MenuServidor() {
        this.tecaldo = new BufferedReader( new InputStreamReader(System.in));
    }


    public void enviarMensaje() throws Exception{
        System.out.println("MENSAJE A ESCRIBIR:\n");

        ServidorEscuchaUDP servidorUDP=new ServidorEscuchaUDP(SERVER);

        servidorUDP.start();
    }

    public void recibirArchivo() throws Exception{
        ServidorEscuchaTCP servidorTCP=new ServidorEscuchaTCP(SERVER);

        servidorTCP.start();
    }

    public void iniciarVideollamada() throws Exception{
        WebCamOutputStream web = new WebCamOutputStream( SERVER );

        web.start();
    }


    public void start() {

        String eleccion;
        //Opciones
        System.out.println("#1.- Chatear");
        System.out.println("#2.- recibir archivo");
        System.out.println("#3.- Iniciar videollamada");
        System.out.println("#Cualquier otro numero .- TERMINAR");

        try {
            eleccion = tecaldo.readLine();

            if(eleccion.equals("1"))
                enviarMensaje();
            else if (eleccion.equals("2")) {
                recibirArchivo();
            }else if(eleccion.equals("3"))
                iniciarVideollamada();

        } catch (Exception e){
            eleccion = "0";
            System.err.println(e.getMessage());
            System.exit(1);
        }


    }

}
