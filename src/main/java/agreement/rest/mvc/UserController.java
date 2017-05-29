package agreement.rest.mvc;

import agreement.core.dto.UserDTO;
import agreement.core.exceptions.AccountDoesNotExistException;
import agreement.core.services.UserService;
import agreement.rest.exceptions.NotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Radek on 07.03.2017.
 */
@RestController
@RequestMapping("/rest/user")
public class UserController {

    private UserService userServices;

    @Autowired
    public UserController(UserService userService){
        this.userServices = userService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user){

        return new ResponseEntity<>(userServices.createUser(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user){

        UserDTO updatedUser = userServices.updateUser(user);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userId){

        try {
            UserDTO user = userServices.findById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (AccountDoesNotExistException e){
            throw new NotFoudException("User not foud: " + userId);
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserDTO>> getUsers(){

        List<UserDTO> users = userServices.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteUser(@PathVariable Long userId){

        userServices.deleteUser(userId);

        return new ResponseEntity(HttpStatus.OK);
    }
}
