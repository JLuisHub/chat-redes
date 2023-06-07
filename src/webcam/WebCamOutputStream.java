package webcam;

import java.io.*;
import java.net.*;
import java.awt.image.BufferedImage;

import javax.imageio.*;

public class WebCamOutputStream extends Thread{

    private DatagramSocket socket;
    private DatagramPacket packet;

    private final int SERVER_PORT;

    private int MAX_BUFFER = 40000;

    public WebCamOutputStream(int port)throws Exception{
        SERVER_PORT = port;

        socket = new DatagramSocket(port);
    }

    public void run(){

        try{

            int frameSize;
            byte[] frameByte;
            byte[] imageBytes = new byte[MAX_BUFFER];

            BufferedImage image;

            Frame frame = new Frame();
            do{

                packet = new DatagramPacket(imageBytes, imageBytes.length);
                socket.receive(packet);

                frameByte = packet.getData();
                frameSize = packet.getLength();

                image = ImageIO.read( new ByteArrayInputStream(frameByte,0,frameSize) );

                frame.showFrame(image);
            }while(frameSize != 0);
            frame.close();

        }catch(Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }
    
}
