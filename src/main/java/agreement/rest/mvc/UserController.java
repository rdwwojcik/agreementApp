package agreement.rest.mvc;

import agreement.core.entities.User;
import agreement.core.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        User user1 = userServices.createUser(user);

        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    private ResponseEntity<User> getUser(@PathVariable Long userId){

        User user = userServices.findUser(userId);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
