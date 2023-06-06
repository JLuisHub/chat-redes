package webcam;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame {

    private JLabel label;
    private JFrame frame;

    public Frame(){
        frame = new JFrame();
        label = new JLabel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
    }


    public void showFrame(BufferedImage image){
        frame.setSize(image.getWidth(),image.getHeight());
        label.setIcon(new ImageIcon(image));
        frame.repaint();
    }
    
}
