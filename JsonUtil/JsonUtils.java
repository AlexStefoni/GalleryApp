

import org.json.JSONObject;

import java.util.Scanner;
import java.io.InputStream;
public class JsonUtils {


    public static String getJSONStringFromFile(String path) {
        Scanner scanner;
        InputStream in = FileHandler.inputStreamFromFile(path);
        scanner = new Scanner(in);
        String json = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return json;
    }


    public static JSONObject getJSONObjectFromFile(String path) {
        return new JSONObject(getJSONStringFromFile(path));
    }


    public static boolean objectExists(JSONObject jsonObject, String key) {
        Object o;
        try {
            o = jsonObject.get(key);
        } catch(Exception e) {
            return false;
        }
        return o != null;
    }

    public static User get_user_from_json(JSONObject obj ){
        User aux=new User();
        aux.setUsername(obj.getString("username"));
        aux.setPassword(obj.getString("password"));
        aux.setArtist(obj.getBoolean("artist"));
        aux.setFull_name(obj.getString("full_name"));
        aux.setAddress(obj.getString("address"));

        return aux;
    }



}