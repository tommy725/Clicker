import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AppFrame extends JFrame implements ActionListener {
    Background background;
    Button buttonDefaultMsLeft, buttonDefaultCpsLeft, buttonExit, buttonSettings, buttonAbout, buttonDefaultMsRight, buttonDefaultCpsRight,buttonBackFromSettings;
    TextField textMsLeft, textCpsLeft, textMsRight, textCpsRight;
    Label labelLeftClick,labelRightClick,labelMsLeftClick,labelCpsLeftClick,labelMsRightClick,labelCpsRightClick;
    CheckBox rightOnOff,leftOnOff;
    public AppFrame() throws HeadlessException {
        //Frame settings
        this.setTitle("Kambed clicker v2.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(400,260);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("pictures/AppIcon.png")));
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.lightGray);
        //this.setBounds(100,100,400,260);
        //=======================================================
        //Elements settings
        background = new Background();
        //Buttons settings
        buttonDefaultMsLeft = new Button(292,20,80,30,"Default");
        buttonDefaultMsLeft.addActionListener(e -> textMsLeft.setText("80"));
        buttonDefaultCpsLeft = new Button(292,50,80,30,"Default");
        buttonDefaultCpsLeft.addActionListener(e -> textCpsLeft.setText("12.5"));
        buttonDefaultMsRight = new Button(292,130,80,30,"Default");
        buttonDefaultMsRight.addActionListener(e -> textMsRight.setText("40"));
        buttonDefaultCpsRight = new Button(292,160,80,30,"Default");
        buttonDefaultCpsRight.addActionListener(e -> textCpsRight.setText("25.0"));
        buttonExit = new Button(0,0,125,55,"\uD83E\uDC14 Exit");
        buttonExit.addActionListener(e -> this.dispose());
        buttonSettings = new Button(0,110,125,55,"Settings");
        buttonSettings.addActionListener(this);
        buttonAbout = new Button(0,165,125,55,"About");
        buttonAbout.addActionListener(e -> JOptionPane.showMessageDialog(background,"Auto clicker v2.0 \nAuthor: Kamil 'kambed' Bednarek","About",1));
        buttonBackFromSettings = new Button(0,0,125,55,"\uD83E\uDC14 Back");
        buttonBackFromSettings.setVisible(false);
        buttonBackFromSettings.addActionListener(this);
        //=======================================================
        //Labels settings
        labelLeftClick = new Label(160,2,190,20,"Left click");
        labelRightClick = new Label(154,110,190,20,"Right click");
        labelMsLeftClick = new Label(257,25,40,20,"ms");
        labelCpsLeftClick = new Label(257,55,40,20,"cps");
        labelMsRightClick = new Label(257,135,40,20,"ms");
        labelCpsRightClick = new Label(257,165,40,20,"cps");
        //=======================================================
        //Checkboxes settings
        leftOnOff = new CheckBox(135,80,120,20,"Disabled");
        leftOnOff.addActionListener(this);
        rightOnOff = new CheckBox(135,190,120,20,"Disabled");
        rightOnOff.addActionListener(this);
        //=======================================================
        //Textfields settings
        textMsLeft = new TextField(135,20,120,30);
        textMsLeft.setText("80");
        textCpsLeft = new TextField(135,50,120,30);
        textCpsLeft.setText("12.5");
        textMsRight = new TextField(135,130,120,30);
        textMsRight.setText("40");
        textCpsRight = new TextField(135,160,120,30);
        textCpsRight.setText("25.0");

        textMsLeft.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textCpsLeft.setText(textMsLeft.ConvertMsToCPS(textMsLeft.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textCpsLeft.setText(textMsLeft.ConvertMsToCPS(textMsLeft.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                textCpsLeft.setText(textMsLeft.ConvertMsToCPS(textMsLeft.getText()));
            }
        });
        textMsRight.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textCpsRight.setText(textMsRight.ConvertMsToCPS(textMsRight.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textCpsRight.setText(textMsRight.ConvertMsToCPS(textMsRight.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                textCpsRight.setText(textMsRight.ConvertMsToCPS(textMsRight.getText()));
            }
        });
        //=======================================================
        //Adding all things to frame
        this.add(textMsLeft);
        this.add(textCpsLeft);
        this.add(textMsRight);
        this.add(textCpsRight);
        this.add(buttonDefaultMsLeft);
        this.add(buttonDefaultCpsLeft);
        this.add(buttonExit);
        this.add(buttonSettings);
        this.add(buttonAbout);
        this.add(buttonDefaultMsRight);
        this.add(buttonDefaultCpsRight);
        this.add(buttonBackFromSettings);
        this.add(leftOnOff);
        this.add(rightOnOff);
        this.add(labelLeftClick);
        this.add(labelRightClick);
        this.add(labelMsLeftClick);
        this.add(labelCpsLeftClick);
        this.add(labelMsRightClick);
        this.add(labelCpsRightClick);
        this.add(background);
        //=======================================================
        //Repaint elements to be visible
        this.revalidate();
        this.repaint();
        //=======================================================
    }
    //Change visibility of elements
    public void SettingMainChanger(boolean mainWindowState) {
        textMsLeft.setVisible(mainWindowState);
        textCpsLeft.setVisible(mainWindowState);
        textMsRight.setVisible(mainWindowState);
        textCpsRight.setVisible(mainWindowState);
        buttonDefaultMsLeft.setVisible(mainWindowState);
        buttonDefaultCpsLeft.setVisible(mainWindowState);
        buttonExit.setVisible(mainWindowState);
        buttonSettings.setVisible(mainWindowState);
        buttonAbout.setVisible(mainWindowState);
        buttonDefaultMsRight.setVisible(mainWindowState);
        buttonDefaultCpsRight.setVisible(mainWindowState);
        labelLeftClick.setVisible(mainWindowState);
        labelRightClick.setVisible(mainWindowState);
        labelCpsLeftClick.setVisible(mainWindowState);
        labelCpsRightClick.setVisible(mainWindowState);
        labelMsLeftClick.setVisible(mainWindowState);
        labelMsRightClick.setVisible(mainWindowState);
        leftOnOff.setVisible(mainWindowState);
        rightOnOff.setVisible(mainWindowState);

        buttonBackFromSettings.setVisible(!mainWindowState);
    }
    //Action listeners
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==leftOnOff){
            leftOnOff.changeState();
        }
        if(e.getSource()==rightOnOff){
            rightOnOff.changeState();
        }
        if(e.getSource()== buttonSettings){
            SettingMainChanger(false);
        }
        if(e.getSource()==buttonBackFromSettings){
            SettingMainChanger(true);
        }
        //=======================================================
    }
}
