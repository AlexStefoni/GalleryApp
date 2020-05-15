
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonMainTest {

    public static void main(String[] args) {
       JSONObject obj = JsonUtils.getJSONObjectFromFile("/user.json");

        ArrayList<User> list = new ArrayList<User>();
        JSONArray arr = obj.getJSONArray("User");




     System.out.println(JsonUtils.credentialTest("alex","bob"));
      //User alex=new User("alex","bob",true,"Alex ","acasa");
      //JsonUtils.registerNewUser(alex);
    }
}
