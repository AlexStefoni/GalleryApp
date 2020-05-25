package NewSuff;

import items.Artwork;
import json.User;

public class ClassTest {
    public static void main(String[] args) {
        UserHandle u = new  UserHandle();

        User u1=new User("alex","bob",true,"Alex ","acasa","000");
        User u2=new User("bob","alex",true,"Alex ","acasa","000");

        u.RegUser(u1);
        u.RegUser(u2);

        Artwork a1=new Artwork("pop0","dd",32,22,33);
        Artwork a2=new Artwork("pop1","dd",32,22,33);
        Artwork a3=new Artwork("pop2","dd",32,22,33);
        Artwork a4=new Artwork("pop3","dd",32,22,33);
        Artwork a5=new Artwork("pop4","dd",32,22,33);

        ArtHandle art=new ArtHandle();


        art.regArt(u1,a1,"C://Users//alexs//Desktop//STUFF//de scos//IMG_20190818_221449.jpg");
        art.regArt(u1,a2,"C://Users//alexs//Desktop//STUFF//de scos//IMG_20190814_034818_20190814041549244.jpg");
        art.regArt(u2,a3,"C://Users//alexs//Desktop//STUFF//de scos//IMG_20190818_220440.jpg");
        art.regArt(u1,a4,"C://Users//alexs//Desktop//STUFF//de scos//IMG_20190804_084230.jpg");
        art.regArt(u2,a5,"C://Users//alexs//Desktop//STUFF//de scos//IMG_20190826_125108.jpg");


    }
}
