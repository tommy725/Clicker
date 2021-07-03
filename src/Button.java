import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button() {
        this.setBackground(new Color(0x404040));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setText("Test");
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
    }
}
