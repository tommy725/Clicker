import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(int x,int y,int width,int height,String text) {
        this.setFont(new Font("Segoe",Font.PLAIN,18));
        this.setForeground(Color.WHITE);
        this.setBounds(x,y,width,height);
        this.setText(text);
    }
}
