import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class AppFrame extends JFrame {

    public AppFrame() throws HeadlessException {
        this.setTitle("Kambed clicker v1.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setVisible(true);
        this.setSize(800,480);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("AppIcon.png")));
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.lightGray);

        Background background = new Background();
        Button button1 = new Button();
        button1.setBounds(650,80,80,30);
        button1.addActionListener(e -> JOptionPane.showMessageDialog(background,"XD","Error",1));
        Button button2 = new Button();
        button2.setBounds(650,120,80,30);
        button2.addActionListener(e -> JOptionPane.showMessageDialog(background,"XD2","Error2",1));

        this.add(button1);
        this.add(button2);
        this.add(background);
        this.revalidate();
        this.repaint();
    }
}
