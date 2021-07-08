import java.awt.*;
import java.awt.event.InputEvent;

public class Click extends Robot {
    public Click() throws AWTException {
    }

    public void leftClick(int ms) throws InterruptedException {
        this.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(ms/2);
        this.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(ms/2);
    }

    public void rightClick(int ms) throws InterruptedException {
        this.mousePress(InputEvent.BUTTON2_DOWN_MASK);
        Thread.sleep(ms/2);
        this.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
        Thread.sleep(ms/2);
    }
}
