import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AppFrame extends JFrame implements ActionListener {
    Background background;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9;
    TextField text1,text2,text3,text4;
    public AppFrame() throws HeadlessException {
        this.setTitle("Kambed clicker v1.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(400,260);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("pictures/AppIcon.png")));
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.lightGray);

        background = new Background();

        button1 = new Button(292,20,80,30,"Default");
        button1.addActionListener(e -> text1.setText("80"));
        button2 = new Button(292,50,80,30,"Default");
        button2.addActionListener(e -> text2.setText("12.5"));
        button7 = new Button(292,100,80,30,"Default");
        button7.addActionListener(e -> text3.setText("40"));
        button8 = new Button(292,130,80,30,"Default");
        button8.addActionListener(e -> text4.setText("25"));
        button3 = new Button(0,0,125,55,"Test3");
        //button3.addActionListener(e -> JOptionPane.showMessageDialog(background,"XD","Error",1));
        button4 = new Button(0,55,125,55,"Test4");
        //button4.addActionListener(e -> JOptionPane.showMessageDialog(background,"XD","Error",1));
        button5 = new Button(0,110,125,55,"Settings");
        button5.addActionListener(this);
        button6 = new Button(0,165,125,55,"About");
        button6.addActionListener(e -> JOptionPane.showMessageDialog(background,"Auto clicker v2.0 \nAuthor: Kamil 'kambed' Bednarek","About",1));
        button9 = new Button(0,0,125,55,"<- Back");
        button9.setVisible(false);
        button9.addActionListener(this);
        text1 = new TextField(130,20,150,30);
        text1.setText("80");
        text2 = new TextField(130,50,150,30);
        text2.setText("12.5");
        text3 = new TextField(130,100,150,30);
        text3.setText("40");
        text4 = new TextField(130,130,150,30);
        text4.setText("25");
        text1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                text2.setText(text1.ConvertMsToCPS(text1.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text2.setText(text1.ConvertMsToCPS(text1.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text2.setText(text1.ConvertMsToCPS(text1.getText()));
            }
        });
        text3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                text4.setText(text3.ConvertMsToCPS(text3.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text4.setText(text3.ConvertMsToCPS(text3.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text4.setText(text3.ConvertMsToCPS(text3.getText()));
            }
        });

        this.add(text1);
        this.add(text2);
        this.add(text3);
        this.add(text4);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(button9);
        this.add(background);

        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button5){
            text1.setVisible(false);
            text2.setVisible(false);
            text3.setVisible(false);
            text4.setVisible(false);
            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button5.setVisible(false);
            button6.setVisible(false);
            button7.setVisible(false);
            button8.setVisible(false);

            button9.setVisible(true);
        }
        if(e.getSource()==button9){
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(true);
            text4.setVisible(true);
            button1.setVisible(true);
            button2.setVisible(true);
            button3.setVisible(true);
            button4.setVisible(true);
            button5.setVisible(true);
            button6.setVisible(true);
            button7.setVisible(true);
            button8.setVisible(true);

            button9.setVisible(false);
        }
    }
}
