package servidor.tcp;

import java.net.*;
//importar la libreria java.net
 
import java.io.*;
//importar la libreria java.io
// declaramos la clase servidortcp
 
public class ServidorEscuchaTCP extends Thread {
    // declaramos un objeto ServerSocket para realizar la comunicación
    protected ServerSocket socket;
    protected DataInputStream in;
    protected Socket socket_cli;
    protected final int PUERTO_SERVER;
    
    public ServidorEscuchaTCP(int puertoS)throws Exception{
        PUERTO_SERVER=puertoS;
        // Instanciamos un ServerSocket con la dirección del destino y el
        // puerto que vamos a utilizar para la comunicación

        socket = new ServerSocket(PUERTO_SERVER);
    }
    // método principal main de la clase
    public void run() {
        // Declaramos un bloque try y catch para controlar la ejecución del subprograma
        try {
            // Creamos un socket_cli al que le pasamos el contenido del objeto socket después
            // de ejecutar la función accept que nos permitirá aceptar conexiones de clientes
            socket_cli = socket.accept();

            // Declaramos e instanciamos el objeto DataInputStream
            // que nos valdrá para recibir datos del cliente

            in =new DataInputStream(socket_cli.getInputStream());

            // Creamos un bucle do while en el que recogemos el mensaje
            // que nos ha enviado el cliente y después lo mostramos
            // por consola
            
            String mensaje;
            do{

                mensaje = in.readUTF();

                if(mensaje.equals("1"))
                    recivedMessage();
                else if(mensaje.equals("2"))
                    recivedFile();
                else 
                    break;

            }while(true);

            in.close();
            socket_cli.close();
            socket.close();
        }
        // utilizamos el catch para capturar los errores que puedan surgir
        catch (Exception e) {

            // si existen errores los mostrará en la consola y después saldrá del
            // programa
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private void recivedMessage() throws Exception{
        String mensaje = "";
        do{
            mensaje = in.readUTF();
            System.out.println(mensaje);
        }while(true);
    }

    private void recivedFile() throws Exception{

        System.out.println("Recibiendo archivo\n");

        // Atributos del archivo
        int size;
        int byteRead;
        String nameFile;
        String currentDirectory;

        // Variables para calcular los tiempos de transferencia, latencia, 
        // transmision, restante y transcurrido.
        long latency;
        long remainingTime;
        long transferSpeed;
        long estimatedTime;
        int totalBytes = 0;

        size = in.readInt();
        nameFile = in.readUTF();
        currentDirectory = System.getProperty("user.dir");
                
        byte[] buffer = new byte[size];
        FileOutputStream file = new FileOutputStream(currentDirectory+"/"+nameFile);

        long startTime = System.currentTimeMillis();

        while( totalBytes!=size ){
            byteRead = in.read(buffer);
            file.write(buffer, 0, byteRead);
            totalBytes+=byteRead;

            System.out.println( "Recibido: "+ totalBytes );

            // Calcula el tiempo transcurrido
            latency = calculateLatency(startTime, System.currentTimeMillis());
            // Calcula la veolcidad de transferencia
            transferSpeed = division(totalBytes*8, latency);
            // Calcula el tiempo restante
            estimatedTime = calculateTransferRate(size-totalBytes, transferSpeed);
            remainingTime = calculateLatency(latency,estimatedTime);
            
            // Imprimimos el resultado
            System.out.println( "Tasa de transferencia: "+ transferSpeed +" bps");
            System.out.println( "Tiempo transcurrido: "+ latency +" ms");
            System.out.println( "Tiempo restante estimado: "+remainingTime+ " ms\n");
        }

        System.out.println("*********************Archivo recibido**************************\n\n");

        file.close();
    }

    private long calculateLatency(long startTime, long endTime){
        long totalTime = endTime-startTime;
        return ( totalTime >0)? totalTime:0; 
    }

    private long calculateTransferRate(long totalBytes, long size){
        return  division(totalBytes*1000, size);
    }

    private long division(long num1, long num2){
        long result;
        if(num1!=0 && num2!=0){
            result = (num1/num2);
        }else{
            result = 0;
        }
        return result;
    }
}
