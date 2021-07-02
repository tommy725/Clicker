import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    public AppFrame() throws HeadlessException {
        this.setTitle("Clicker by Kambed");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(400,400);

        ImageIcon image = new ImageIcon("src/AppIcon.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.lightGray);
    }
}
