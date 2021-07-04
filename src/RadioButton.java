import javax.swing.*;
import java.awt.*;

public class RadioButton extends JRadioButton {
    public RadioButton(int x,int y,int width,int height,String text) {
        this.setBounds(x,y,width,height);
        this.setText(text);
        this.setOpaque(false);
        this.setForeground(Color.WHITE);
    }
}
