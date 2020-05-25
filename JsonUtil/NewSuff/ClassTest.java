package NewSuff;

import json.User;

public class ClassTest {
    public static void main(String[] args) {
        UserHandle u = new  UserHandle();
        u.RegUser(new User("alex","bob",true,"Alex ","acasa","000"));
        System.out.println(u.ifArtist("alex","bob"));
        System.out.println(u.CredentialTest("alex","bob"));
        System.out.println(u.CredentialTest("alex","bobb"));
        System.out.println(u.ifAllreadyExists("alex","bob"));
        System.out.println(u.ifAllreadyExists("pepe","pepe"));
    }
}
