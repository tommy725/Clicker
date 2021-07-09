import javax.swing.*;
import java.awt.*;

public class Slider extends JSlider {
    public Slider(int x,int y,int width,int height) {
        this.setBounds(x,y,width,height);
        this.setMinorTickSpacing(10);
        this.setMajorTickSpacing(20);
        this.setPaintTicks(true);
        this.setPaintLabels(true);
        this.setPaintTrack(true);
        this.setOpaque(false);
        this.setForeground(Color.WHITE);
    }

}
