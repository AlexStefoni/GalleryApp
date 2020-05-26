package NewSuff;

import json.FileHandler;
import json.JsonUtils;
import json.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.Scanner;

import static json.JsonUtils.decode;

public class UserHandle {

    JSONObject obj=new JSONObject();

    public void RegUser(User u) {

        System.out.println(new File("USER").mkdir());

        try {

            File myFile = new File("USER//account.json");

            if (myFile.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            File myFile = new File("USER//account.json");
            if (myFile.length() == 0) {
                JSONObject aux=new JSONObject();
                aux.put("user","alex");
                JSONArray arr=new JSONArray();
                arr.put(u.toJsonObj());
                obj.put("USERS",arr);




            } else {
                obj = new JSONObject(this.getJSONStringFromFile());
                JSONArray arr = obj.getJSONArray("USERS");
                arr.put(u.toJsonObj());
            }
                FileWriter myWriter = new FileWriter("USER//account.json");
                myWriter.write(obj.toString(4));
                myWriter.close();
                System.out.println("Successfully wrote to the file.");

            } catch(IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

    }

    public InputStream inputStreamFromFile() {
        try {

            return new FileInputStream("USER//account.json");

        }catch(Exception excpt)
        {
            // in case of I/O error
            excpt.printStackTrace();
        }

        return null;
    }

    public String getJSONStringFromFile() {

        Scanner scanner;
        InputStream in = this.inputStreamFromFile();
        scanner = new Scanner(in);
        String json = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return json;
    }

    public Boolean CredentialTest(String u,String p){
        obj = new JSONObject(this.getJSONStringFromFile());

        JSONArray arr=obj.getJSONArray("USERS");
        for(int i=0;i<arr.length();i++){
            //System.out.println(decode(arr.getJSONObject(i).get("password").toString()));
            if((arr.getJSONObject(i).get("username").toString().equals(u)) &&
                    (decode(arr.getJSONObject(i).get("password").toString()).equals(p)))
                return true;
        }
        return false;
    }

    public Boolean ifArtist(String  u,String p){

        obj = new JSONObject(this.getJSONStringFromFile());


        JSONArray arr=obj.getJSONArray("USERS");
        for(int i=0;i<arr.length();i++){
            //System.out.println(decode(arr.getJSONObject(i).get("password").toString()));
            if((arr.getJSONObject(i).get("username").toString().equals(u)) &&
                    (decode(arr.getJSONObject(i).get("password").toString()).equals(p)))
                return ((Boolean) arr.getJSONObject(i).get("artist"));
        }

        return false;
    }
    public Boolean ifAllreadyExists(String u) {
        if(!this.fileExists())return true;
        obj = new JSONObject(this.getJSONStringFromFile());


        JSONArray arr = obj.getJSONArray("USERS");
        for (int i = 0; i < arr.length(); i++) {
            //System.out.println(decode(arr.getJSONObject(i).get("password").toString()));
            if ((arr.getJSONObject(i).get("username").toString().equals(u))) return false;
        }
        return true;
    }

    public boolean fileExists(){

        File file=new File("USER//account.json");
        if (file.length() == 0) return false;
        return true;
    }

    public User getUser(String u,String p){
        User user=new User("0","0",false,"0","0","0");
        if(!this.fileExists()) {
            obj = new JSONObject(this.getJSONStringFromFile());

            JSONArray arr=obj.getJSONArray("USERS");
            for(int i=0;i<arr.length();i++){
                //System.out.println(decode(arr.getJSONObject(i).get("password").toString()));
                if((arr.getJSONObject(i).get("username").toString().equals(u)) &&
                        (decode(arr.getJSONObject(i).get("password").toString()).equals(p)))
                {
                    user=new User(arr.getJSONObject(i).get("username").toString(),
                            arr.getJSONObject(i).get("username").toString(),
                            arr.getJSONObject(i).getBoolean("artist"),
                            arr.getJSONObject(i).get("full_name").toString(),
                            arr.getJSONObject(i).get("address").toString(),
                            arr.getJSONObject(i).get("phone").toString()
                    );
                }
            }
        }
        return user;
    }
}
