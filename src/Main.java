import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Settings set = new Settings();
            TurboSaver saver = new TurboSaver();
            saver.saveToXML(set);
            System.out.println(saver.readFromXML().isHoldMode());
            new Clicker();
        }catch(IOException ex){
            System.out.println("Error: "+ex);
        }
    }
}

