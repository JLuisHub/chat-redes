package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {

    private BufferedReader tecaldo;

    public Menu() {
        this.tecaldo = new BufferedReader( new InputStreamReader(System.in));
    }

    public void enviarMensaje() {
        System.out.println("MENSAJE A ESCRIBIR:\n");
    }

    public void enviarArchivo() {
        //TODO
    }

    public void iniciarVideollamada() {
        //TODO
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
            } catch (Exception e){
                eleccion = "0";
                System.err.println(e.getMessage());
                System.exit(1);
            }

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

            //Lectura
        } while ( eleccion.compareTo("0")>0 && eleccion.compareTo("4")<0);
    }
}
