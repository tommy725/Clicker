import java.util.Random;

public class MsRandomizer {
    Slider percent;
    CheckBox OnOff;
    Random random = new Random();
    public MsRandomizer(Slider percent,CheckBox OnOff) {
        this.percent=percent;
        this.OnOff=OnOff;
    }

    public int msReturn(int presentMs) {
        if(OnOff.isSelected()){
            return random.nextInt(2*presentMs*percent.getValue()/100)+presentMs-(presentMs*percent.getValue()/100);
        }
        else{
            return presentMs;
        }
    }
}
