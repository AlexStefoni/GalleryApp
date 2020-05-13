

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class FileHandler{

    public static InputStream inputStreamFromFile(String path) {
        try {
            InputStream inputStream = FileHandler.class.getResourceAsStream(path);
            return inputStream;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   




}
