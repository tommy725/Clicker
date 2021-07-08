import java.awt.*;
import java.awt.event.InputEvent;

public class Click extends Robot {
    public Click() throws AWTException {
    }

    public void leftClick(int ms) throws InterruptedException {
        this.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        this.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //TimeUnit.MILLISECONDS.sleep(ms);
        Thread.sleep(ms);
    }

    public void rightClick(int ms) throws InterruptedException {
        this.mousePress(InputEvent.BUTTON2_DOWN_MASK);
        this.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
        //TimeUnit.MILLISECONDS.sleep(ms);
        Thread.sleep(ms);
    }
}
