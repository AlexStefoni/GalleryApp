

public class User {
    private String username;
    private String password;
    private Boolean artist;
    private String full_name;
    private String address;

    public String toString(){
        return " "+username+" ;"+password+" ; "+artist;
    }
    public void setUsername(String x){
        this.username=x;
    }

    public void setPassword(String x){
        this.password=x;
    }

    public void setArtist(Boolean x){
        this.artist=x;
    }

    public void setFull_name(String x){
        this.full_name=x;
    }

    public void setAddress(String x){
        this.address=x;
    }

    public void set(){

    }
}
