import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Clicker by Kambed");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(400,400);

        ImageIcon image = new ImageIcon("src/AppIcon.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.lightGray);
    }
}

