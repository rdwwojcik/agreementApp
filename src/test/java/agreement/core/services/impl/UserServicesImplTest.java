package agreement.core.services.impl;

import agreement.core.dto.UserDTO;
import agreement.core.entities.User;
import agreement.core.exceptions.UserRegistrationException;
import agreement.core.mapper.UserMapper;
import agreement.core.mapper.UserMapperImpl;
import agreement.core.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.catchThrowable;

/**
 * Created by Radek on 08.03.2017.
 */
public class UserServicesImplTest {

    private UserMapper mapper = new UserMapperImpl();

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserServicesImpl userServices;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findUser() {

        User u = new User();
        u.setId(1L);
        u.setName("Radek");
        u.setLastName("Kowalski");
        u.setLogin("bkowalski");
        Mockito.when(userRepository.findOne(1L)).thenReturn(u);
        Mockito.when(userMapper.toDTO(u)).thenReturn(mapper.toDTO(u));

        UserDTO user = userServices.findById(1L);

        assertThat(user.hashCode(), equalTo(u.hashCode()));
    }

    @Test
    public void createUser() throws Exception {
        User newUser = getNewUser();
        UserDTO userDTO = mapper.toDTO(newUser);
        Mockito.when(userRepository.save(newUser)).thenReturn(newUser);
        Mockito.when(userMapper.fromDTO(userDTO)).thenReturn(newUser);
        Mockito.when(userMapper.toDTO(newUser)).thenReturn(userDTO);

        UserDTO result = userServices.createUser(userDTO);

        assertThat(result, is(notNullValue()));
        verify(userRepository).save((User) any());
        verify(userRepository, times(1)).save(newUser);
    }

    @Test
    public void createUser_Should_Throw_Exception_User_Exist(){
        User user = getNewUser();

        Mockito.when(userRepository.findByLogin(user.getLogin())).thenReturn(user);
        Mockito.when(userMapper.toDTO(user)).thenReturn(getNewUserDTO());

        final Throwable throwable = catchThrowable(() -> userServices.createUser(getNewUserDTO()));

        System.out.println();

        Assertions.assertThat(throwable)
                .isInstanceOf(UserRegistrationException.class);
    }

    @Test
    public void updateUser() throws Exception {

    }

    @Test
    public void findById() throws Exception {

    }

    @Test
    public void findByLogin() throws Exception {

    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {

    }

    private User getNewUser(){
        User newUser = new User();
        newUser.setId(1L);
        newUser.setName("Kacper");
        newUser.setLastName("Wójcik");
        newUser.setLogin("kwojcik");
        newUser.setPassword("kacperek");

        return newUser;
    }

    private UserDTO getNewUserDTO(){
        return mapper.toDTO(getNewUser());
    }
}