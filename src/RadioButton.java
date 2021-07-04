import javax.swing.*;
import java.awt.*;

public class RadioButton extends JRadioButton {
    public RadioButton(int x,int y,int width,int height,String text) {
        this.setBounds(x,y,width,height);
        this.setText(text);
        this.setOpaque(false);
        this.setFont(new Font("Segoe",Font.PLAIN,16));
        this.setForeground(Color.WHITE);
    }
}
