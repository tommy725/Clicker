import javax.swing.*;
import java.awt.*;

public class ComboBox extends JComboBox {
    public ComboBox(int x,int y,int width,int height) {
        this.setBounds(x,y,width,height);
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(100,100,100));
        this.setFocusable(false);
        String[] keysChose={"","F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12","MouseButton3","MouseButton4","MouseButton5","MouseButton6"};
        for (String s : keysChose) {
            this.addItem(s);
        }
    }
}
