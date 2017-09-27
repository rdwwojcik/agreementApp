package agreement.config;

import agreement.core.dto.CurrentUser;
import agreement.core.dto.UserDTO;
import agreement.core.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Radek on 31.08.2017.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final static Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDTO userDTO = userService.findByLogin(s);

        logger.info("Password: " + userDTO.getPassword());
        logger.info("PasswordHash: " + userDTO.getPasswordHash());

        if(userDTO != null){
            return new CurrentUser(userDTO);
        }
        else{
            throw new UsernameNotFoundException("User not found for login: " + userDTO.getLogin());
        }
    }
}
