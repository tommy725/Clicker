import java.awt.*;
import java.awt.event.InputEvent;

public class ClickLeft extends Robot implements Runnable{
    CheckBox left;
    TextField leftms;
    MsRandomizer msValue;
    public ClickLeft(CheckBox left, TextField leftms, MsRandomizer msValue) throws AWTException {
        this.left=left;
        this.leftms=leftms;
        this.msValue=msValue;
    }

    public void leftClick(int ms) {
        this.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        try {
            Thread.sleep((long)(ms/2.11));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try {
            Thread.sleep((long)(ms/2.11));
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
            if(left.isSelected()){
                leftClick(msValue.msReturn((int)Double.parseDouble(leftms.getText())));
            }
        }
    }
}
