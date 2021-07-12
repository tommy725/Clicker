import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Button extends JButton {
    public Button(int x,int y,int width,int height,String text) {
        this.setBounds(x,y,width,height);
        this.setOpaque(false);
        this.setBackground(new Color(100,100,100));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setText(text);
        this.setFont(new Font("Segoe",Font.PLAIN,18));
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(buttonReference().isEnabled()){
                    buttonReference().setHorizontalAlignment(JButton.RIGHT);
                    buttonReference().setFont(new Font("Segoe",Font.BOLD,18));
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonReference().setHorizontalAlignment(JButton.CENTER);
                buttonReference().setFont(new Font("Segoe",Font.PLAIN,18));
            }});
    }

    private Button buttonReference() {
        return this;
    }
}
