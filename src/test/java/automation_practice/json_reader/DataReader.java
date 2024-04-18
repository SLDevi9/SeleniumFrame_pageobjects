package automation_practice.json_reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader
{

    public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
    {
        //read json to String
        String jsonContent = FileUtils.readFileToString(new File(filepath));
        //String to HashMap Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }
}
