package agreement.core.services.impl;

import agreement.core.entities.User;
import agreement.core.repositories.UserRepository;
import agreement.core.services.UserServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Radek on 08.03.2017.
 */
class UserServicesImplTest {


    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServicesImpl userServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findUser() {

        User u = new User();
        u.setName("Radek");
        u.setLastName("Kowalski");
        u.setMd5("asdas12312");

        Mockito.when(userRepository.findOne(1L)).thenReturn(u);

        User user = userServices.findUser(1L);
        System.out.println("Last: " + user.getLastName());
    }
}