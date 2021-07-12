import java.awt.*;
import java.awt.event.InputEvent;

public class ClickRight extends Robot implements Runnable{
    CheckBox right;
    TextField rightms;
    public ClickRight(CheckBox right,TextField rightms) throws AWTException {
        this.right=right;
        this.rightms=rightms;
    }

    public void rightClick(int ms) {
        //System.out.println("Right click press");
        this.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        try {
            Thread.sleep((long) (ms/2.11));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Right click release");
        this.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        try {
            Thread.sleep((long) (ms/2.11));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(0,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(right.isSelected()){
                rightClick((int)Double.parseDouble(rightms.getText()));
            }
        }
    }
}
