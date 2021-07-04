import javax.swing.*;
import java.awt.*;

public class CheckBox extends JCheckBox {
    public CheckBox(int x,int y,int width,int height,String text) {
        this.setText(text);
        this.setBounds(x,y,width,height);
        this.setFont(new Font("Segoe",Font.PLAIN,18));
        this.setForeground(Color.RED);
        this.setBackground(new Color(100,100,100));
        this.setFocusable(false);
    }
    public void changeState(){
        if(this.isSelected()){
            this.setText("Enabled");
            this.setForeground(Color.GREEN);
        }
        else{
            this.setText("Disabled");
            this.setForeground(Color.RED);
        }
    }
}
