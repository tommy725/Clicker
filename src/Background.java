import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Background extends JLabel {
    public Background() {
        this.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Background.jpg"))));
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}