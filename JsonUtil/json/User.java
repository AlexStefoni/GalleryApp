package json;

import json.JsonUtils;
import org.json.JSONObject;

public class User {
    private String username;
    private String password;
    private Boolean artist;
    private String full_name;
    private String address;

    public User (String username,String password,Boolean artist,String full_name,String address){
        this.username=username;
        this.artist=artist;
        this.full_name=full_name;
        this.address=address;
        this.password= JsonUtils.encode(password);
    }
    public User(){}
    public JSONObject toJsonObj(){
        JSONObject obj =new JSONObject();
        obj.put("username",this.username);
        obj.put("password",this.password);
        obj.put("artist",this.artist);
        obj.put("full_name",this.full_name);
        obj.put("address",this.address);

        return obj;
    }
}
