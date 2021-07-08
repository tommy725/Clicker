public class Settings {
    boolean inputInCPS=false;
    boolean holdMode=false;
    boolean msRandomizer=false;
    int randomPercent=5;
    String leftHotkey="MouseButton4";
    String rightHotkey="MouseButton5";
    int leftMs=80;
    int rightMs=40;

    public Settings() {
    }

    public Settings(boolean inputInCPS, boolean holdMode, boolean msRandomizer, int randomPercent, String leftHotkey, String rightHotkey, int leftMs, int rightMs) {
        this.inputInCPS = inputInCPS;
        this.holdMode = holdMode;
        this.msRandomizer = msRandomizer;
        this.randomPercent = randomPercent;
        this.leftHotkey = leftHotkey;
        this.rightHotkey = rightHotkey;
        this.leftMs = leftMs;
        this.rightMs = rightMs;
    }

    public boolean isInputInCPS() {
        return inputInCPS;
    }

    public void setInputInCPS(boolean inputInCPS) {
        this.inputInCPS = inputInCPS;
    }

    public boolean isHoldMode() {
        return holdMode;
    }

    public void setHoldMode(boolean holdMode) {
        this.holdMode = holdMode;
    }

    public boolean isMsRandomizer() {
        return msRandomizer;
    }

    public void setMsRandomizer(boolean msRandomizer) {
        this.msRandomizer = msRandomizer;
    }

    public int getRandomPercent() {
        return randomPercent;
    }

    public void setRandomPercent(int randomPercent) {
        this.randomPercent = randomPercent;
    }

    public String getLeftHotkey() {
        return leftHotkey;
    }

    public void setLeftHotkey(String leftHotkey) {
        this.leftHotkey = leftHotkey;
    }

    public String getRightHotkey() {
        return rightHotkey;
    }

    public void setRightHotkey(String rightHotkey) {
        this.rightHotkey = rightHotkey;
    }

    public int getLeftMs() {
        return leftMs;
    }

    public void setLeftMs(int leftMs) {
        this.leftMs = leftMs;
    }

    public int getRightMs() {
        return rightMs;
    }

    public void setRightMs(int rightMs) {
        this.rightMs = rightMs;
    }
}