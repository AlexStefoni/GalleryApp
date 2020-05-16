package items;
import json.JsonUtils;
import org.json.JSONObject;
import json.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class ArtworkUtils {
    public static void registerNewArtwork(Artwork art){
        JSONObject obj = JsonUtils.getJSONObjectFromFile("/artwork.json");
        FileHandler.jsonWriter(JsonUtils.jsonAdder(obj,art.artToJson(),"listings"),"assets/artwork.json");
    }
    public static String imageReader(String path){
         String name = Paths.get(path).getFileName().toString();
         System.out.println(name);
         String newPath="assets/pictures/"+name;
         File source = new File(path);
         if(source.exists()) {
             File dest = new File(newPath);

             try {
                 Files.copy(source.toPath(), dest.toPath(),
                         StandardCopyOption.REPLACE_EXISTING);
             } catch (Exception e) {

             }
         }
         return newPath;
    }

}
