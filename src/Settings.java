public class Settings {
    boolean inputInCPS=false;
    boolean holdMode=false;
    boolean msRandomizer=false;
    int randomPercent=10;
    String leftHotkey="MouseButton4";
    String rightHotkey="MouseButton5";
    double leftMs=80.0;
    double rightMs=40.0;
    boolean save=false;

    public Settings() {
    }

    public Settings(boolean inputInCPS, boolean holdMode, boolean msRandomizer, int randomPercent, String leftHotkey, String rightHotkey, double leftMs, double rightMs,boolean save) {
        this.inputInCPS = inputInCPS;
        this.holdMode = holdMode;
        this.msRandomizer = msRandomizer;
        this.randomPercent = randomPercent;
        this.leftHotkey = leftHotkey;
        this.rightHotkey = rightHotkey;
        this.leftMs = leftMs;
        this.rightMs = rightMs;
        this.save = save;
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

    public double getLeftMs() {
        return leftMs;
    }

    public void setLeftMs(double leftMs) {
        this.leftMs = leftMs;
    }

    public double getRightMs() {
        return rightMs;
    }

    public void setRightMs(double rightMs) {
        this.rightMs = rightMs;
    }

    public boolean isSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }
}
