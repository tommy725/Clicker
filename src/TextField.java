import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField {
    public TextField(int x, int y, int width, int height) {
        this.setBounds(x,y,width,height);
        this.setFont(new Font("Segoe",Font.BOLD,18));
        this.setBackground(new Color(100,100,100));
        this.setForeground(Color.WHITE);
    }

    public String ConvertMsToCPS(String valstr){
        String str;
        try{
            double val = Double.parseDouble(valstr);
            val = (1000/val)*100;
            int cut = (int)val;
            str = String.valueOf(cut/100.0);
        }catch(Exception ex){
            return "Invalid input";
        }
        return str;
    }
}
