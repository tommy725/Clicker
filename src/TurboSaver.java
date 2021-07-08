import com.thoughtworks.xstream.XStream;

public class TurboSaver {
    XStream xstream;
    public TurboSaver() {
        xstream = new XStream();
        xstream.alias("settings",Settings.class);
    }
    public void saveToXML(Object o){
        xstream.toXML(o);
    }
}
