package agreement.rest.mvc;

import agreement.core.entities.User;
import agreement.core.services.UserServices;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Radek on 28.03.2017.
 */
class UserControllerTest {

    private MockMvc mockMvc;
    @Mock
    private UserServices   userServices;
    @InjectMocks
    private UserController userController;

    @Before
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void getUser() throws Exception {

        User user = new User(1L, "Franek", "Dolas", "asdasfasf");

        mockMvc.perform(get("/rest/user/{userId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Franek")));

        verify(userServices, times(1)).findUser(1L);

    }

}