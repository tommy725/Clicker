import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TurboSaver {
    ObjectMapper objectMapper;
    public TurboSaver() {
    }
    public void saveToJSON(Settings o) throws IOException {
        if(o.isSave()){
            objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("clickerSettings.json"),o);
        }else{
            File settingsFile = new File("clickerSettings.json");
            if(settingsFile.exists()){
                settingsFile.delete();
            }
        }
    }
    public Settings readFromJSON() throws IOException {
        objectMapper = new ObjectMapper();
        File file = new File("clickerSettings.json");
        if(file.exists()) {
            Settings settings = objectMapper.readValue(new File("clickerSettings.json"), Settings.class);
            if (settings.isSave()) {
                return settings;
            }
        }
        return new Settings(false,false,false,5,"MouseButton4","MouseButton5",80.0,40.0,false);
    }
}
