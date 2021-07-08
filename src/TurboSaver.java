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
        objectMapper.writeValue(new File("src/settings.json"),o);

    }
    public Settings readFromJSON() throws IOException {
        objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/settings.json"), Settings.class);
    }
}
