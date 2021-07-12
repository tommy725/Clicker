import java.awt.*;
import java.awt.event.InputEvent;

public class ClickLeft extends Robot implements Runnable{
    CheckBox left;
    TextField leftms;
    public ClickLeft(CheckBox left, TextField leftms) throws AWTException {
        this.left=left;
        this.leftms=leftms;
    }

    public void leftClick(int ms) {
        //System.out.println("Left click press");
        this.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        try {
            Thread.sleep((long)(ms/2.11));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Left click release");
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
                leftClick((int)Double.parseDouble(leftms.getText()));
            }
        }
    }
}
