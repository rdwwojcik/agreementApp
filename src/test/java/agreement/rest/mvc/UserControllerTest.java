package agreement.rest.mvc;

import agreement.core.dto.UserDTO;
import agreement.core.entities.User;
import agreement.core.exceptions.AccountDoesNotExistException;
import agreement.core.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Radek on 29.03.2017.
 */
public class UserControllerTest {

    @Mock
    private UserService userServices;
    @InjectMocks
    private UserController userController;
    private MockMvc mockMvc;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new Object[]{this.userController}).build();
    }

    @Test
    public void getUserSuccess() throws Exception {

        UserDTO user = new UserDTO(5L, "Franek", "Dolas", "fDolas");
        Mockito.when(this.userServices.findById(Long.valueOf(Matchers.eq(5L)))).thenReturn(user);
        mockMvc.perform(get("/rest/user/5", new Object[0]))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.name", is("Franek")))
                .andExpect(jsonPath("$.lastName", is("Dolas")))
                .andExpect(jsonPath("$.login", is("fDolas")));

        verify(userServices, times(1)).findById(5L);
    }

    @Test
    public void getUserFail() throws Exception {

        Mockito.when(userServices.findById(1L)).thenThrow(AccountDoesNotExistException.class);
        mockMvc.perform(get("/rest/user/1", new Object[0]))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void createUserWithSuccess() throws Exception {
        UserDTO user = new UserDTO(5L, "Franek", "Dolas", "Franco");
        user.setPassword("dolllas");

        Mockito.when(userServices.createUser((UserDTO) Matchers.any(UserDTO.class))).thenReturn(user);
        mockMvc.perform(post("/rest/user")
                .content("{\"id\":5,\"name\":\"Franek\",\"lastName\":\"Dolas\",\"login\":\"Franco\",\"password\":\"dolllas\"}")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.name", is("Franek")))
                .andExpect(jsonPath("$.lastName", is("Dolas")))
                .andExpect(jsonPath("$.login", is("Franco")));

    }
}