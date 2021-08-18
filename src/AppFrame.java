import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.*;

public class AppFrame extends JFrame implements ActionListener, ChangeListener {
    boolean mainWindow;
    Background background;
    Button buttonDefaultLeft, buttonExit, buttonSettings, buttonAbout, buttonDefaultRight,buttonBackFromSettings;
    TextField textMsLeft, textCpsLeft, textMsRight, textCpsRight;
    Label labelLeftClick,labelRightClick,labelMsLeftClick,labelCpsLeftClick,labelMsRightClick,labelCpsRightClick,labelMsCpsSwitch,labelModeSwitch,labelRandomizer,labelPercent,labelRightHotkey,labelLeftHotkey,labelValueRandomizer;
    CheckBox rightOnOff,leftOnOff,randomizer,saver;
    RadioButton msInput,cpsInput,holdMode,switchMode;
    ComboBox comboboxLC,comboboxRC;
    Slider sliderRandom;
    Settings settings;
    TurboSaver save;
    Map<Integer,String> keysMap;
    public AppFrame(Settings settings) throws HeadlessException {
        //Frame settings
        save = new TurboSaver();
        this.settings = settings;
        this.setTitle("Kambed clicker v2.0");
        this.setLocationRelativeTo(null);
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
        buttonDefaultLeft = new Button(292,30,80,40,"Default");
        buttonDefaultLeft.addActionListener(this);
        buttonDefaultRight = new Button(292,140,80,40,"Default");
        buttonDefaultRight.addActionListener(this);
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
        labelMsCpsSwitch = new Label(210,0,150,30,"Ms/Cps input");
        labelMsCpsSwitch.setVisible(false);
        labelModeSwitch = new Label(210,60,150,30,"Switch/Hold mode");
        labelModeSwitch.setVisible(false);
        labelRandomizer = new Label(210,120,150,30,"AntiDetection");
        labelRandomizer.setVisible(false);
        labelPercent = new Label(356,192,30,30,"%");
        labelPercent.setVisible(false);
        labelRightHotkey = new Label(20,148,150,30,"Right click hotkey");
        labelRightHotkey.setVisible(false);
        labelLeftHotkey = new Label(20,78,150,30,"Left click hotkey");
        labelLeftHotkey.setVisible(false);
        //=======================================================
        //Checkboxes settings
        leftOnOff = new CheckBox(135,80,120,20,"Disabled");
        leftOnOff.addActionListener(this);
        rightOnOff = new CheckBox(135,190,120,20,"Disabled");
        rightOnOff.addActionListener(this);

        randomizer = new CheckBox(230,145,150,30,"Ms randomized");
        randomizer.setVisible(false);
        randomizer.setForeground(Color.WHITE);
        randomizer.setSelected(settings.isMsRandomizer());
        randomizer.addActionListener(this);
        saver = new CheckBox(15,52,250,30,"Save settings");
        saver.setForeground(Color.WHITE);
        saver.setSelected(settings.isSave());
        saver.addActionListener(this);
        saver.setVisible(false);
        //=======================================================
        //RadioButtons settings
        msInput = new RadioButton(230,20,120,30,"Ms");
        msInput.setVisible(false);
        msInput.setSelected(!settings.isInputInCPS());
        cpsInput = new RadioButton(230,40,120,30,"Cps");
        cpsInput.setVisible(false);
        cpsInput.setSelected(settings.isInputInCPS());
        ButtonGroup group = new ButtonGroup();
        group.add(msInput);
        group.add(cpsInput);
        cpsInput.addActionListener(this);
        msInput.addActionListener(this);

        holdMode = new RadioButton(230,100,120,30,"Hold");
        holdMode.setVisible(false);
        holdMode.setSelected(settings.isHoldMode());
        switchMode = new RadioButton(230,80,120,30,"Switch");
        switchMode.setVisible(false);
        switchMode.setSelected(!settings.isHoldMode());
        ButtonGroup group2 = new ButtonGroup();
        group2.add(switchMode);
        group2.add(holdMode);
        switchMode.addActionListener(this);
        holdMode.addActionListener(this);
        //=======================================================
        //Combobox settings
        keysMap=new HashMap<>();
        keysMap.put(1,"F1");
        keysMap.put(2,"F2");
        keysMap.put(3,"F3");
        keysMap.put(4,"F4");
        keysMap.put(5,"F5");
        keysMap.put(6,"F6");
        keysMap.put(7,"F7");
        keysMap.put(8,"F8");
        keysMap.put(9,"F9");
        keysMap.put(10,"F10");
        keysMap.put(11,"F11");
        keysMap.put(12,"F12");
        keysMap.put(13,"MouseButton4");
        keysMap.put(14,"MouseButton5");

        comboboxLC = new ComboBox(25,105,110,30);
        comboboxLC.addActionListener(this);
        comboboxLC.setVisible(false);
        comboboxLC.setSelectedItem(settings.getLeftHotkey());

        comboboxRC = new ComboBox(25,175,110,30);
        comboboxRC.addActionListener(this);
        comboboxRC.setVisible(false);
        comboboxRC.setSelectedItem(settings.getRightHotkey());
        //=======================================================
        //Slider settings
        sliderRandom = new Slider(235,170,120,50);
        sliderRandom.setVisible(false);
        sliderRandom.addChangeListener(this);
        labelValueRandomizer = new Label(190,165,50,30,String.valueOf(sliderRandom.getValue()));
        labelValueRandomizer.setVisible(false);
        labelValueRandomizer.setHorizontalAlignment(SwingConstants.RIGHT);
        sliderRandom.setValue(settings.getRandomPercent());
        //=======================================================
        //TextField settings
        textMsLeft = new TextField(135,20,120,30);
        textMsLeft.setText(String.valueOf(settings.getLeftMs()));
        textCpsLeft = new TextField(135,50,120,30);
        textCpsLeft.setText(textCpsLeft.ConvertMsCPS(textMsLeft.getText()));
        textMsRight = new TextField(135,130,120,30);
        textMsRight.setText(String.valueOf(settings.getRightMs()));
        textCpsRight = new TextField(135,160,120,30);
        textCpsRight.setText(textCpsRight.ConvertMsCPS(textMsRight.getText()));
        textCpsLeft.setEnabled(false);
        textCpsRight.setEnabled(false);

        textMsLeft.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(textMsLeft.isEnabled()) {
                    try {
                        settings.setLeftMs(Double.parseDouble(textMsLeft.getText()));
                    }catch(Exception ex){
                        settings.setLeftMs(80.0);
                    }
                    textCpsLeft.setText(textMsLeft.ConvertMsCPS(textMsLeft.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textMsLeft.isEnabled()) {
                    try {
                        settings.setLeftMs(Double.parseDouble(textMsLeft.getText()));
                    }catch(Exception ex){
                        settings.setLeftMs(80.0);
                    }
                    textCpsLeft.setText(textMsLeft.ConvertMsCPS(textMsLeft.getText()));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(textMsLeft.isEnabled()) {
                    try {
                        settings.setLeftMs(Double.parseDouble(textMsLeft.getText()));
                    }catch(Exception ex){
                        settings.setLeftMs(80.0);
                    }
                    textCpsLeft.setText(textMsLeft.ConvertMsCPS(textMsLeft.getText()));
                }
            }
        });
        textCpsLeft.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(textCpsLeft.isEnabled()){
                    textMsLeft.setText(textCpsLeft.ConvertMsCPS(textCpsLeft.getText()));
                    try {
                        settings.setLeftMs(Double.parseDouble(textMsLeft.getText()));
                    }catch(Exception ex){
                        settings.setLeftMs(80.0);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textCpsLeft.isEnabled()){
                    textMsLeft.setText(textCpsLeft.ConvertMsCPS(textCpsLeft.getText()));
                    try {
                        settings.setLeftMs(Double.parseDouble(textMsLeft.getText()));
                    }catch(Exception ex){
                        settings.setLeftMs(80.0);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(textCpsLeft.isEnabled()){
                    textMsLeft.setText(textCpsLeft.ConvertMsCPS(textCpsLeft.getText()));
                    try {
                        settings.setLeftMs(Double.parseDouble(textMsLeft.getText()));
                    }catch(Exception ex){
                        settings.setLeftMs(80.0);
                    }
                }
            }
        });
        textMsRight.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(textMsRight.isEnabled()) {
                    try {
                        settings.setRightMs(Double.parseDouble(textMsRight.getText()));
                    }catch(Exception ex){
                        settings.setRightMs(40.0);
                    }
                    textCpsRight.setText(textMsRight.ConvertMsCPS(textMsRight.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textMsRight.isEnabled()) {
                    try {
                        settings.setRightMs(Double.parseDouble(textMsRight.getText()));
                    }catch(Exception ex){
                        settings.setRightMs(40.0);
                    }
                    textCpsRight.setText(textMsRight.ConvertMsCPS(textMsRight.getText()));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(textMsRight.isEnabled()) {
                    try {
                        settings.setRightMs(Double.parseDouble(textMsRight.getText()));
                    }catch(Exception ex){
                        settings.setRightMs(40.0);
                    }
                    textCpsRight.setText(textMsRight.ConvertMsCPS(textMsRight.getText()));
                }
            }
        });
        textCpsRight.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(textCpsRight.isEnabled()) {
                    textMsRight.setText(textCpsRight.ConvertMsCPS(textCpsRight.getText()));
                    try {
                        settings.setRightMs(Double.parseDouble(textMsRight.getText()));
                    }catch(Exception ex){
                        settings.setRightMs(40.0);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(textCpsRight.isEnabled()) {
                    textMsRight.setText(textCpsRight.ConvertMsCPS(textCpsRight.getText()));
                    try {
                        settings.setRightMs(Double.parseDouble(textMsRight.getText()));
                    }catch(Exception ex){
                        settings.setRightMs(40.0);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(textCpsRight.isEnabled()) {
                    textMsRight.setText(textCpsRight.ConvertMsCPS(textCpsRight.getText()));
                    try {
                        settings.setRightMs(Double.parseDouble(textMsRight.getText()));
                    }catch(Exception ex){
                        settings.setRightMs(40.0);
                    }
                }
            }
        });
        //=======================================================
        //CPS/MS textField enable
        MsCpsSwitcher(!settings.isInputInCPS());
        //=======================================================
        //Adding all things to frame
        this.add(textMsLeft);
        this.add(textCpsLeft);
        this.add(textMsRight);
        this.add(textCpsRight);
        this.add(buttonDefaultLeft);
        this.add(buttonExit);
        this.add(buttonSettings);
        this.add(buttonAbout);
        this.add(buttonDefaultRight);
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
        this.add(labelPercent);
        this.add(comboboxRC);
        this.add(comboboxLC);
        this.add(labelRightHotkey);
        this.add(labelLeftHotkey);
        this.add(saver);
        this.add(sliderRandom);
        this.add(labelValueRandomizer);
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
        buttonDefaultLeft.setVisible(mainWindowState);
        buttonExit.setVisible(mainWindowState);
        buttonSettings.setVisible(mainWindowState);
        buttonAbout.setVisible(mainWindowState);
        buttonDefaultRight.setVisible(mainWindowState);
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
        labelPercent.setVisible(!mainWindowState);
        comboboxRC.setVisible(!mainWindowState);
        comboboxLC.setVisible(!mainWindowState);
        labelRightHotkey.setVisible(!mainWindowState);
        labelLeftHotkey.setVisible(!mainWindowState);
        saver.setVisible(!mainWindowState);
        sliderRandom.setVisible(!mainWindowState);
        labelValueRandomizer.setVisible(!mainWindowState);
    }
    //Switch ms/cps
    public void MsCpsSwitcher(boolean ms){
        textCpsLeft.setEnabled(!ms);
        textCpsRight.setEnabled(!ms);
        textMsLeft.setEnabled(ms);
        textMsRight.setEnabled(ms);
    }
    //Change listeners
    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource()==sliderRandom){
            labelValueRandomizer.setText(String.valueOf(sliderRandom.getValue())+"%");
            settings.setRandomPercent(sliderRandom.getValue());
            if(sliderRandom.getValue()<60){
                labelValueRandomizer.setForeground(Color.WHITE);
            }else if(sliderRandom.getValue()<80){
                labelValueRandomizer.setForeground(Color.YELLOW);
            }else{
                labelValueRandomizer.setForeground(Color.RED);
            }
        }
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
        if(e.getSource()==buttonDefaultLeft){
            if(textMsLeft.isEnabled()){
                textMsLeft.setText("80.0");
            }else{
                textCpsLeft.setText("12.5");
            }
        }
        if(e.getSource()==buttonDefaultRight){
            if(textMsRight.isEnabled()){
                textMsRight.setText("40.0");
            }else{
                textCpsRight.setText("25.0");
            }
        }
        if(e.getSource()== buttonSettings){
            SettingMainChanger(false);
        }
        if(e.getSource()==buttonBackFromSettings){
            SettingMainChanger(true);
        }
        if(e.getSource()==msInput){
            settings.setInputInCPS(false);
            MsCpsSwitcher(true);
        }
        if(e.getSource()==cpsInput){
            settings.setInputInCPS(true);
            MsCpsSwitcher(false);
        }
        if(e.getSource()==holdMode){
            settings.setHoldMode(true);
        }
        if(e.getSource()==switchMode){
            settings.setHoldMode(false);
        }
        if(e.getSource()==randomizer){
            settings.setMsRandomizer(randomizer.isSelected());
        }
        if(e.getSource()==saver){
            settings.setSave(saver.isSelected());
        }
        if(e.getSource()==comboboxLC){
            if(comboboxRC!=null){
                if(comboboxLC.getSelectedItem()==comboboxRC.getSelectedItem() && comboboxLC.getSelectedIndex()!=0){
                    JOptionPane.showMessageDialog(background,"Hotkeys cannot be the same!","Error!",JOptionPane.ERROR_MESSAGE);
                    comboboxLC.setSelectedIndex(0);
                }else{
                    settings.setLeftHotkey(keysMap.get(comboboxLC.getSelectedIndex()));
                }
            }
        }
        if(e.getSource()==comboboxRC){
            if(comboboxLC!=null){
                if(comboboxRC.getSelectedItem()==comboboxLC.getSelectedItem() && comboboxRC.getSelectedIndex()!=0){
                    JOptionPane.showMessageDialog(background,"Hotkeys cannot be the same!","Error!",JOptionPane.ERROR_MESSAGE);
                    comboboxRC.setSelectedIndex(0);
                }else{
                    settings.setRightHotkey(keysMap.get(comboboxRC.getSelectedIndex()));
                }
            }
        }
        //=======================================================
    }

}
