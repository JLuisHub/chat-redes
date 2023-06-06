package menu;

import servidor.tcp.ServidorEscuchaTCP;
import servidor.udp.ServidorEscuchaUDP;
import webcam.WebCamOutputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuServidor {

    private BufferedReader tecaldo;
    private final int SERVER = 55000;

    public MenuServidor() {
        this.tecaldo = new BufferedReader( new InputStreamReader(System.in));
    }

    public void start() {

        String eleccion;

        System.out.println("\n***Chat en red***\n");

        System.out.println("INICIANDO CHAT:\n");
        try {
            ServidorEscuchaUDP servidorEnvUDP=new ServidorEscuchaUDP(this.SERVER);
            servidorEnvUDP.start();
        }  catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }

        /*
        do {
            //Opciones
            System.out.println("#1.- Chatear");
            System.out.println("#Cualquier otro numero .- TERMINAR");

            try {
                eleccion = tecaldo.readLine();
            } catch (Exception e){
                eleccion = "0";
                System.err.println(e.getMessage());
                System.exit(1);
            }

            if(eleccion.compareTo("1")==0) {
                try {
                    iniciarChat();
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }

            //Lectura
        } while ( eleccion.compareTo("1")!=0);
        */

    }

}
