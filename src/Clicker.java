import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clicker implements NativeMouseListener,NativeKeyListener {
    Map<Integer,Integer> keysMap;
    AppFrame frame;
    public Clicker() {
        //GUI turn on
        frame = new AppFrame();
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
        //HashMap for keyCodes
        keysMap=new HashMap<>();
        keysMap.put(1,NativeKeyEvent.VC_F1);
        keysMap.put(2,NativeKeyEvent.VC_F2);
        keysMap.put(3,NativeKeyEvent.VC_F3);
        keysMap.put(4,NativeKeyEvent.VC_F4);
        keysMap.put(5,NativeKeyEvent.VC_F5);
        keysMap.put(6,NativeKeyEvent.VC_F6);
        keysMap.put(7,NativeKeyEvent.VC_F7);
        keysMap.put(8,NativeKeyEvent.VC_F8);
        keysMap.put(9,NativeKeyEvent.VC_F9);
        keysMap.put(10,NativeKeyEvent.VC_F10);
        keysMap.put(11,NativeKeyEvent.VC_F11);
        keysMap.put(12,NativeKeyEvent.VC_F12);
        keysMap.put(13,NativeMouseEvent.BUTTON3);
        keysMap.put(14,NativeMouseEvent.BUTTON4);
        keysMap.put(15,NativeMouseEvent.BUTTON5);
        //=======================================================
    }
    //NativeKeyListener
    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        if(nativeKeyEvent.getKeyCode()==keysMap.get(frame.comboboxRC.getSelectedIndex())){
            System.out.println("Pressed R"+nativeKeyEvent.getKeyChar());
        }
        if(nativeKeyEvent.getKeyCode()==keysMap.get(frame.comboboxLC.getSelectedIndex())){
            System.out.println("Pressed L"+nativeKeyEvent.getKeyChar());
        }

        if(nativeKeyEvent.getKeyCode()==NativeKeyEvent.VC_ESCAPE){
            if(frame.mainWindow){
                int exit = JOptionPane.showConfirmDialog(frame.background,"Next [ESC] will close the program","EXIT?",JOptionPane.YES_NO_OPTION);
                if(exit==0 || exit==-1){
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }else{
                frame.SettingMainChanger(true);
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        if(nativeKeyEvent.getKeyCode()==keysMap.get(frame.comboboxRC.getSelectedIndex())){
            System.out.println("Released R "+nativeKeyEvent.getKeyChar());
        }
        if(nativeKeyEvent.getKeyCode()==keysMap.get(frame.comboboxLC.getSelectedIndex())){
            System.out.println("Released L "+nativeKeyEvent.getKeyChar());
        }
    }
    //=======================================================
    //NativeMouseListener
    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {

    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
        if(nativeMouseEvent.getButton()==keysMap.get(frame.comboboxRC.getSelectedIndex())){
            System.out.println("Pressed R"+nativeMouseEvent.getButton());
        }
        if(nativeMouseEvent.getButton()==keysMap.get(frame.comboboxLC.getSelectedIndex())){
            System.out.println("Pressed L"+nativeMouseEvent.getButton());
        }
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        if(nativeMouseEvent.getButton()==keysMap.get(frame.comboboxRC.getSelectedIndex())){
            System.out.println("Released R"+nativeMouseEvent.getButton());
        }
        if(nativeMouseEvent.getButton()==keysMap.get(frame.comboboxLC.getSelectedIndex())){
            System.out.println("Pressed L"+nativeMouseEvent.getButton());
        }
    }
    //=======================================================
}
