package items;

public class ArtMainTest {
    public static void main(String[] args) {
        Artwork a=new Artwork("alex",
                "ceva"
                ,"C:\\Users\\alexs\\Desktop\\f1.jpeg"
                ,"thin air",
                99.99,
                20,
                30);
        ArtworkUtils.registerNewArtwork(a);
        System.out.println(0);
    }
}
