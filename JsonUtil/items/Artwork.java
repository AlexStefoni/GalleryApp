package items;

import netscape.javascript.JSObject;
import org.json.JSONObject;

public class Artwork {
    private String author_name;
    private String title;
    private String picture_path;
    private String material;
    private double price;
    private String size;

    public Artwork(String author_name,
                   String title,
                   String picture_path,
                   String material,
                   double price,
                   int size_x,
                   int size_y){
        this.author_name=author_name;
        this.title=title;
        this.picture_path=ArtworkUtils.imageReader(picture_path);
        this.material=material;
        this.price=price;
        this.size=size_x+" x "+size_y;

    }

    public JSONObject artToJson(){
        JSONObject obj=new JSONObject();
        obj.put("author_name",author_name);
        obj.put("title",title);
        obj.put("picture_path",picture_path);
        obj.put("material",material);
        obj.put("price",price);
        obj.put("size",size);
        return obj;
    }
}
