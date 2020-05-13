
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonMainTest {

    public static void main(String[] args) {
        JSONObject obj = JsonUtils.getJSONObjectFromFile("/obj.json");

        ArrayList<User> list = new ArrayList<User>();
        JSONArray arr = obj.getJSONArray("User");

        for (int i = 0; i < arr.length(); i++) {
            list.add(JsonUtils.get_user_from_json(arr.getJSONObject(i)));
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        User bobo=new User();
        bobo.setAddress("pppp");
        bobo.setFull_name("bobovici");
        bobo.setPassword("babanana");
        bobo.setArtist(true);
        bobo.setUsername("bobo");
        arr.put(bobo);
        try (FileWriter file = new FileWriter("obj.json")) {

            file.write(obj.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
