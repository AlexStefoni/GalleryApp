package NewSuff;

import items.Artwork;
import json.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import static json.JsonUtils.decode;

public class ArtHandle {
    JSONObject obj=new JSONObject();



    public void regArt(User account, Artwork a,String artPath){

        System.out.println(new File("dataArt").mkdir());


        try {

            File myFile = new File("dataArt//art.json");

            if (myFile.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path="dataArt//picData//"+account.name();
        System.out.println(new File("dataArt//picData").mkdir());
        System.out.println(new File(path).mkdir());

        try {
            File myFile = new File("dataArt//art.json");

            if (myFile.length() == 0) {
                a.setPicPath(this.PicReader(account,artPath));
                JSONArray arr=new JSONArray();
                arr.put(a.artToJson());
                obj.put(account.name(),arr);

            } else {
                a.setPicPath(this.PicReader(account,artPath));
                obj = new JSONObject(this.getJSONStringFromFile());
                if(obj.has(account.name())) {
                    JSONArray arr = obj.getJSONArray(account.name());
                    arr.put(a.artToJson());
                }else{
                    JSONArray arr=new JSONArray();
                    arr.put(a.artToJson());
                    obj.put(account.name(),arr);
                }

            }


            FileWriter myWriter = new FileWriter("dataArt//art.json");
            myWriter.write(obj.toString(4));
            myWriter.close();
            System.out.println("Successfully wrote to the file dataart.");

        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }


    public InputStream inputStreamFromFile() {
        try {

            return new FileInputStream("dataArt//art.json");

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

    public String PicReader(User account,String path){

        String name = Paths.get(path).getFileName().toString();
        System.out.println(name);
        String newPath="dataArt//picData//"+account.name()+"//"+name;
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
