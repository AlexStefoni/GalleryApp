package items;

import netscape.javascript.JSObject;
import org.json.JSONObject;

public class Artwork {
    private String title;
    private String picture_path;
    private String material;
    private String price;
    private String size;

    public Artwork(
                   String title,
                   String material,
                   String price,
                   String size
                   ){
        this.title=title;
        //this.picture_path=ArtworkUtils.imageReader(picture_path);
        this.material=material;
        this.price=price;
        this.size=size;

    }

    public JSONObject artToJson(){
        JSONObject obj=new JSONObject();
        obj.put("title",title);
        obj.put("picture_path",picture_path);
        obj.put("material",material);
        obj.put("price",price);
        obj.put("size",size);
        return obj;
    }
    public void setPicPath(String path){
        this.picture_path=path;
    }
    public String getRelativePath(){
        return this.picture_path;
    }
}
