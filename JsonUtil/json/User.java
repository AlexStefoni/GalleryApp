package json;

import org.json.JSONObject;

public class User {
    private String username;
    private String password;
    private Boolean artist;
    private String full_name;
    private String address;
    private String phone;

    public User (String username,String password,Boolean artist,String full_name,String address,String phone){
        this.username=username;
        this.artist=artist;
        this.full_name=full_name;
        this.address=address;
        this.password= JsonUtils.encode(password);
        this.phone=phone;
    }
    public User(){}
    public JSONObject toJsonObj(){
        JSONObject obj =new JSONObject();
        obj.put("username",this.username);
        obj.put("password",this.password);
        obj.put("artist",this.artist);
        obj.put("full_name",this.full_name);
        obj.put("address",this.address);
        obj.put("phone",this.phone);

        return obj;
    }
}
