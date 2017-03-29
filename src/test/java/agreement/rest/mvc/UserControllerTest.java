package agreement.rest.mvc;

import agreement.core.entities.User;
import agreement.core.services.UserServices;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Radek on 29.03.2017.
 */
class UserControllerTest {

    @Mock
    private UserServices userServices;
    @InjectMocks
    private UserController userController;
    private MockMvc mockMvc;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new Object[]{this.userController}).build();
    }

    @Test
    public void createUser() {

    }

    @Test
    public void getUser() throws Exception {
        User user = new User(5L, "Franek", "Dolas", "sdasdas5");

        Mockito.when(this.userServices.findUser(Long.valueOf(Matchers.eq(5L)))).thenReturn(user);

        mockMvc.perform(get("/rest/user/5", new Object[0]))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.name", is("Franek")));

        verify(userServices, times(1)).findUser(5L);
    }

}