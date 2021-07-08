import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

public class TurboSaver {
    XStream xstream;
    public TurboSaver() {
        xstream = new XStream();
        xstream.alias("settings",Settings.class);
        xstream.addPermission(AnyTypePermission.ANY);
    }
    public void saveToXML(Settings o) throws IOException {
        String xml = xstream.toXML(o);
        File file = new File("src/Save.xml");
        if(file.exists()){
            FileWriter fw = new FileWriter("src/Save.xml");
            fw.write(xml);
            fw.close();
        }
    }
    public Settings readFromXML() throws IOException {
        File file = new File("src/Save.xml");
        if(file.exists()){
            return (Settings)xstream.fromXML(Files.readString(Paths.get("src/Save.xml")));
        }
        return null;
    }
}
