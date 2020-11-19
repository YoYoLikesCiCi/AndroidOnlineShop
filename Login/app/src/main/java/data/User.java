package data;

public class User {
    private static String uname;
    private static String uid;
    private static String ucontact;
    private static String upassword;
    private static String uage;
    private static String usex;

    public static void init(String uid, String upassword){
        User.uid = uid;
        User.upassword = upassword;
    }

    public static void setUname(String uname){
        User.uname = uname;
    }

    public static String getUname(){
        return uname;
    }

    public static void setUcontact(String ucontact) {
        User.ucontact = ucontact;
    }

    public static String getUcontact() {
        return ucontact;
    }

    public static void setUage(String uage) {
        User.uage = uage;
    }

    public static String getUage() {
        return uage;
    }

    public static void setUsex(String usex) {
        User.usex = usex;
    }

    public static String getUsex() {
        return usex;
    }
}
