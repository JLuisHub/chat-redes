package cliente.tcp;
import java.net.*;
// importar la libreria java.net
import java.io.*;
// importar la libreria java.io
 
// declararamos la clase clientetcp
public class ClienteEnviaTCP extends Thread{
    protected BufferedReader in;
    // declaramos un objeto socket para realizar la comunicación
    protected Socket socket;
    protected final int PUERTO_SERVER;
    protected final String SERVER;
    protected DataOutputStream out;
    
    public ClienteEnviaTCP(String servidor, int puertoS)throws Exception{
        PUERTO_SERVER=puertoS;
        SERVER=servidor;
        
        // Creamos una instancia BuffererReader en la
        // que guardamos los datos introducido por el usuario
        in = new BufferedReader(new InputStreamReader(System.in));
        
        // Instanciamos un socket con la dirección del destino y el
        // puerto que vamos a utilizar para la comunicación
        socket = new Socket(SERVER,PUERTO_SERVER);
        
        // Declaramos e instanciamos el objeto DataOutputStream
        // que nos valdrá para enviar datos al servidor destino
        out =new DataOutputStream(socket.getOutputStream());
    }
    
    public void run () {

        // Declaramos un bloque try y catch para controlar la ejecución del subprograma
        try {
            sendFile();

            out.close();
            socket.close();
            in.close();
        }
        // utilizamos el catch para capturar los errores que puedan surgir
        catch (Exception e) {
            // si existen errores los mostrará en la consola y después saldrá del
            // programa
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private void sendFile() throws Exception{

        String path = in.readLine();

        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);   
        int size = (int)file.length();

        out.writeInt(size);
        out.writeUTF(file.getName());

        int byteRead;

        long totalBytes = 0;
        byte[] buffer = new byte[size];

        while( totalBytes!=size ){
            byteRead = fis.read(buffer);
            out.write(buffer, 0, byteRead);
            totalBytes+=byteRead;
        }

        System.out.println("\n*********************Archivo enviado**************************\n\n");

        fis.close();
    }

    private void sendMessage()throws Exception{
        String message;

        // Creamos un bucle do while en el que enviamos al servidor el mensaje
        // los datos que hemos obtenido despues de ejecutar la función
        // "readLine" en la instancia "in"
        do{
            // enviamos el mensaje codificado en UTF
            message = in.readLine();
            out.writeUTF(message);
        }while(!message.startsWith("fin"));
        // mientras el mensaje no encuentre la cadena fin, seguiremos ejecutando
        // el bucle do-while
    }
}
