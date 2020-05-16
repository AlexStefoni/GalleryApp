package json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonMainTest {

    public static void main(String[] args) {
       JSONObject obj = JsonUtils.getJSONObjectFromFile("/user.json");

        ArrayList<User> list = new ArrayList<User>();
        JSONArray arr = obj.getJSONArray("json.User");




     System.out.println(JsonUtils.credentialTest("alex","bob"));
      //json.User alex=new json.User("alex","bob",true,"Alex ","acasa");
      //json.JsonUtils.registerNewUser(alex);
    }
}
