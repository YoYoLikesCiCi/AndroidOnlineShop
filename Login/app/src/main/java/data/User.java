package data;

public class User {
    private static String uname;
    private static String uid;
    private static String ucontact;
    private static String upassword;
    private static short uage;
    private static boolean usex;

    public static void init(String uid, String upassword){
        User.uname = "游客618A03";
        User.uid = uid;
        User.upassword = upassword;
    }
}
