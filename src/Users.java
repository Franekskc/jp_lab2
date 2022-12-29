import java.util.HashMap;

public class Users {

    HashMap<String,char[]> users = new HashMap<>();

    public Users() {
        users.put("admin","admin".toCharArray());
        users.put("robert.maklowicz","123".toCharArray());
        users.put("hello","world".toCharArray());
    }
}
