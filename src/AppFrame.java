import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    public AppFrame() throws HeadlessException {
        this.setTitle("Kambed clicker v1.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(800,480);
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("AppIcon.png"));
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.lightGray);
        this.add(new Label());
        revalidate();
    }
}
