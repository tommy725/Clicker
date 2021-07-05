import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.WindowEvent;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppFrame extends JFrame implements ActionListener, NativeKeyListener, NativeMouseListener {
    boolean mainWindow;
    Background background;
    Button buttonDefaultMsLeft, buttonDefaultCpsLeft, buttonExit, buttonSettings, buttonAbout, buttonDefaultMsRight, buttonDefaultCpsRight,buttonBackFromSettings;
    TextField textMsLeft, textCpsLeft, textMsRight, textCpsRight,textRandomizer;
    Label labelLeftClick,labelRightClick,labelMsLeftClick,labelCpsLeftClick,labelMsRightClick,labelCpsRightClick,labelMsCpsSwitch,labelModeSwitch,labelRandomizer,labelPercent;
    CheckBox rightOnOff,leftOnOff,randomizer;
    RadioButton msInput,cpsInput,holdMode,switchMode;
    public AppFrame() throws HeadlessException {
//        try {
//            Click bot = new Click();
//            for(int i=0;i<10;i++){
//                bot.leftClick(1000);
//            }
//        } catch (AWTException | InterruptedException e) {
//            e.printStackTrace();
//        }
        //Frame settings
        this.setTitle("Kambed clicker v2.0");
        this.setBounds(100,100,400,260);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(400,260);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("pictures/AppIcon.png")));
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.lightGray);
        //=======================================================
        //Elements settings
        background = new Background();
        //Buttons settings
        buttonDefaultMsLeft = new Button(292,20,80,30,"Default");
        buttonDefaultMsLeft.addActionListener(e -> textMsLeft.setText("80.0"));
        buttonDefaultCpsLeft = new Button(292,50,80,30,"Default");
        buttonDefaultCpsLeft.setEnabled(false);
        buttonDefaultCpsLeft.addActionListener(e -> textCpsLeft.setText("12.5"));
        buttonDefaultMsRight = new Button(292,130,80,30,"Default");
        buttonDefaultMsRight.addActionListener(e -> textMsRight.setText("40.0"));
        buttonDefaultCpsRight = new Button(292,160,80,30,"Default");
        buttonDefaultCpsRight.setEnabled(false);
        buttonDefaultCpsRight.addActionListener(e -> textCpsRight.setText("25.0"));
        buttonExit = new Button(0,0,125,55,"\uD83E\uDC14 Exit");
        buttonExit.addActionListener(e -> this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)));
        buttonSettings = new Button(0,110,125,55,"Settings");
        buttonSettings.addActionListener(this);
        buttonAbout = new Button(0,165,125,55,"About");
        buttonAbout.addActionListener(e -> JOptionPane.showMessageDialog(background,"Auto clicker v2.0 \nAuthor: Kamil 'kambed' Bednarek","About",JOptionPane.INFORMATION_MESSAGE));
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
        labelMsCpsSwitch = new Label(230,0,150,30,"Ms/Cps input");
        labelMsCpsSwitch.setVisible(false);
        labelModeSwitch = new Label(230,70,150,30,"Switch/Hold mode");
        labelModeSwitch.setVisible(false);
        labelRandomizer = new Label(230,140,150,30,"AntyDetection");
        labelRandomizer.setVisible(false);
        labelPercent = new Label(290,185,30,30,"%");
        labelPercent.setVisible(false);
        //=======================================================
        //Checkboxes settings
        leftOnOff = new CheckBox(135,80,120,20,"Disabled");
        leftOnOff.addActionListener(this);
        rightOnOff = new CheckBox(135,190,120,20,"Disabled");
        rightOnOff.addActionListener(this);
        randomizer = new CheckBox(240,160,150,30,"Ms randomized");
        randomizer.setVisible(false);
        randomizer.setForeground(Color.WHITE);
        //=======================================================
        //RadioButtons settings
        msInput = new RadioButton(250,20,120,30,"Ms");
        msInput.setVisible(false);
        msInput.setSelected(true);
        cpsInput = new RadioButton(250,40,120,30,"Cps");
        cpsInput.setVisible(false);
        ButtonGroup group = new ButtonGroup();
        group.add(msInput);
        group.add(cpsInput);
        cpsInput.addActionListener(this);
        msInput.addActionListener(this);

        holdMode = new RadioButton(250,110,120,30,"Hold");
        holdMode.setVisible(false);
        switchMode = new RadioButton(250,90,120,30,"Switch");
        switchMode.setVisible(false);
        switchMode.setSelected(true);
        ButtonGroup group2 = new ButtonGroup();
        group2.add(switchMode);
        group2.add(holdMode);
        switchMode.addActionListener(this);
        holdMode.addActionListener(this);
        //=======================================================
        //Textfields settings
        textMsLeft = new TextField(135,20,120,30);
        textMsLeft.setText("80.0");
        textCpsLeft = new TextField(135,50,120,30);
        textCpsLeft.setText("12.5");
        textMsRight = new TextField(135,130,120,30);
        textMsRight.setText("40.0");
        textCpsRight = new TextField(135,160,120,30);
        textCpsRight.setText("25.0");
        textCpsLeft.setEnabled(false);
        textCpsRight.setEnabled(false);
        textRandomizer = new TextField(250,185,40,30);
        textRandomizer.setVisible(false);
        textRandomizer.setText("5");

        textMsLeft.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(textMsLeft.isEnabled()) {
                    textCpsLeft.setText(textMsLeft.ConvertMsCPS(textMsLeft.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textMsLeft.isEnabled()) {
                    textCpsLeft.setText(textMsLeft.ConvertMsCPS(textMsLeft.getText()));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(textMsLeft.isEnabled()) {
                    textCpsLeft.setText(textMsLeft.ConvertMsCPS(textMsLeft.getText()));
                }
            }
        });
        textCpsLeft.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(textCpsLeft.isEnabled()){
                    textMsLeft.setText(textCpsLeft.ConvertMsCPS(textCpsLeft.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textCpsLeft.isEnabled()){
                    textMsLeft.setText(textCpsLeft.ConvertMsCPS(textCpsLeft.getText()));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(textCpsLeft.isEnabled()){
                    textMsLeft.setText(textCpsLeft.ConvertMsCPS(textCpsLeft.getText()));
                }
            }
        });
        textMsRight.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(textMsRight.isEnabled()) {
                    textCpsRight.setText(textMsRight.ConvertMsCPS(textMsRight.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textMsRight.isEnabled()) {
                    textCpsRight.setText(textMsRight.ConvertMsCPS(textMsRight.getText()));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(textMsRight.isEnabled()) {
                    textCpsRight.setText(textMsRight.ConvertMsCPS(textMsRight.getText()));
                }
            }
        });
        textCpsRight.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(textCpsRight.isEnabled()) {
                    textMsRight.setText(textCpsRight.ConvertMsCPS(textCpsRight.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textCpsRight.isEnabled()) {
                    textMsRight.setText(textCpsRight.ConvertMsCPS(textCpsRight.getText()));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(textCpsRight.isEnabled()) {
                    textMsRight.setText(textCpsRight.ConvertMsCPS(textCpsRight.getText()));
                }
            }
        });
        //=======================================================
        //NativeKeyListener
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(this);
        //NativeMouseListener
        GlobalScreen.addNativeMouseListener(this);
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
        this.add(cpsInput);
        this.add(msInput);
        this.add(labelLeftClick);
        this.add(labelRightClick);
        this.add(labelMsLeftClick);
        this.add(labelCpsLeftClick);
        this.add(labelMsRightClick);
        this.add(labelCpsRightClick);
        this.add(labelMsCpsSwitch);
        this.add(holdMode);
        this.add(switchMode);
        this.add(labelModeSwitch);
        this.add(labelRandomizer);
        this.add(randomizer);
        this.add(textRandomizer);
        this.add(labelPercent);
        this.add(background);
        //=======================================================
        //Repaint elements to be visible
        this.revalidate();
        this.repaint();
        //=======================================================
    }
    //Change visibility of elements
    public void SettingMainChanger(boolean mainWindowState) {
        mainWindow=mainWindowState;
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
        msInput.setVisible(!mainWindowState);
        cpsInput.setVisible(!mainWindowState);
        labelMsCpsSwitch.setVisible(!mainWindowState);
        holdMode.setVisible(!mainWindowState);
        switchMode.setVisible(!mainWindowState);
        labelModeSwitch.setVisible(!mainWindowState);
        labelRandomizer.setVisible(!mainWindowState);
        randomizer.setVisible(!mainWindowState);
        textRandomizer.setVisible(!mainWindowState);
        labelPercent.setVisible(!mainWindowState);
    }
    //Switch ms/cps
    public void MsCpsSwitcher(boolean ms){
        textCpsLeft.setEnabled(!ms);
        textCpsRight.setEnabled(!ms);
        buttonDefaultCpsLeft.setEnabled(!ms);
        buttonDefaultCpsRight.setEnabled(!ms);
        textMsLeft.setEnabled(ms);
        textMsRight.setEnabled(ms);
        buttonDefaultMsLeft.setEnabled(ms);
        buttonDefaultMsRight.setEnabled(ms);
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
        if(e.getSource()==msInput){
            MsCpsSwitcher(true);
        }
        if(e.getSource()==cpsInput){
            MsCpsSwitcher(false);
        }
        //=======================================================
    }
    //NativeKeyListener
    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        if(nativeKeyEvent.getKeyCode()==NativeKeyEvent.VC_F8)
        System.out.println("Typed "+nativeKeyEvent.getKeyChar());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        if(nativeKeyEvent.getKeyCode()==NativeKeyEvent.VC_F8)
        System.out.println("Pressed "+nativeKeyEvent.getKeyChar());

        if(nativeKeyEvent.getKeyCode()==NativeKeyEvent.VC_ESCAPE){
            if(mainWindow){
                int exit = JOptionPane.showConfirmDialog(background,"Next [ESC] will close the program","EXIT?",JOptionPane.YES_NO_OPTION);
                if(exit==0 || exit==-1){
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                }
            }else{
                SettingMainChanger(true);
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        if(nativeKeyEvent.getKeyCode()==NativeKeyEvent.VC_F8)
        System.out.println("Released "+nativeKeyEvent.getKeyChar());
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
        System.out.println("Clicked "+nativeMouseEvent.getButton());
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
        System.out.println("Pressed "+nativeMouseEvent.getButton());
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        System.out.println("Released "+nativeMouseEvent.getButton());
    }
}
