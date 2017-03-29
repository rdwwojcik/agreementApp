package agreement.rest.mvc;

import agreement.core.entities.User;
import agreement.core.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by Radek on 07.03.2017.
 */
@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user){

        user.setMd5(generateMd5(user.getPassword()));
        user.setCreationDate(new Date());
        user.setModificationDate(new Date());

        User newUser = userServices.createUser(user);

        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> getUser(@PathVariable Long userId){

        User user = userServices.findUser(userId);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    private String generateMd5(String password) {
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
