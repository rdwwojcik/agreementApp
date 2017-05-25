package agreement.core.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Radek on 30.03.2017.
 */
public class Password {

    public static String generateMd5(String password) {
        byte[] pass = null;
        MessageDigest digest = null;

        try {
            pass = password.getBytes("UTF-8");
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return new String(digest.digest(pass));
    }
}
