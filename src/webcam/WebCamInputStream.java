package webcam;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.*;

public class WebCamInputStream extends Thread{

    private DatagramSocket socket;
    private DatagramPacket packet;

    private final String SERVER;
    private final int SERVER_PORT;

    private InetAddress address;

    public WebCamInputStream(DatagramSocket socket, String server, int port){
        this.socket = socket;
        SERVER = server;
        SERVER_PORT = port;
    }

    public void run(){

        // Obtener la instancia de la webcam predeterminada
        Webcam webcam = Webcam.getDefault();
        // Configurar la resolución del video
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        try{
            address = InetAddress.getByName(SERVER);

            byte[] frameByte;
            BufferedImage image;
            ByteArrayOutputStream baos;

            Frame frame = new Frame();

            // Iniciar la captura de video
            webcam.open();
            
            do{
                image = webcam.getImage();

                if(image == null){
                    sendPacket("".getBytes());
                    break;
                }

                baos = new ByteArrayOutputStream();

                ImageIO.write(image, "JPEG", baos);
                frameByte = baos.toByteArray();

                sendPacket(frameByte);

                frame.showFrame(image);
            }while(true);
            webcam.close();
            socket.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }

    public void sendPacket(byte[] frameByte)throws Exception{
        packet = new DatagramPacket(frameByte,frameByte.length,address,SERVER_PORT);

        socket.send(packet);
    }
}

