package json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Base64;
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
        User aux=new User(obj.getString("username"),
                obj.getString("password"),
                obj.getBoolean("artist"),
                obj.getString("full_name"),
                obj.getString("address"));


        return aux;
    }

    public static String jsonAdder(JSONObject obj_prime,JSONObject obj,String mode){
        JSONArray arr = obj_prime.getJSONArray(mode);
        arr.put(obj);
        return obj_prime.toString(4);
    }

    public static boolean credentialTest(String u,String p){
        JSONObject obj = JsonUtils.getJSONObjectFromFile("/user.json");


        JSONArray arr=obj.getJSONArray("User");
        for(int i=0;i<arr.length();i++){
            System.out.println(decode(arr.getJSONObject(i).get("password").toString()));
            if((arr.getJSONObject(i).get("username").toString().equals(u)) &&
                    (decode(arr.getJSONObject(i).get("password").toString()).equals(p)))
            return true;
        }


        return false;
    }
    public static void registerNewUser(User user){
        JSONObject obj = JsonUtils.getJSONObjectFromFile("/user.json");
        FileHandler.jsonWriter(JsonUtils.jsonAdder(obj,user.toJsonObj(),"User"),"assets/user.json");
    }

    public static String encode(String s){
        String encodedString = Base64.getEncoder().encodeToString(s.getBytes());
        return encodedString;
    }
    public static String decode(String s){
        byte[] decodedBytes = Base64.getDecoder().decode(s);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }
}
