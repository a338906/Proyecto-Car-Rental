package verify.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidate {

    public static boolean isValidUsername(String name) {
        String regex = "^[A-Za-z]\\w{4,29}$";

        Pattern p = Pattern.compile(regex);

        if (name == null) {
            return false;
        }

        Matcher m = p.matcher(name);

        return m.matches();
    }
}
