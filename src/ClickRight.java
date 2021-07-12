import java.awt.*;
import java.awt.event.InputEvent;

public class ClickRight extends Robot implements Runnable{
    CheckBox right;
    TextField rightms;
    MsRandomizer msValue;
    public ClickRight(CheckBox right,TextField rightms,MsRandomizer msValue) throws AWTException {
        this.right=right;
        this.rightms=rightms;
        this.msValue=msValue;
    }

    public void rightClick(int ms) {
        this.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        try {
            Thread.sleep((long) (ms/2.11));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
                rightClick(msValue.msReturn((int)Double.parseDouble(rightms.getText())));
            }
        }
    }
}
