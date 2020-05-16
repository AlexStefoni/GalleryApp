package items;
import json.JsonUtils;
import org.json.JSONObject;
import json.FileHandler;



public class ArtworkUtils {
    public static void registerNewArtwork(Artwork art){
        JSONObject obj = JsonUtils.getJSONObjectFromFile("/artwork.json");
        FileHandler.jsonWriter(JsonUtils.jsonAdder(obj,art.artToJson(),"listings"),"assets/artwork.json");
    }

    
}
