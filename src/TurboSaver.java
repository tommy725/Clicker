import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TurboSaver {
    ObjectMapper objectMapper;
    public TurboSaver() {
    }
    public void saveToJSON(Settings o) throws IOException, JsonMappingException {
        objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("settings.json"),o);
    }
    public Settings readFromJSON() throws IOException {
        objectMapper = new ObjectMapper();
        File file = new File("settings.json");
        if(file.exists()) {
            return objectMapper.readValue(new File("settings.json"), Settings.class);
        }else{
            return new Settings(false,false,false,5,"MouseButton4","MouseButton5",80.0,40.0);
        }
    }
}
