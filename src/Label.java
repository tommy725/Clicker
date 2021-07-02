import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label() {
        //this.setIcon(new ImageIcon("src/Background.jpg"));
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Background.jpg")));
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}